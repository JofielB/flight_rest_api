package com.example.flight;

import com.example.flight.entities.Airport;
import com.example.flight.entities.Flight;
import com.example.flight.repositories.AirportRepository;
import com.example.flight.repositories.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AirportRepository airportRepository, FlightRepository flightRepository) {

        return args -> {
            Airport airportA = new Airport("111A", "Hululu");
            Airport airportB = new Airport("222B", "Ulau");
            log.info("Preloading... " + airportRepository.save(airportA));
            log.info("Preloading... " + airportRepository.save(airportB));
            Flight flightA = new Flight(true, airportA);
            Flight flightAA = new Flight(false, airportA);
            Flight flightB = new Flight(true, airportB);
            log.info("Preloading... " + flightRepository.save(flightA));
            log.info("Preloading... " + flightRepository.save(flightAA));
            log.info("Preloading... " + flightRepository.save(flightB));
        };
    }
}
