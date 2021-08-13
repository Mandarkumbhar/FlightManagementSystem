package com.training.sprint1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sprint1.entities.ScheduledFlight;

@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long>{
	List<ScheduledFlight> findByScheduleDate(LocalDate date);

}
