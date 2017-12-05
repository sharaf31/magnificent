package com.hhr.recruitment.service;

import com.hhr.recruitment.dao.ApplicationRepository;
import com.hhr.recruitment.dao.Entities.ApplicationEntity;
import com.hhr.recruitment.dao.Entities.ApplicationId;
import com.hhr.recruitment.dao.Entities.OfferEntity;
import com.hhr.recruitment.dao.OfferRepository;
import com.hhr.recruitment.model.Application;
import com.hhr.recruitment.model.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Service Class for Application
 *
 * Created by sharaf on 12/4/17.
 */
@Component
@EnableTransactionManagement
public class ApplicationService {


    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private OfferRepository offerRepository;

    public Application saveOrUpdate(Application application) throws Exception{


        ApplicationEntity applicationEntity= modelMapper.map(application, ApplicationEntity.class);
        applicationEntity.setId(new ApplicationId(application.getEmail(),application.getRelatedOffer()));
        applicationEntity=applicationRepository.save(applicationEntity);
        OfferEntity offerEntity= offerRepository.findOne(application.getRelatedOffer());
        Integer count=offerEntity.getNoOfApplication();
        count++;
        offerEntity.setNoOfApplication(count);
        offerRepository.save(offerEntity);
        application= modelMapper.map(applicationEntity,Application.class);
        return application;
    }



}
