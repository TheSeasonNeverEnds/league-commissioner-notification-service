//package com.season.nevends.rest;
//
//import com.season.nevends.database.entities.ActivityEntity;
//import com.season.nevends.database.entities.LeagueEventEntity;
//import com.season.nevends.database.entities.TestUserEntity;
//import com.season.nevends.database.entities.VenueEntity;
//import com.season.nevends.database.repositories.ActivityRepository;
//import com.season.nevends.database.repositories.LeagueEventRepository;
//import com.season.nevends.database.repositories.TestUserRepository;
//import com.season.nevends.database.repositories.VenueRepository;
//import com.season.nevends.model.TestUser;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@Slf4j
//@CrossOrigin("*")
//@RequestMapping("api/v1")
//@RequiredArgsConstructor
//public class TestController {
//
//    @Autowired
//    private final TestUserRepository userRepository;
//
//    @Autowired
//    private final ActivityRepository activityRepository;
//
//    @Autowired
//    private final VenueRepository venueRepository;
//
//    @Autowired
//    private final LeagueEventRepository leagueEventRepository;
//
//    @GetMapping("/activites")
//    public ResponseEntity<?> activites() {
//        log.info("Returning all activities");
//        Optional<ActivityEntity> activities = activityRepository.findById(1L);
//        return new ResponseEntity<>(activities, HttpStatus.OK);
//    }
//
//    @GetMapping("/user")
//    public ResponseEntity<?> getColumns() {
//        log.info("Returning all columns");
//        List<TestUserEntity> users = (List<TestUserEntity>) userRepository.findAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> addTestUser(@RequestBody TestUser testUser) {
//        log.info("Adding test user {}", testUser);
//        TestUserEntity testUserEntity = new TestUserEntity();
//        testUserEntity.setFirstName(testUser.getFirstName());
//        testUserEntity.setLastName(testUser.getLastName());
//        testUserEntity.setEmailAddr(testUser.getEmail());
//
//        TestUserEntity result = userRepository.save(testUserEntity);
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/venue", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getVenue() {
//        log.info("Returning all venues");
//        List<VenueEntity> venueEntities = (List<VenueEntity>) venueRepository.findAll();
//        return new ResponseEntity<>(venueEntities, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getEvents() {
//        log.info("Returning all events");
//        List<LeagueEventEntity> events = (List<LeagueEventEntity>) leagueEventRepository.findAll();
//        return new ResponseEntity<>(events, HttpStatus.OK);
//    }
//}
