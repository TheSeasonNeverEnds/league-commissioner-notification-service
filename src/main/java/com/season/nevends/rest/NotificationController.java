package com.season.nevends.rest;


import com.season.nevends.handler.EmailPublishHandler;
import com.season.nevends.model.NotificationRequest;
import com.season.nevends.service.EmailNotificationService;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/notification")
public class NotificationController {

    private final EmailNotificationService emailNotificationService;

    @PostMapping(path = "/email",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmailNotification(@Valid @RequestBody NotificationRequest request) {
        log.info("Received email notification request for League - {}", request.getLeagueId());

        try {
            emailNotificationService.sendEmailNotification(request);
            log.info("Email notification sent successfully");
        } catch (Exception e) {
            log.info("Exception occurred while sending email notification", e);
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/email/recovery")
    public ResponseEntity<?> sendEmailForAcctRecovery() {
        Twilio.init("98007488", "uRPSCHARQk60l9NrdhD7ug");

        // TODO:  Need to create Verify Service

//        Verification verification = Verification.creator(
//                "98007488", // Your Service SID
//                "+marcus97cobra@yahoo.com", // Recipient's phone number
//                "email" // Delivery channel: 'sms', 'whatsapp', 'call', or 'email'
//        ).create();

//        return new ResponseEntity<>(verification.getSid(),  HttpStatus.OK);
        return new ResponseEntity<>(  HttpStatus.OK);
    }

//    @PostMapping("/sms")
//    public ResponseEntity<?>  sendSmsNotification() {
//        return null;
//
//    }

//    @PostMapping("/push")
//    public ResponseEntity<?>  sendPushNotification() {
//        return null;
//
//    }


}
