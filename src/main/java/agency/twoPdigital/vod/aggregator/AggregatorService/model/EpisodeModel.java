package agency.twoPdigital.vod.aggregator.AggregatorService.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EpisodeModel {
    private Long id;

    private int episodeNumber;

    private Long seasonId;

    private String title;

    private String description;

    private List<MediaModel> mediaList;

    private Boolean activated = false;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
