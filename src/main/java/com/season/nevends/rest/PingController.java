package com.season.nevends.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class PingController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/ping")
    ResponseEntity<String> ping() {
        log.info("Health check called. {} is running", appName);
        return new ResponseEntity<>("This service is UP and running", HttpStatus.OK);
    }


}
