package agency.twoPdigital.vod.aggregator.AggregatorService.service;

import agency.twoPdigital.vod.aggregator.AggregatorService.config.ServiceConfigurations;
import agency.twoPdigital.vod.aggregator.AggregatorService.exception.UnKnownGetSeasonException;
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
public class SeasonService {
    final ServiceConfigurations serviceConfigurations;
    final WebClient seasonWebClient;

    @Autowired
    SeasonService(@Qualifier(WebClientQualifierOptions.SEASON_WEB_CLIENT) WebClient webClient
            , ServiceConfigurations serviceConfigurations) {
        this.seasonWebClient = webClient;
        this.serviceConfigurations = serviceConfigurations;
    }

    public Mono<ApiResponse> getSeasonByShowId(Long showId) {
        String endPoint = serviceConfigurations.getSeasonService().getGetAllByShowIdUrl();
        endPoint = endPoint.replace("{showId}", String.valueOf(showId));
        return seasonWebClient.get()
                .uri(endPoint)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .defaultIfEmpty(clientResponse.statusCode().toString())
                                .flatMap(errorBody -> Mono.error(new UnKnownGetSeasonException()))
                ).bodyToMono(ApiResponse.class)
                .timeout(Duration.ofSeconds(serviceConfigurations.getSeasonService().getTimeOut()))
                .onErrorMap(ex -> new UnKnownGetSeasonException());

    }

}
