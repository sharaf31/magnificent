package com.hhr.recruitment.controller;

import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.model.OfferApplication;
import com.hhr.recruitment.service.OfferApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sharaf on 12/5/17.
 */
@RestController
@RequestMapping(value = "/OfferApplication")
public class OfferApplicationController {

    private Logger log= LoggerFactory.getLogger(OfferApplicationController.class);

    @Autowired
    private OfferApplicationService offerApplicationService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OfferApplication getOneOfferApplication(@PathVariable final String id){
        log.info("GET:/offer/{id} is invoked");
        try {
            return offerApplicationService.findOne(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<OfferApplication> getAllOfferApplication() {
        log.info("GET:/offer/ is invoked");
        try {
            List<OfferApplication> offerResults = offerApplicationService.getAll();
            return offerResults;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
