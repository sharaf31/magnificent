package com.hhr.recruitment.dao.Entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * JPA objects for Application
 *
 * Created by sharaf on 12/4/17.
 */
@Entity
@Table(name = "JOB_APPLICANT")
public class ApplicationEntity {


    @EmbeddedId
    private ApplicationId id;

    @Column(name = "resume")
    private String resume;

    @Column(name="status")
    private String status;

    public ApplicationId getId() {
        return id;
    }

    public void setId(ApplicationId id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
