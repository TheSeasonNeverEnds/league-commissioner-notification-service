package com.season.nevends.database.repositories;

import com.season.nevends.database.entities.VenueEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface VenueRepository extends CrudRepository<VenueEntity, Long> {

    @Query(nativeQuery = true, value = "select * from Bars where id = :venueId")
    VenueEntity findByVenueId(Long venueId);

}
