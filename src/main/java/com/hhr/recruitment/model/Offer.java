package com.hhr.recruitment.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by sharaf on 12/4/17.
 */
@JsonAutoDetect
@JsonIgnoreProperties
public class Offer {



    private String jobTitle;
    private Date startDate;
    private Integer noOfApplication;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNoOfApplication() {
        return noOfApplication;
    }

    public void setNoOfApplication(Integer noOfApplication) {
        this.noOfApplication = noOfApplication;
    }


    @Override
    public String toString() {
        return "Offer{" +
                "jobTitle='" + jobTitle + '\'' +
                ", startDate=" + startDate +
                ", noOfApplication=" + noOfApplication +
                '}';
    }
}
