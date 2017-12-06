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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferEntity)) return false;

        OfferEntity that = (OfferEntity) o;

        if (getJobTitle() != null ? !getJobTitle().equals(that.getJobTitle()) : that.getJobTitle() != null)
            return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        return getNoOfApplication() != null ? getNoOfApplication().equals(that.getNoOfApplication()) : that.getNoOfApplication() == null;

    }

    @Override
    public int hashCode() {
        int result = getJobTitle() != null ? getJobTitle().hashCode() : 0;
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getNoOfApplication() != null ? getNoOfApplication().hashCode() : 0);
        return result;
    }
}
