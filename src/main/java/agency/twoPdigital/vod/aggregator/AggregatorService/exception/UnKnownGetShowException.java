package agency.twoPdigital.vod.aggregator.AggregatorService.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class UnKnownGetShowException extends CustomException{
public UnKnownGetShowException(){
    super("UnKnown error happened");
}
}
