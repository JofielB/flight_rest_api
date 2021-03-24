package com.example.flight.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

    public Airport(String airportCode, String name) {
        this.airportCode = airportCode;
        this.name = name;
    }
}