package com.hhr.recruitment.dao.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

/**
 * Created by sharaf on 12/5/17.
 */
@Embeddable
public class ApplicationId implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "related_offer")
    private String relatedOffer;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelatedOffer() {
        return relatedOffer;
    }

    public void setRelatedOffer(String relatedOffer) {
        this.relatedOffer = relatedOffer;
    }

    public ApplicationId(){

    };
    public ApplicationId(String email, String relatedOffer) {
        this.email = email;
        this.relatedOffer = relatedOffer;
    }
}
