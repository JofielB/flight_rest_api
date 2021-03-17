package com.example.flight.controllers;

import java.util.List;

import com.example.flight.entities.Airport;
import com.example.flight.exceptions.AirportNotFoundException;
import com.example.flight.repositories.AirportRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AirportController {

    private final AirportRepository repository;

    private AirportController(AirportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    @PostMapping("/airports")
    public Airport postAirport(@RequestBody Airport newAirport) {
        return repository.save(newAirport);
    }

    @GetMapping("/airports/{id}")
    public Airport getAirportById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    @PutMapping("/airports/{id}")
    public Airport putAirport(@RequestBody Airport newAirport, @PathVariable Long id) {

        return repository.findById(id)
                .map(airports -> {
                    airports.setName(newAirport.getName());
                    airports.setAirportCode(newAirport.getAirportCode());
                    return repository.save(airports);
                })
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    @DeleteMapping("/airports/{id}")
    public void deleteAirport(@PathVariable Long id) {
        repository.deleteById(id);
    }
}