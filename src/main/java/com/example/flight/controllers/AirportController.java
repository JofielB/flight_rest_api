package com.example.flight.controllers;

import java.util.List;

import com.example.flight.domains.Data;
import com.example.flight.entities.Airport;
import com.example.flight.entities.Flight;
import com.example.flight.services.AirportService;
import com.example.flight.services.FlightService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
class AirportController {

    private final AirportService airportService;
    private final FlightService flightService;

    @Autowired
    private AirportController(AirportService airportService, FlightService flightService) {
        this.airportService = airportService;
        this.flightService = flightService;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    //Todo add authentication to this route
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@RequestBody Airport airport, @PathVariable Long id) {
        return airportService.updateAirport(airport, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }

    @GetMapping("/flights/{id}/{available}")
    public List<Flight> getAirportAvailableFlights(@PathVariable Long id, @PathVariable Boolean available) {
        return flightService.getAirportFlightsById(id, available);
    }

    //Todo Think: should the endpoints bellow have authentication?
    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@RequestBody Flight flight, @PathVariable Long id) {
        return flightService.updateFlight(flight, id);
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/flightAPI/{searchParam}")
    @ApiOperation(
            value = "Find airport by a search parameter",
            notes = "You can search by city, airport code or even incomplete words",
            response = Data.class)
    public Data getAirportsByNameTest(@ApiParam(value = "Text that is going to be use to search for an airport")
                                          @PathVariable String searchParam) {
        return airportService.getAirportsByParam(searchParam);
    }
}