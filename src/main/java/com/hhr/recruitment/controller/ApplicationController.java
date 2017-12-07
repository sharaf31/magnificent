package com.hhr.recruitment.controller;

import com.hhr.recruitment.model.Application;
import com.hhr.recruitment.model.Offer;
import com.hhr.recruitment.model.StatusUpdateRequest;
import com.hhr.recruitment.service.ApplicationService;
import com.hhr.recruitment.service.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Rest Controller for Application
 * <p>
 * Created by sharaf on 12/4/17.
 */
@RestController
@RequestMapping(value = "/application",consumes = MediaType.APPLICATION_JSON_VALUE)
@Api(value="HR Systems", description="Operations for Application")
public class ApplicationController {


    private Logger log = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicantService;


    @ApiOperation(value = "Create new Application for an offer")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> submitApplication(@RequestBody Application application) {
        try {
            application=applicantService.save(application);

        } catch (Exception e) {
            log.error("" + e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(application.toString(),HttpStatus.CREATED);
    }




    @ApiOperation(value = "View a list of Applications for Offer", response = Iterable.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> getOneApplication(@PathVariable final String id){
        try {
            return new ResponseEntity(applicantService.findApplicationOffers(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update the status for given application to offer", response = Iterable.class)
    @RequestMapping(value = "/{ApplicationId}/{offerId}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> updateApplicationStatus(@PathVariable final String ApplicationId,@PathVariable final String offerId,@RequestBody StatusUpdateRequest nextStatus){
        try {
            return new ResponseEntity(applicantService.updateStatus(offerId,ApplicationId,nextStatus.getNextStatus()),HttpStatus.OK);
        }catch (Exception e){
            log.error("" + e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "View a list of Applications for all Offer", response = Iterable.class)
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> getAllApplication() {
        List<Application> applicationsList = applicantService.getAll();
        return new ResponseEntity(applicationsList,HttpStatus.OK);

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                setValue(new Date(Long.valueOf(value)));
            }

        });
    }

}
