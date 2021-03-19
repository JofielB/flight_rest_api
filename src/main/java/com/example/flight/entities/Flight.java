package com.example.flight.entities;

import lombok.Data;

import javax.persistence.*;

//Todo fix this entity, the relation with the airportCode is not working
@Data
@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "available")
    private boolean isAvailable;

}
