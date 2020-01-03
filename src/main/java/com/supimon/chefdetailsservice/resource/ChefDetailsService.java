package com.supimon.chefdetailsservice.resource;

import com.supimon.chefdetailsservice.models.ChefDetailsItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chefDetails")
public class ChefDetailsService {

    @RequestMapping("/{chefId}")
    public ChefDetailsItem getChefDetails(@PathVariable("chefId") String chefId){
        return new ChefDetailsItem(
                "1234567890",
                "chinese",
                "I am an excellent chef",
                20000,
                "Asamese",
                "bhajan@bhajan.com",
                20
        );
    }
}
