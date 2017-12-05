package com.hhr.recruitment.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by sharaf on 12/4/17.
 */
@JsonAutoDetect
public class OfferApplication {

    private String applicationId;
    private String jobId;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
