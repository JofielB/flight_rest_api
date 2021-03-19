package com.example.flight.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table
public class Airport {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "airport_code")
    private String airportCode;

    @Column(name = "name")
    private String name;

    public Airport(String airportCode, String name) {
        this.airportCode = airportCode;
        this.name = name;
    }
}