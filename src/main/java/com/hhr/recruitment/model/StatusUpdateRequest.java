package com.hhr.recruitment.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sharaf on 12/7/17.
 */
@JsonAutoDetect
@JsonIgnoreProperties
public class StatusUpdateRequest {

    private String nextStatus;

    public String getNextStatus () {
        return nextStatus;
    }

    public void setNextStatus ( String nextStatus ) {
        this.nextStatus = nextStatus;
    }
}
