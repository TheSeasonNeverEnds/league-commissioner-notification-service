package com.season.nevends.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "LEAGUE_EVENTS")
public class LeagueEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Long eventId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "LEAGUE_ID") // Create Foreign Key for this column as well
    private Long leagueId; // Will need to do entity mapping for this coulm as well

    @Column(name = "EVENT_TYPE")
    private String eventType;

    @OneToOne(targetEntity = VenueEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VENUE_ID") // Foreign key was created in database
    private VenueEntity venueId;

    @Column(name = "EVENT_TITLE")
    private String eventTitle;

    @Column(name = "EVENT_DESC")
    private String eventDescription;

    @Column(name = "EVENT_START")
    private OffsetDateTime eventStartDate;

    @Column(name = "EVENT_END")
    private OffsetDateTime eventEndDate;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

}
