package com.example.flight.repositories;

import com.example.flight.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.airport.id = ?1")
    List<Flight> findFlightsByAirportId(Long airportId);
}
