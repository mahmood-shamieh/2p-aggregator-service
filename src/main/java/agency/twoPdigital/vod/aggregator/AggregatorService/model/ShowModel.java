package agency.twoPdigital.vod.aggregator.AggregatorService.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowModel {
    private Long id;

    private String title;

    private String description;

    private String mediaUrl;

    private LocalDate releaseDate;

    private Boolean activated ;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
