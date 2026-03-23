package com.season.nevends.model;

import lombok.Builder;
import lombok.Data;

@Data
public class VenueDetails {

    public String venueId;
    private String venueName;
    private Address venueAddress;
    private String venuePhone;
    private String venueEmail;
    private String website;


}
