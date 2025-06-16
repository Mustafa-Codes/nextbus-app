package com.target.nextbus.client;

import com.target.nextbus.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

// This is how we make API requests
@Component
public class MetroTransitClient {
    private final WebClient webClient;

    public MetroTransitClient() {
        this.webClient = WebClient.builder().
                baseUrl("https://svc.metrotransit.org").
                build();
    }

    public List<Route> fetchAllRoutes() {
        return Arrays.asList(
            webClient.get()
                    .uri("/nextripv2/routes")
                    .retrieve().bodyToMono(Route[].class).block()
        );
    }

    public List<Direction> getDirectionsForRoute(String routeId) {
        return Arrays.asList(
                webClient.get()
                        .uri("/nextripv2/directions/{routeId}", routeId)
                        .retrieve()
                        .bodyToMono(Direction[].class)
                        .block()
        );
    }

    public List<Stop> getStopsForRouteAndDirection(String routeId, int directionId) {
        return Arrays.asList(
                webClient.get()
                        .uri("/nextripv2/stops/{routeId}/{directionId}", routeId, directionId)
                        .retrieve()
                        .bodyToMono(Stop[].class)
                        .block()
        );
    }

    public List<Departure> getDepartures(String routeId, int directionId, String placeCode) {
        DepartureResponse response = webClient.get()
            .uri("/nextripv2/{routeId}/{directionId}/{placeCode}", routeId, directionId, placeCode)
            .retrieve()
            .bodyToMono(DepartureResponse.class)
            .block();

        return response.getDepartures();
    }
}
