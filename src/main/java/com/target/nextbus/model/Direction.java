package com.target.nextbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Direction {
    @JsonProperty("direction_id")
    private int directionId;

    @JsonProperty("direction_name")
    private String directionName;

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }
}
