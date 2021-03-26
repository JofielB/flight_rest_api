package com.example.flight.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@ApiModel(description = "Domains to model the data that is received form the FlightAPI")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @ApiModelProperty(notes = "Array of airports")
    private Airport[] data;
}