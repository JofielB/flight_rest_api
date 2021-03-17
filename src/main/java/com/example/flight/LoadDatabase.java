package com.example.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AirportRepository repository) {

        return args -> {
            log.info("Preloading... " + repository.save(new Airport("111A", "burglar")));
            log.info("Preloading... " + repository.save(new Airport("222B", "thief")));
        };
    }
}
