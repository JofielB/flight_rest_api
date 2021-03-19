package com.example.flight.services;

import com.example.flight.entities.Flight;
import com.example.flight.exceptions.FlightNotFoundException;
import com.example.flight.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new FlightNotFoundException(id));
    }

    public Flight updateFlight(Flight flight, Long id) {
        return repository.findById(id)
                .map(flightFound -> {
                    flightFound.setAvailable(flight.isAvailable());
                    return repository.save(flightFound);
                })
                .orElseThrow(() -> new FlightNotFoundException(id));
    }

    public void deleteFlight(Long id) {
        if (getFlightById(id) != null) {
            repository.deleteById(id);
        }
    }
}
