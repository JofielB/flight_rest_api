package com.example.flight.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@ApiModel(description = "Domain to model the airports that are received form the FlightAPI")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {
    @ApiModelProperty(notes = "The code of the airport")
    private String iata;
    @ApiModelProperty(notes = "Code related to the airport")
    private String fs;
    @ApiModelProperty(notes = "The name of the airport")
    private String name;
}