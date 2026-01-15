package com.season.nevends.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/v1/notification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {

    @PostMapping("/email")
    public ResponseEntity<?> sendEmailNotification() {
        return null;
    }

    @PostMapping("/push")
    public ResponseEntity<?>  subscribeEmailNotification() {
        return null;
    }


}
