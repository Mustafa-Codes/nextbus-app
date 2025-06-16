package com.target.nextbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Departure {
    private String departureText;

    @JsonProperty("departure_time")
    private Long departureTime;

    public String getDepartureText() {
        return departureText;
    }

    public void setDepartureText(String departureText) {
        this.departureText = departureText;
    }

    public Long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }
}
