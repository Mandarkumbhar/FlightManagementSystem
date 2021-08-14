package com.training.sprint1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Airport;
@Service
@Transactional
public interface IAirportService {
    public List<Airport> viewAirport();
     public Airport viewAirportById(Long id);
     
}
