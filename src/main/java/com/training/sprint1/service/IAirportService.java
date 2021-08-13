package com.training.sprint1.service;

import java.util.List;

import com.training.sprint1.entities.Airport;

public interface IAirportService {
    public List<Airport> viewAirport();
     public Airport viewAirportById(Long id);
     
}
