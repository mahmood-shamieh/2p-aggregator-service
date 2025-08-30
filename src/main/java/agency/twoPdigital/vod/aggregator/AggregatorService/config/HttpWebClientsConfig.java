package agency.twoPdigital.vod.aggregator.AggregatorService.config;

import agency.twoPdigital.vod.aggregator.AggregatorService.utils.WebClientQualifierOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpWebClientsConfig {
    @Autowired
    ServiceConfigurations serviceConfigurations;

    @Bean
    @Qualifier(WebClientQualifierOptions.SEASON_WEB_CLIENT)
    public WebClient getSeasonWebClient(){
        return WebClient.builder()
                .baseUrl(serviceConfigurations.getSeasonService().getBaseUrl())
                .build() ;
    }
    @Bean
    @Qualifier(WebClientQualifierOptions.SHOW_WEB_CLIENT)
    public WebClient getShowClient(){
        return WebClient.builder()
                .baseUrl(serviceConfigurations.getShowService().getBaseUrl())
                .build() ;
    }
}
