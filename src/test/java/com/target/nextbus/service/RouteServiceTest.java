package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.MultipleMatchesException;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Route;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RouteServiceTest {

    private MetroTransitClient mockClient;
    private RouteService routeService;

    @BeforeEach
    void setUp() {
        mockClient = mock(MetroTransitClient.class);
        routeService = new RouteService(mockClient);
    }

    @Test
    void shouldReturnMatchingRoute() {
        Route route = new Route();
        route.setRouteId("901");
        route.setRouteLabel("METRO Blue Line");

        when(mockClient.fetchAllRoutes()).thenReturn(List.of(route));

        Route result = routeService.findRouteByName("blue");

        assertEquals("901", result.getRouteId());
        assertEquals("METRO Blue Line", result.getRouteLabel());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenNoMatch() {
        when(mockClient.fetchAllRoutes()).thenReturn(List.of());

        assertThrows(NotFoundException.class, () -> {
            routeService.findRouteByName("nonexistent");
        });
    }

    @Test
    void shouldThrowMultipleMatchesException() {
        Route route1 = new Route();
        route1.setRouteLabel("10 - Central");
        Route route2 = new Route();
        route2.setRouteLabel("110 - Express Central");

        when(mockClient.fetchAllRoutes()).thenReturn(List.of(route1, route2));

        assertThrows(MultipleMatchesException.class, () -> {
            routeService.findRouteByName("Central");
        });
    }
}
