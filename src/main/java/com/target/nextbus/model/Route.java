package com.target.nextbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
    @JsonProperty("route_id")
    private String routeId;

    @JsonProperty("route_label")
    private String routeLabel;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteLabel() {
        return routeLabel;
    }

    public void setRouteLabel(String routeLabel) {
        this.routeLabel = routeLabel;
    }
}