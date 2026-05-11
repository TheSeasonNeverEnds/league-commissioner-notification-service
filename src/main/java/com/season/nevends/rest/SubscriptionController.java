/*
package com.season.nevends.rest;


import com.season.nevends.service.EmailNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/subscriptions")
public class SubscriptionController {

    private final EmailNotificationService emailNotificationService;
//    private final SmsNotificationService smsNotificationService;

    @PostMapping("/email")
    public ResponseEntity<?> subscribeEmailNotification() {
        return null;
    }

    @DeleteMapping("/email")
    public ResponseEntity<?>  unsubscribeEmailNotification() {
        return null;
    }

    @PostMapping("/push")
    public ResponseEntity<?> subscribePushNotification() {
        return null;
    }

    @DeleteMapping("/push")
    public ResponseEntity<?>  unsubscribePushNotification() {
        return null;
    }

}
*/