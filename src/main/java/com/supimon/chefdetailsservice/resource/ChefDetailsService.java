package com.supimon.chefdetailsservice.resource;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.supimon.chefdetailsservice.models.ChefDetailsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/chefDetails")
public class ChefDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{chefId}")
    public ChefDetailsItem getChefDetails(@PathVariable("chefId") String chefId) throws InterruptedException, ExecutionException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference chefDetail = db.collection("more-chef-details");
        // Create a query against the collection.
        Query query = chefDetail.whereEqualTo("chefId", chefId);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        ChefDetailsItem chefDetails = new ChefDetailsItem();

        for (QueryDocumentSnapshot document : documents) {
            chefDetails.setPhoneNumber(document.getString("phoneNumber"));
            chefDetails.setSpeciality(document.getString("speciality"));
            chefDetails.setDesc(document.getString("desc"));
            chefDetails.setExpectedSalary(document.getLong("expectedSalary"));
            chefDetails.setMotherTongue(document.getString("motherTongue"));
            chefDetails.setEmailId(document.getString("emailId"));
            chefDetails.setNoticePeriod(document.getLong("noticePeriod"));
            chefDetails.setRating(restTemplate.getForObject("http://ratings-service/ratings/" + chefId, Double.class));
            chefDetails.setRecommendations(restTemplate.getForObject("http://recommendation-service/recommendations/" + chefId, Long.class));
            chefDetails.setVerified(restTemplate.getForObject("http://verification-service/verification/" + chefId, Boolean.class));
        }

        return chefDetails;
    }
}
