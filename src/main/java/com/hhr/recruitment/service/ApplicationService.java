package com.hhr.recruitment.service;

import com.hhr.recruitment.dao.ApplicationRepository;
import com.hhr.recruitment.dao.Entities.ApplicationEntity;
import com.hhr.recruitment.dao.Entities.ApplicationId;
import com.hhr.recruitment.model.Application;
import com.hhr.recruitment.model.Offer;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Class for Application
 * <p>
 * Created by sharaf on 12/4/17.
 */
@Component
@EnableTransactionManagement
public class ApplicationService {


    private Logger log = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private OfferService offerService;

    @Autowired
    private NotificationService notificationService;

    public Application save(Application application) throws Exception {

        if (application.getRelatedOffer() == null || application.getRelatedOffer().equalsIgnoreCase("")) {
            log.error("Offer dont exist");
            throw new Exception("Offer cannot be null");
        }

        if (offerService.findById(application.getRelatedOffer()) == null) {
            log.error("Offer dont exist");
            throw new Exception("Offer don't exist");
        }

        ApplicationId applicationId = new ApplicationId(application.getEmail(), application.getRelatedOffer());

        if (applicationRepository.findOne(applicationId) != null) {
            throw new Exception("Already you have applied");
        }


        ApplicationEntity applicationEntity = modelMapper.map(application, ApplicationEntity.class);
        applicationEntity.setId(applicationId);
        applicationEntity = applicationRepository.save(applicationEntity);

        // Notification for initial status
        notificationService.sendNotification(applicationEntity.getId().getEmail(),applicationEntity.getStatus());

        Offer offer = offerService.findById(application.getRelatedOffer());
        Integer count = offer.getNoOfApplication();
        count++;
        offer.setNoOfApplication(count);
        offerService.saveOrUpdate(offer);
        application = modelMapper.map(applicationEntity, Application.class);
        return application;
    }


    public List<Application> findApplicationOffers(String offerId) throws Exception {
        List<Application> applicationList = new ArrayList<Application>();
        for (ApplicationEntity applicationEntity : applicationRepository.findByIdRelatedOffer(offerId)) {
            Application application = entityToDto(applicationEntity);
            applicationList.add(application);
        }
        return applicationList;
    }


    public Application updateStatus(String offerId, String emailId, String nextStatus) throws Exception {
        if (offerId == null || offerId.equalsIgnoreCase("") || emailId == null || emailId.equalsIgnoreCase("") || nextStatus == null || nextStatus.equalsIgnoreCase(""))
            throw new Exception("Offer Id & Application Id & next Status cannot be null");
        //String email, String relatedOffer
        ApplicationId applicationId = new ApplicationId();
        applicationId.setEmail(emailId);
        applicationId.setRelatedOffer(offerId);
        ApplicationEntity applicationEntity = applicationRepository.findOne(applicationId);
        if (applicationEntity == null) {
            throw new Exception("Application does not exist for this offer");
        }
        applicationEntity.setStatus(nextStatus);
        applicationEntity = applicationRepository.save(applicationEntity);
        // Notification for initial status
        notificationService.sendNotification(applicationEntity.getId().getEmail(),applicationEntity.getStatus());
        return entityToDto(applicationEntity);
    }


    public List<Application> getAll(){
        List<Application> applicationList = new ArrayList<Application>();
        for (ApplicationEntity applicationEntity : applicationRepository.findAll()) {
            Application application = entityToDto(applicationEntity);
            applicationList.add(application);
        }
        return applicationList;
    }

    private Application entityToDto(ApplicationEntity applicationEntity) {
        Application application = modelMapper.map(applicationEntity, Application.class);
        application.setRelatedOffer(applicationEntity.getId().getRelatedOffer());
        application.setEmail(applicationEntity.getId().getEmail());
        return application;
    }


}

