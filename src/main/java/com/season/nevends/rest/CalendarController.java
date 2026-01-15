package com.season.nevends.rest;

import com.season.nevends.database.entities.LeagueEventEntity;
import com.season.nevends.model.LeagueEvent;
import com.season.nevends.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;


    @PostMapping(value = "/event", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEvent(@RequestBody LeagueEvent leagueEvent) {
        // TODO: Need to determine if a new broadcast message should be sent out
        log.info("Received request to create new league event for League: {}", leagueEvent.getLeagueId());
        try {
            calendarService.createLeagueCalendarEvent(leagueEvent);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(value = "/event", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEvent(@RequestBody LeagueEvent leagueEvent) {
        // TODO: Need to determine if a new broadcast message should be sent out
        log.info("Received request to  update league event for League: {}", leagueEvent.getLeagueId());
        try {
            calendarService.updateLeagueCalendarEvent(leagueEvent);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("");
        }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "/event/{eventId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEvent(Long eventId) {
        // Logic to take in a single event and delete the event from  the calendar
        // May need to enhance this logic if user decides to delete multiple events at a time
        log.info("Received request to delete league event with Id: {}", eventId);
        boolean eventDeleted = calendarService.deleteLeagueCalendarEvent(eventId);
        if (eventDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/events/{leagueId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllLeagueEvents(@PathVariable Long leagueId) {
        // return a list of all the league events based on user and by date
        log.info("Received request to get league events for League: {}", leagueId);
        try {
            List<LeagueEventEntity> leagueEvents = calendarService.getAllLeagueEvents(leagueId);
            if  (!leagueEvents.isEmpty()) {
                return new ResponseEntity<>(leagueEvents, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("No league events found for league id:  {}", leagueId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/event/{leagueId}/{eventId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLeagueEvent(@PathVariable Long leagueId, @PathVariable Long eventId) {
        log.info("Received request to get league event with Id: {}", eventId);
        LeagueEventEntity event = calendarService.getLeagueCalendarEvent(eventId);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping(value = "/events", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLeagueEventsByDate(@RequestParam Long leagueId, @RequestParam String startDate, @RequestParam String endDate) {
        List<LeagueEventEntity> event = calendarService.getLeagueCalendarEventsByDate(leagueId, startDate, endDate);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }


}
