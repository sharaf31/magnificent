package com.hhr.recruitment.controller;

import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.service.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for OfferEntity
 *
 * Created by sharaf on 12/4/17.
 */
@RestController
@RequestMapping(value = "/offer",produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value="HR Systems", description="Operations for Offer")
public class OfferController {

    @Autowired
    private OfferService offerService;


    private Logger log= LoggerFactory.getLogger(OfferController.class);

    @ApiOperation(value = "Create new  offer")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer){

        log.info("PUT:/offer/ is invoked");
       try {
           offer.setNoOfApplication(0);
           Offer offerResults=offerService.saveOrUpdate(offer);
           return new ResponseEntity(offerResults.toString(), HttpStatus.CREATED);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity(e.getCause(),HttpStatus.BAD_REQUEST);}

    }

    @ApiOperation(value = "View one Offer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Offer> getOneOffer(@PathVariable final String id){
        log.info("GET:/offer/{id} is invoked");
        try {
            Offer offer= offerService.findById(id);
           return new ResponseEntity(offer, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getCause(),HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "View a all Offers", response = Iterable.class)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Offer>> getAllOffer(){
        log.info("GET:/offer/ is invoked");
        try {
            List<Offer> offerResults=offerService.getAll();
            return new ResponseEntity(offerResults, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getCause(),HttpStatus.NOT_FOUND);
        }

    }


}
