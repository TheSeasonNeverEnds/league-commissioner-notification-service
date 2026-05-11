/*
package com.season.nevends.service;

import com.season.nevends.database.entities.LeagueEventEntity;
import com.season.nevends.database.entities.VenueEntity;
import com.season.nevends.database.repositories.LeagueEventRepository;
import com.season.nevends.model.LeagueEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalendarService {

    @Autowired
    private final LeagueEventRepository leagueEventRepository;

    public void createLeagueCalendarEvent(LeagueEvent event){
        // logic to determine which league based on the user
        // repository.save() -> will return newly created object
        // Make SNS/PinPoint/SES call to topic so broadcast msg can be sent
        log.info("Creating event for League ID {}", event.getLeagueId());
        LeagueEventEntity leagueEventEntity = mapLeagueEventEntity(event);
        leagueEventRepository.save(leagueEventEntity);

    }

    public void updateLeagueCalendarEvent(LeagueEvent event){
        // Update entry in database
        log.info("Updating event for League ID {}", event.getLeagueId());
        LeagueEventEntity leagueEventEntity = mapLeagueEventEntity(event);
        leagueEventRepository.save(leagueEventEntity);
        // Send broadcast message (Email or Push)

    }

    public boolean deleteLeagueCalendarEvent(Long eventId){
        log.info("Checking if league calendar event with Id: {} exists", eventId);
        LeagueEventEntity leagueEventEntity = leagueEventRepository.getLeagueEventByEventId(eventId);
        if (leagueEventEntity != null) {
            log.info("Deleting league calendar event with Id: {}", eventId);
            leagueEventRepository.deleteLeagueEventByEventId(eventId);
            return true;
        }
        return false;
    }

    public List<LeagueEventEntity> getAllLeagueEvents(Long leagueId) {
        log.info("Fetching all event for league with id: {}", leagueId);
        return leagueEventRepository.getLeagueEventsByLeagueId(leagueId);
    }

    public LeagueEventEntity getLeagueCalendarEvent(Long eventId){
        log.info("Fetching league calendar event with id: {}", eventId);
        return leagueEventRepository.getLeagueEventByEventId(eventId);
    }

    public List<LeagueEventEntity> getLeagueCalendarEventsByDate(Long leagueId, String startDate, String endDate){
        log.info("Fetching league calendar events for league: {} in between specified dates", leagueId);
        // Database query is expecting date formatted as: 2025-10-21  (yyyy-MM-dd)
        return leagueEventRepository.getLeagueEventsByDate(leagueId, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }



    private LeagueEventEntity mapLeagueEventEntity(LeagueEvent event){
        LeagueEventEntity eventEntity = new LeagueEventEntity();
        eventEntity.setLeagueId(event.getLeagueId());
        eventEntity.setEventType(eventEntity.getEventType());

        VenueEntity venueEntity = new VenueEntity();
        venueEntity.setId(event.getEventId());

        eventEntity.setVenueId(venueEntity);
        eventEntity.setEventTitle(eventEntity.getEventTitle());
        eventEntity.setEventDescription(event.getEventDescription());
        eventEntity.setEventStartDate(event.getEventStartDate());
        eventEntity.setEventEndDate(event.getEventEndDate());

        return eventEntity;
    }
}
*/