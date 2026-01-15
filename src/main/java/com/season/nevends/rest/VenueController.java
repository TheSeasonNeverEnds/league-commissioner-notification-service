package com.season.nevends.rest;

import com.season.nevends.database.entities.VenueEntity;
import com.season.nevends.service.VenueDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/venue")
public class VenueController {

    @Autowired
    private VenueDetailsService venueDetailsService;

    @GetMapping(value = "/profile/{venueId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getVenueDetails(@PathVariable Long venueId) { // or an integer
        log.info("Venue Details API called. Fetching info for venue: {}", venueId);
        try {
            VenueEntity entity = venueDetailsService.getVenueDetails(venueId);
            if (entity != null) {
                return new ResponseEntity<>(entity, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/template/{venueId}")
    public ResponseEntity<?> createVenueTemplate(@PathVariable Object venueTemplate) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/template/{venueId}")
    public ResponseEntity<?> getVenueTemplate(@PathVariable String venueId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/template/{venueId}")
    public  ResponseEntity<?> updateVenueTemplate(@PathVariable String venueId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/template/{venueId}")
    public ResponseEntity<?> deleteVenueTemplate(@PathVariable String venueId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
