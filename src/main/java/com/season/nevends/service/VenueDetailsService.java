package com.season.nevends.service;

import com.season.nevends.database.entities.VenueEntity;
import com.season.nevends.database.repositories.VenueRepository;
import com.season.nevends.model.Address;
import com.season.nevends.model.VenueDetails;
import com.season.nevends.util.UtilMethods;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.season.nevends.util.UtilMethods.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class VenueDetailsService {

    @Autowired
    private final VenueRepository venueRepository;

    public VenueDetails getVenueDetails(Long venueId) {
        log.info("Fetching Venue Details for Venue: {}", venueId);
        VenueEntity entity = venueRepository.findByVenueId(venueId);
        if (entity == null) return null;
        return mapVenueDetails(venueRepository.findByVenueId(venueId));
    }

    private VenueDetails mapVenueDetails(VenueEntity venueEntity) {
        VenueDetails details = new VenueDetails();
        details.setVenueId(String.valueOf(venueEntity.getId()));
        details.setVenueName(venueEntity.getBarName());

        Address address = new Address();
        address.setAddressLine1(venueEntity.getAddress1());
        address.setAddressLine2(venueEntity.getAddress2());
        address.setCity(venueEntity.getCity());
        address.setState(venueEntity.getState());
        address.setZipCode(UtilMethods.formatZipCode(venueEntity.getZip()));

        details.setVenueAddress(address);
        details.setVenuePhone(venueEntity.getPhone());
        details.setVenueEmail(venueEntity.getEmail());
        details.setWebsite(venueEntity.getWebsiteURL());

        return details;
    }

    // TODO: add additional methods for venue templates when venues create postings messages
}
