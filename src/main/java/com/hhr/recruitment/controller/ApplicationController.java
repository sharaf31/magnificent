package com.hhr.recruitment.controller;

import com.hhr.recruitment.model.Application;
import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.service.ApplicationService;
import com.hhr.recruitment.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for Application
 * <p>
 * Created by sharaf on 12/4/17.
 */
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {


    private Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicantService;


    @Autowired
    private OfferService offerService;

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> submitApplication(@RequestBody Application application) {
        log.info("PUT:/application/ is invoked");
        try {
            applicantService.save(application);

        } catch (Exception e) {
            log.error("" + e.getMessage());
            return new ResponseEntity(e.getCause(),HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(application.toString(),HttpStatus.CREATED);
    }




    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> getOneApplication(@PathVariable final String id){
        log.info("GET:/application/{id} is invoked");
        try {
            return new ResponseEntity(applicantService.findApplicationOffers(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{offerId}/{ApplicationId}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> updateApplicationStatus(@PathVariable final String offerId,@PathVariable final String ApplicationId,@RequestBody String nextStatus){
        log.info("POST:/application/{offerId}/{ApplicationId} is invoked");
        try {
            return new ResponseEntity(applicantService.updateStatus(offerId,ApplicationId,nextStatus),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> getAllApplication() {
        log.info("GET:/application/ is invoked");

        List<Application> applicationsList = applicantService.getAll();
        return new ResponseEntity(applicationsList,HttpStatus.OK);

    }

}
