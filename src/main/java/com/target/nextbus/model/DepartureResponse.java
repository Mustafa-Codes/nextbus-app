package com.target.nextbus.model;

import lombok.Data;

import java.util.List;

@Data
public class DepartureResponse {
    private List<Departure> departures;
}
