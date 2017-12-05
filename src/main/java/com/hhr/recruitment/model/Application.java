package com.hhr.recruitment.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sharaf on 12/4/17.
 */
@JsonAutoDetect
@JsonIgnoreProperties
public class Application {

    private String relatedOffer;
    private String email;
    private String resume;
    private String applicationStatus;

    public String getRelatedOffer() {
        return relatedOffer;
    }

    public void setRelatedOffer(String relatedOffer) {
        this.relatedOffer = relatedOffer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "relatedOffer='" + relatedOffer + '\'' +
                ", email='" + email + '\'' +
                ", resume='" + resume + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
