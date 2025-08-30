package agency.twoPdigital.vod.aggregator.AggregatorService.service;

import agency.twoPdigital.vod.aggregator.AggregatorService.config.ServiceConfigurations;
import agency.twoPdigital.vod.aggregator.AggregatorService.exception.UnKnownGetShowException;
import agency.twoPdigital.vod.aggregator.AggregatorService.model.ApiResponse;
import agency.twoPdigital.vod.aggregator.AggregatorService.utils.WebClientQualifierOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ShowService {
    final ServiceConfigurations serviceConfigurations;
    final WebClient showWebClient;

    @Autowired
    ShowService(@Qualifier(WebClientQualifierOptions.SHOW_WEB_CLIENT) WebClient webClient
            , ServiceConfigurations serviceConfigurations) {
        this.showWebClient = webClient;
        this.serviceConfigurations = serviceConfigurations;
    }

    public Mono<ApiResponse> getAllShowWithSearchAndPaginationForView(String searchQuery, int page, int size) {
        String endpoint = serviceConfigurations.getShowService().getGetAllShowWithSearchAndPaginationUrlForView();
        endpoint = endpoint.replace("{size}", String.valueOf(size));
        endpoint = endpoint.replace("{page}", String.valueOf(page));
        endpoint = endpoint.replace("{search}", searchQuery == null ? "" : searchQuery);
        return showWebClient.get()
                .uri(endpoint)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .defaultIfEmpty(clientResponse.statusCode().toString())
                                .flatMap(errorBody -> Mono.error(new UnKnownGetShowException()))
                )
                .bodyToMono(ApiResponse.class)
                .timeout(Duration.ofSeconds(serviceConfigurations.getShowService().getTimeOut()))
                .onErrorMap(ex -> new UnKnownGetShowException());

    }

}
