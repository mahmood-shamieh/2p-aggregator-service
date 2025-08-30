package agency.twoPdigital.vod.aggregator.AggregatorService.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T body;
}
