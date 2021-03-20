package com.example.flight.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Flight {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "available")
    private boolean isAvailable;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    public Flight(boolean isAvailable, Airport airport) {
        this.isAvailable = isAvailable;
        this.airport = airport;
    }
}
