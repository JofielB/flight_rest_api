package com.example.flight.exceptions;

public class AirportCodeAlreadyExistException extends RuntimeException{
    public AirportCodeAlreadyExistException(String airportCode) {
        super("An airport with the code " + airportCode + " already exist");
    }
}
