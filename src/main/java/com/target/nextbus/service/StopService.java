package com.target.nextbus.service;


import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.MultipleMatchesException;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Stop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopService {

    private final MetroTransitClient client;

    public StopService(MetroTransitClient client) {
        this.client = client;
    }

    public Stop findStop(String routeId, int directionId, String partialStopName) {
        List<Stop> stops = client.getStopsForRouteAndDirection(routeId, directionId);

        List<Stop> matched = stops.stream()
                .filter(stop -> stop.getDescription().toLowerCase().contains(partialStopName.toLowerCase()))
                .collect(Collectors.toList());

        if (matched.isEmpty()) {
            throw new NotFoundException("No stop found matching: " + partialStopName);
        } else if (matched.size() > 1) {
            String matches = matched.stream()
                    .map(Stop::getDescription)
                    .collect(Collectors.joining(", "));
            throw new MultipleMatchesException("Multiple stops matched: " + matches);
        }
        return matched.get(0);
    }
}
