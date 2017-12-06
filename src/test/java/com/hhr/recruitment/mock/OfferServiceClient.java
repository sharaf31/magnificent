package com.hhr.recruitment.mock;

import com.hhr.recruitment.model.Offer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sharaf on 12/6/17.
 */
@Service
public class OfferServiceClient {

    private final RestTemplate restTemplate;

    public OfferServiceClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Offer getOffer(String jobTitle) {
        return restTemplate.getForObject("/{id}",
                Offer.class, jobTitle);
    }
}
