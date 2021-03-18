package com.example.flight.controllers;

import java.util.List;

import com.example.flight.entities.Airport;
import com.example.flight.exceptions.AirportNotFoundException;
import com.example.flight.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
class AirportController {

    private final AirportService service;

    @Autowired
    private AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return service.getAllAirports();
    }

    @PostMapping
    public Airport postAirport(@RequestBody Airport airport) {
        return service.createAirport(airport);
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return service.getAirportById(id);
    }

    @PutMapping("/{id}")
    public Airport putAirport(@RequestBody Airport airport, @PathVariable Long id) {
        return service.updateAirport(airport, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        service.deleteAirport(id);
    }
}