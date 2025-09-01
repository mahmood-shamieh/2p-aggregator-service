package agency.twoPdigital.vod.aggregator.AggregatorService.model;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MediaModel {

    private Long id;

    private String url;

    private int durationMinutes;

    private String title;

    private Boolean activated = false;


    private EpisodeModel episode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
