package com.hhr.recruitment.controller;

import com.hhr.recruitment.dao.Entities.OfferEntity;
import com.hhr.recruitment.model.Application;
import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.service.ApplicationService;
import com.hhr.recruitment.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for Application
 *
 * Created by sharaf on 12/4/17.
 */
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {


    private Logger log= LoggerFactory.getLogger(OfferController.class);

    @Autowired
    private ApplicationService applicantService;


    @Autowired
    private OfferService offerService;

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String submitApplication(@RequestBody Application application){
        log.info("PUT:/application/ is invoked");

        try {
            if(application.getRelatedOffer()==null||application.getRelatedOffer().equalsIgnoreCase("")){
                log.error("Offer dont exist");
                throw new Exception("Offer dont exist");
            }


            if(offerService.findById(application.getRelatedOffer())==null){
                log.error("Offer dont exist");
                throw new Exception("Offer dont exist");
            }

            applicantService.saveOrUpdate(application);

        }catch (Exception e){
            log.error("Error Occured"+e.getMessage());
        }
        return new String("OK");
    }



}
