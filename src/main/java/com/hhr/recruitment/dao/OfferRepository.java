package com.hhr.recruitment.dao;

import com.hhr.recruitment.dao.Entities.OfferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sharaf on 12/4/17.
 */
@Repository
public interface OfferRepository  extends CrudRepository<OfferEntity,String>{
}
