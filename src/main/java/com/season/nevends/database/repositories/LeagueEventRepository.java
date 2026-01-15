package com.season.nevends.database.repositories;

import com.season.nevends.database.entities.LeagueEventEntity;
import com.season.nevends.model.LeagueEvent;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Hidden
@Repository
public interface LeagueEventRepository extends CrudRepository<LeagueEventEntity, Long> {

    @Query(nativeQuery = true, value = "select * from LEAGUE_EVENTS where LEAGUE_ID = :leagueId")
    List<LeagueEventEntity> getLeagueEventsByLeagueId(@Param("leagueId") Long leagueId);

    @Query(nativeQuery = true, value = "select * from LEAGUE_EVENTS where event_id = :eventId")
    LeagueEventEntity getLeagueEventByEventId(@Param("eventId") Long eventId);

    @Query(nativeQuery = true, value = "delete * from LEAGUE_EVENTS where event_id = :eventId")
    void deleteLeagueEventByEventId(@Param("eventId") Long eventId);

    @Query(nativeQuery = true, value = "select * from LEAGUE_EVENTS where LEAGUE_ID = :leagueId and event_start >= :startDate and event_end <= endDate")
    List<LeagueEventEntity> getLeagueEventsByDate(@Param("leagueId") Long leagueId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
