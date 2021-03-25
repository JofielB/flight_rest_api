package com.example.flight.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private Airport[] data;
}