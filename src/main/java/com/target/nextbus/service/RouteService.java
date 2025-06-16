package com.target.nextbus.service;


import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.MultipleMatchesException;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final MetroTransitClient metroTransitClient;

    public RouteService(MetroTransitClient metroTransitClient) {
        this.metroTransitClient = metroTransitClient;
    }

    public Route findRouteByName(String partialName) {
        List<Route> allRoutes = metroTransitClient.fetchAllRoutes();

        List<Route> matchedRoutes = allRoutes.stream()
                .filter(route -> route.getRouteLabel().toLowerCase().contains(partialName.toLowerCase()))
                .collect(Collectors.toList());

        if (matchedRoutes.isEmpty()) {
            throw new NotFoundException("No route found for: " + partialName);
        } else if(matchedRoutes.size() > 1) {
            throw new MultipleMatchesException("Multiple routes matched. Please be more specific.");
        }
        return matchedRoutes.get(0);
    }
}
