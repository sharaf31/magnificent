package com.hhr.recruitment.dao.Entities;

import javax.persistence.*;

/**
 * JPA objects for Application
 *
 * Created by sharaf on 12/4/17.
 */
@Entity
@Table(name = "JOB_APPLICANT" )
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationEntity)) return false;

        ApplicationEntity that = (ApplicationEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getResume() != null ? !getResume().equals(that.getResume()) : that.getResume() != null) return false;
        return getStatus() != null ? getStatus().equals(that.getStatus()) : that.getStatus() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getResume() != null ? getResume().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}
