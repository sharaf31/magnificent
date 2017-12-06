package com.hhr.recruitment.dao;

import com.hhr.recruitment.dao.Entities.ApplicationEntity;
import com.hhr.recruitment.dao.Entities.ApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sharaf on 12/4/17.
 */
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, ApplicationId>{
//CrudRepository<ApplicationEntity,ApplicationId> {

    List<ApplicationEntity> findByIdRelatedOffer(String relatedOffer);

   // ApplicationEntity findByIdRelatedOfferAndIdEmail(ApplicationId applicationId);
   //ApplicationEntity findByIdRelatedOfferAndIdEmail(String relatedOffer,String  email);
}
