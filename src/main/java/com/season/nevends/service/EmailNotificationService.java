package com.season.nevends.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailNotificationService {

    public void sendEmailNotification(){
        // TODO
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
