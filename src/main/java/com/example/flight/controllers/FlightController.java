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

    @GetMapping("{id}")
    public Flight getFlightDetails(@PathVariable Long id) {
        return service.getFlightById(id);
    }
}
