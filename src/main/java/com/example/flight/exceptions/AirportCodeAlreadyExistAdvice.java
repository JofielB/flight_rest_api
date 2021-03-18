package com.example.flight.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AirportCodeAlreadyExistAdvice {

    @ResponseBody
    @ExceptionHandler(AirportCodeAlreadyExistException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    String airportNotFoundHandler(AirportCodeAlreadyExistException ex) {
        return ex.getMessage();
    }
}
