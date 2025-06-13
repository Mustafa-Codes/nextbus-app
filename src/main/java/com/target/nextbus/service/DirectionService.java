package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService {

    private final MetroTransitClient client;

    public DirectionService(MetroTransitClient client) {
        this.client = client;
    }

    public int getDirectionId(String routeId, String inputDirection) {
        List<Direction> directions = client.getDirectionsForRoute(routeId);

        return directions.stream()
                .filter(direction -> direction.getDirection_name().toLowerCase().contains(inputDirection.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Invalid direction for this route: " + inputDirection))
                .getDirection_id();
    }
}
