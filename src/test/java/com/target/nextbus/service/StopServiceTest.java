package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.MultipleMatchesException;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Stop;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class StopServiceTest {

    private MetroTransitClient mockClient;
    private StopService stopService;

    @BeforeEach
    void setUp() {
        mockClient = mock(MetroTransitClient.class);
        stopService = new StopService(mockClient);
    }

    @Test
    void shouldReturnMatchingStop() {
        Stop stop = new Stop();
        stop.setPlaceCode("TF1");
        stop.setDescription("Target Field Station Platform 1");

        when(mockClient.getStopsForRouteAndDirection("901", 0)).thenReturn(List.of(stop));

        Stop result = stopService.findStop("901", 0, "Target");

        assertEquals("TF1", result.getPlaceCode());
        assertEquals("Target Field Station Platform 1", result.getDescription());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenNoStopMatches() {
        when(mockClient.getStopsForRouteAndDirection("901", 0)).thenReturn(List.of());

        assertThrows(NotFoundException.class, () -> {
            stopService.findStop("901", 0, "Nowhere");
        });
    }

    @Test
    void shouldThrowMultipleMatchesExceptionWhenTooManyStopsMatch() {
        Stop stop1 = new Stop();
        stop1.setDescription("Target Field Station Platform 1");

        Stop stop2 = new Stop();
        stop2.setDescription("Target Field Station Platform 2");

        when(mockClient.getStopsForRouteAndDirection("901", 0)).thenReturn(List.of(stop1, stop2));

        assertThrows(MultipleMatchesException.class, () -> {
            stopService.findStop("901", 0, "Target");
        });
    }
}
