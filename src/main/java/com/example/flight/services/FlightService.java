package com.example.flight.services;

import com.example.flight.entities.Flight;
import com.example.flight.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Todo fix and create the correct exceptions for getFlightById and UpdateFlight
@Service
public class FlightService {

    private FlightRepository repository;

    @Autowired
    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight createFlight(Flight flight) {
        return repository.save(flight);
    }

    public Flight getFlightById(Long id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

//    public Flight updateFlight(Flight flight, Long id) {
//        return repository.findById(id)
//                .map(flightFound -> {
//                    flightFound.setAirport(flight.getAirport());
//                    flightFound.setAvailable(flight.isAvailable());
//                    return repository.save(flightFound);
//                })
//                .orElseThrow(RuntimeException::new);
//    }

    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }
}
