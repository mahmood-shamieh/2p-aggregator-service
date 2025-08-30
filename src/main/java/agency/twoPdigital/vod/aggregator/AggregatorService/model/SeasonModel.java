package agency.twoPdigital.vod.aggregator.AggregatorService.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeasonModel {
    private Long id;

    private Integer seasonNumber;

    private String title;

    private String description;

    private Long showId;

    private Boolean activated ;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
