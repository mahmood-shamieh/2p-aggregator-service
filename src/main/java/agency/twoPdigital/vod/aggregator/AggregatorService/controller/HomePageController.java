package agency.twoPdigital.vod.aggregator.AggregatorService.controller;

import agency.twoPdigital.vod.aggregator.AggregatorService.config.ServiceConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomePageController {
    ServiceConfigurations serviceConfigurations;
    @Autowired
    public HomePageController(ServiceConfigurations serviceConfigurations){
        this.serviceConfigurations = serviceConfigurations;
    }
    @GetMapping()
    public String test (){
        System.out.println(serviceConfigurations.getSeasonService().getBaseUrl());
        System.out.println(serviceConfigurations.getShowService().getBaseUrl());
        return "hello World";
    }
}
