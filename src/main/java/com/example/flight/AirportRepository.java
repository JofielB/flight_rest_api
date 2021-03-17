package com.example.flight;

import org.springframework.data.jpa.repository.JpaRepository;

interface AirportRepository extends JpaRepository<Airport, Long> {
}
