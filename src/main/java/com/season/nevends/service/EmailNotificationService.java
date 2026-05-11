package com.season.nevends.service;


import com.season.nevends.handler.EmailPublishHandler;
import com.season.nevends.model.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailNotificationService {

    private final EmailPublishHandler emailPublishHandler;

    public void sendEmailNotification(NotificationRequest request) throws IOException {
        emailPublishHandler.publishEmailNotification(request);
    }

    public void subscribeToEmailNotifications(Long userId){
        log.info("Subscribing user {} to email notifications",  userId);
        // TODO: need to think through remaining logic
    }

    public void unsubscribeFromEmailNotifications(@PathVariable Long userId){
        log.info("Unsubscribing user {} email notifications", userId);
        // TODO: need to think through remaining logic
    }

}
