package com.example.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private AirportTest[] data;
}