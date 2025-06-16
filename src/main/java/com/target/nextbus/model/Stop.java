package com.target.nextbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stop {
    @JsonProperty("place_code")
    private String placeCode;

    private String description;

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}