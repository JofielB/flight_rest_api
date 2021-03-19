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
    private String airportCode;
    private String name;


    public Airport(String airportCode, String name) {
        this.airportCode = airportCode;
        this.name = name;
    }
}