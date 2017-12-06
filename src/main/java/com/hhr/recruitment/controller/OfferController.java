package com.hhr.recruitment.controller;

import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for OfferEntity
 *
 * Created by sharaf on 12/4/17.
 */
@RestController
@RequestMapping(value = "/offer",produces = MediaType.APPLICATION_JSON_VALUE)
public class OfferController {

    @Autowired
    private OfferService offerService;


    private Logger log= LoggerFactory.getLogger(OfferController.class);

    @RequestMapping(method = RequestMethod.PUT)
    public String createOffer(@RequestBody Offer offer){

        log.info("PUT:/offer/ is invoked");
       try {
           offer.setNoOfApplication(0);
           Offer offerResults=offerService.saveOrUpdate(offer);
           return new String("Successfully created for :"+offerResults.getJobTitle());
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Offer getOneOffer(@PathVariable final String id){
        log.info("GET:/offer/{id} is invoked");
        try {
            return offerService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Offer> getAllOffer(){
        log.info("GET:/offer/ is invoked");
        try {
            List<Offer> offerResults=offerService.getAll();
            return  offerResults;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}
