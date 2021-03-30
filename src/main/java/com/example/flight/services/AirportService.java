package com.example.flight.services;

import com.example.flight.domains.Data;
import com.example.flight.entities.Airport;
import com.example.flight.exceptions.AirportCodeAlreadyExistException;
import com.example.flight.exceptions.AirportNotFoundException;
import com.example.flight.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    public Airport createAirport(Airport airport) {
        Airport airportByCode = repository.findAirportByCode(airport.getAirportCode());
        if (airportByCode != null) {
            throw new AirportCodeAlreadyExistException(airport.getAirportCode());
        }
        return repository.save(airport);
    }

    public Airport getAirportById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    public Airport updateAirport(Airport airport, Long id) {
        return repository.findById(id)
                .map(airports -> {
                    airports.setName(airport.getName());
                    airports.setAirportCode(airport.getAirportCode());
                    return repository.save(airports);
                })
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    public void deleteAirport(Long id) {
        if (getAirportById(id) != null) {
            repository.deleteById(id);
        }
    }

    public Data getAirportsByParam(String searchParam) {
        String url = "https://api.flightapi.io/iata/605a775c5ebe270566374988/" + searchParam + "/airport";
        return restTemplate.getForObject(url, Data.class);
    }

}