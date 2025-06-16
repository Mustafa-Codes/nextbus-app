package com.target.nextbus.model;

import java.util.List;

public class DepartureResponse {
    private List<Departure> departures;

    public List<Departure> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }
}
