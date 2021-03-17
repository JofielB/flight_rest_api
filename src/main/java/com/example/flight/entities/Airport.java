package com.example.flight.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Airport {

    private @Id @GeneratedValue Long id;
    private String _airportCode;
    private String _name;


    public Airport(String airportCode, String name) {
        _airportCode = airportCode;
        _name = name;
    }
}