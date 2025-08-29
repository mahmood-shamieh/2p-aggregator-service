package agency.twoPdigital.vod.aggregator.AggregatorService.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeasonSystemConfig extends SystemInstance{
    private String getAllByShowIdUrl;
}
