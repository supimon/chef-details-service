package com.supimon.chefdetailsservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
public class ChefDetailsServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChefDetailsServiceApplication.class, args);

		FileInputStream serviceAccount =
				new FileInputStream("src/main/resources/chefapp-eeae0-firebase-adminsdk-tujtr-198a71e00a.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://chefapp-eeae0.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
	}

}
