package com.season.nevends.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ServiceDiscoveryController {

    private final RestTemplate restTemplate = new RestTemplate();

    String url = "http://league-user-profile-service.dev.us-east-2.local:8080/actuator/health";

    @GetMapping(path = "/user-profile-svc")
    ResponseEntity<?> testServiceDiscovery() {
        log.info("Received request to test service discovery");

        try {
            ResponseEntity<?> response = restTemplate.getForEntity(url, Object.class);
            log.info("Received response from test service discovery: {}", response);

            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
