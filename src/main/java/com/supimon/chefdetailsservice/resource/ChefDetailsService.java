package com.supimon.chefdetailsservice.resource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.supimon.chefdetailsservice.models.ChefDetailsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/chefDetails")
public class ChefDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{chefId}")
    public ChefDetailsItem getChefDetails(@PathVariable("chefId") String chefId) throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/chefapp-eeae0-firebase-adminsdk-tujtr-198a71e00a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://chefapp-eeae0.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

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
