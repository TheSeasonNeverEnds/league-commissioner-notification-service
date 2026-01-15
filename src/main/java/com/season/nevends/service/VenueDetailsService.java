package com.season.nevends.service;

import com.season.nevends.database.entities.VenueEntity;
import com.season.nevends.database.repositories.VenueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VenueDetailsService {

    @Autowired
    private final VenueRepository venueRepository;

    public VenueEntity getVenueDetails(Long venueId) {
        log.info("Fetching Venue Details for Venue: {}", venueId);
        // TODO: The other end of the API doesn't need to know all fields. Condense into smaller object with necessary fields
        venueRepository.findByVenueId(venueId);
        return venueRepository.findByVenueId(venueId);
    }
}
