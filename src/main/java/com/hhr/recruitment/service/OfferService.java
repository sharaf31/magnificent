package com.hhr.recruitment.service;

import com.hhr.recruitment.dao.Entities.OfferEntity;
import com.hhr.recruitment.dao.OfferRepository;
import com.hhr.recruitment.model.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Class for OfferEntity
 *
 * Created by sharaf on 12/4/17.
 */
@Component
@EnableTransactionManagement
public class OfferService {


    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Offer saveOrUpdate(Offer offer) throws Exception{

        OfferEntity offerEntity=offerRepository.save(modelMapper.map(offer, OfferEntity.class));
        Offer resultDto=modelMapper.map(offerEntity, Offer.class);
        return resultDto;
    }


    public List<Offer> getAll()throws  Exception{
        List<Offer> offerList =  new ArrayList<Offer>();
        for (OfferEntity entity :offerRepository.findAll()){
            offerList.add(modelMapper.map(entity, Offer.class));
        }
        return  offerList;
    }

    public Offer findById(String id) throws Exception{
        OfferEntity offerEntity=offerRepository.findOne(id);
        Offer resultDto=modelMapper.map(offerEntity, Offer.class);
        if (resultDto==null){
            throw new Exception("Offer does not exist on this ID");
        }
        return resultDto;
    }
}
