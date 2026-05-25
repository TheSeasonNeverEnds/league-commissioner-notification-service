package com.season.nevends.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Data
@Builder
public class LeagueEvent {

    private Long eventId;
    private Long leagueId;
    private String leagueName;
    private NotificationType eventType;
    private int venueId;
    private String eventTitle;
    private String eventDescription;
    private OffsetDateTime eventStartDate;
    private OffsetDateTime eventEndDate;
    private LocalDateTime created_on;
    private LocalDateTime updated_on;


}
