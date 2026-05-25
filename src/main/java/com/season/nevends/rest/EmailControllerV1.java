package com.season.nevends.rest;

import com.season.nevends.model.NotificationRequest;
import com.season.nevends.service.EmailServiceV1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
@Slf4j
public class EmailControllerV1 {


    private final EmailServiceV1 emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmailNotificationV1(@Valid @RequestBody NotificationRequest request) {
        log.info("Received request to send email notification - V1");
        boolean validRequest = emailService.validateEmailNotificationRequest(request);
        if  (!validRequest) { return ResponseEntity.badRequest().build(); }

        try {
            emailService.sendEmail(request);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
