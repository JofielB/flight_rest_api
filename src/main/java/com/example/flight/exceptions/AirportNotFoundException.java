package com.example.flight.exceptions;

public class AirportNotFoundException extends RuntimeException {

    public AirportNotFoundException(Long id) {
        super("Could not found airport with ID: " + id);
    }
}
