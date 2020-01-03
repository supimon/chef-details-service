package com.supimon.chefdetailsservice.resource;

import com.supimon.chefdetailsservice.models.ChefDetailsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chefDetails")
public class ChefDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{chefId}")
    public ChefDetailsItem getChefDetails(@PathVariable("chefId") String chefId){
        return new ChefDetailsItem(
                "1234567890",
                "chinese",
                "I am an excellent chef",
                20000,
                "Asamese",
                "bhajan@bhajan.com",
                20,
                restTemplate.getForObject("http://localhost:8081/ratings/" + chefId, Double.class),
                restTemplate.getForObject("http://localhost:8082/recommendations/" + chefId, Integer.class),
                restTemplate.getForObject("http://localhost:8083/verification/" + chefId, Boolean.class)
        );
    }
}
