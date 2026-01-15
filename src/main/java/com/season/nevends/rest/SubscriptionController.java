package com.season.nevends.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/v1/subscriptions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class SubscriptionController {



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
