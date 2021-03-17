package com.example.flight;

public class AirportNotFoundException extends RuntimeException {

    AirportNotFoundException(Long id) {
        super("Could not found " + id);
    }
}
