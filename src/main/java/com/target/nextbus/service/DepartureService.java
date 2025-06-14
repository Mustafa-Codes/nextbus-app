package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.model.Departure;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class DepartureService {

    private final MetroTransitClient client;

    public DepartureService(MetroTransitClient client) {
        this.client = client;
    }

    public String getNextDepartureMessage(String routeId, int directionId, String placeCode) {
        List<Departure> departures = client.getDepartures(routeId, directionId, placeCode);

        if (departures.isEmpty()) {
            return "No more buses today for this route, stop, and direction";
        }

        Departure next = departures.get(0);

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime departureTime = Instant.ofEpochSecond(next.getDeparture_time()).atZone(ZoneId.systemDefault());

        long minutes = Duration.between(now, departureTime).toMinutes();

        if (minutes <= 0) {
            return "Bus is arriving now or has just departed.";
        }

        return "Next bus in " + minutes + " minute" + (minutes > 1 ? "s." : ".");
    }
}
