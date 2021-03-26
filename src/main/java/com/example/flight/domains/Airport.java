package com.example.flight.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@ApiModel(description = "Domains to model the airports that are received form the FlightAPI")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {
    @ApiModelProperty(notes = "The code of the airport")
    private String iata;
    private String fs;
    @ApiModelProperty(notes = "The name of the airport")
    private String name;
}