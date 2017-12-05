package com.hhr.recruitment.dao.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * JPA objects for Offer
 *
 * Created by sharaf on 12/4/17.
 */
@Entity
@Table(name = "JOB_OFFER")
public class OfferEntity {


    @Id
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "no_of_applications")
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


}
