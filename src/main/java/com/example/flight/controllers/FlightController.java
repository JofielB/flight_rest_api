package com.example.flight.controllers;

import com.example.flight.entities.Flight;
import com.example.flight.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightService service;

    @Autowired
    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return service.createFlight(flight);
    }

    @GetMapping("{id}")
    public Flight getFlight(@PathVariable Long id) {
        return service.getFlightById(id);
    }

    @PutMapping("{id}")
    public Flight updateFlight(@RequestBody Flight flight, @PathVariable Long id) {
        return service.updateFlight(flight, id);
    }

    @DeleteMapping("{id}")
    public void deleteFlight(@PathVariable Long id) {
        service.deleteFlight(id);
    }
}
