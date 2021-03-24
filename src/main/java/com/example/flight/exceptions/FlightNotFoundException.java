package com.example.flight.exceptions;

public class FlightNotFoundException extends RuntimeException{

    public FlightNotFoundException(Long id) {
        super("Could not found flight with ID: " + id);
    }
}
