package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.model.Departure;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

class DepartureServiceTest {

    private MetroTransitClient mockClient;
    private DepartureService departureService;

    @BeforeEach
    void setUp() {
        mockClient = mock(MetroTransitClient.class);
        departureService = new DepartureService(mockClient);
    }

    @Test
    void shouldReturnNextBusMessage() {
        // Departure in 5 minutes
        long futureTime = Instant.now().getEpochSecond() + (5 * 60);

        Departure departure = new Departure();
        departure.setDepartureTime(futureTime);

        when(mockClient.getDepartures("901", 0, "TF1")).thenReturn(List.of(departure));

        String result = departureService.getNextDepartureMessage("901", 0, "TF1");

        assertTrue(result.contains("Next bus in") || result.contains("Bus is arriving"));
    }

    @Test
    void shouldReturnNoBusesMessage() {
        when(mockClient.getDepartures("901", 0, "TF1")).thenReturn(List.of());

        String result = departureService.getNextDepartureMessage("901", 0, "TF1");

        assertEquals("No more buses today for this route, stop, and direction.", result);
    }
}
