package com.hhr.recruitment.service;

import org.springframework.stereotype.Service;

/**
 * Created by sharaf on 12/6/17.
 */
@Service
public class NotificationEmailmpl  implements NotificationService{
    @Override
    public void sendNotification(String applicationEmail, String nextStatus) {
        throw new UnsupportedOperationException();
    }
}
