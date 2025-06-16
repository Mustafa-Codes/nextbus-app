package com.target.nextbus.model;

public class NextBusResponse {
    private String route;
    private String stop;
    private String direction;
    private String message;

    public NextBusResponse(String route, String stop, String direction, String message) {
        this.route = route;
        this.stop = stop;
        this.direction = direction;
        this.message = message;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
