package com.hhr.recruitment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Implementing Class for the Console Logger
 *
 * Created by sharaf on 12/6/17.
 */
@Primary
@Service
public class NotificationLogImpl implements NotificationService{

    private Logger log = LoggerFactory.getLogger(NotificationLogImpl.class);

    @Override
    public void sendNotification(String applicationEmail, String nextStatus) {
    log.info("Application status for user with email:"+applicationEmail+" has been changed to "+nextStatus);
    }
}
