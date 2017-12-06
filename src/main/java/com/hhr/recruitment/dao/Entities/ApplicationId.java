package com.hhr.recruitment.dao.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationId)) return false;

        ApplicationId that = (ApplicationId) o;

        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        return getRelatedOffer() != null ? getRelatedOffer().equals(that.getRelatedOffer()) : that.getRelatedOffer() == null;

    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getRelatedOffer() != null ? getRelatedOffer().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ApplicationId{" +
                "email='" + email + '\'' +
                ", relatedOffer='" + relatedOffer + '\'' +
                '}';
    }
}
