package com.example.flight.entities;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table
public class Airport {

    private @Id @GeneratedValue Long id;
    private String airportCode;
    private String name;


    public Airport(String airportCode, String name) {
        this.airportCode = airportCode;
        this.name = name;
    }
}