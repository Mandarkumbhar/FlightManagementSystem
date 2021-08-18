package com.training.sprint1.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.training.sprint1.entities.ScheduledFlight;

@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long>{
	List<ScheduledFlight> findByScheduleScheduleDate(LocalDate date);
	@Query("SELECT sf FROM ScheduledFlight sf  WHERE sf.schedule.sourceAirport.id=:sa and sf.schedule.destinationAirport.id=:da and sf.schedule.scheduleDate=:sd")
	List<ScheduledFlight> findByScheduleSourceAirportIdAndDestinationAirportIdAndScheduleDate(@Param("sa") Long scourceId,@Param("da") Long destinationId,@Param("sd") LocalDate date);
	@Query("SELECT sf FROM ScheduledFlight sf  WHERE sf.flight.flightId=:fd")
	List<ScheduledFlight> findByFlightFlightId(@Param("fd") Long flightId);
}
