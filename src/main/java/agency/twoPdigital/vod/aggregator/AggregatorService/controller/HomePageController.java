package agency.twoPdigital.vod.aggregator.AggregatorService.controller;

import agency.twoPdigital.vod.aggregator.AggregatorService.config.ServiceConfigurations;
import agency.twoPdigital.vod.aggregator.AggregatorService.model.ApiResponse;
import agency.twoPdigital.vod.aggregator.AggregatorService.service.SeasonService;
import agency.twoPdigital.vod.aggregator.AggregatorService.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class HomePageController {
    private final ShowService showService;
    private final SeasonService seasonService;

    @Autowired
    HomePageController(ShowService showService
            , SeasonService seasonService) {
        this.showService = showService;
        this.seasonService = seasonService;
    }

    @GetMapping(value = "/shows/search/{page}")
    public Mono<ApiResponse> getShowsWithSearchAndPagination(
            @RequestParam(name = "query", required = false) String query,
            @RequestParam(name = "size") int size,
            @PathVariable(name = "page") int page
    ) {
        return showService.getAllShowWithSearchAndPaginationForView(query, page, size);
    }

    @GetMapping(value = "/shows/{showId}/seasons")
    public Mono getSeasonByShowId(
            @PathVariable(name = "showId") Long showId
    ) {
        return seasonService.getSeasonByShowId(showId);
    }
//    @GetMapping(value = "/shows/{showId}")
//    public Mono getShowDetails(
//            @PathVariable(name = "showId") Long showId
//    ) {
//        return seasonService.getSeasonByShowId(showId);
//    }


//    @GetMapping(value = "/seasons/{seasonId}/episodes")
//    public Flux getEpisodesBySeasonId(
//            @PathVariable(name = "seasonId") Long seasonId
//    ) {
//        return Flux.just();
//    }
}
