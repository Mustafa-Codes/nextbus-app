package com.target.nextbus.service;

import com.target.nextbus.client.MetroTransitClient;
import com.target.nextbus.exception.NotFoundException;
import com.target.nextbus.model.Direction;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DirectionServiceTest {

    private MetroTransitClient mockClient;
    private DirectionService directionService;

    @BeforeEach
    void setUp() {
        mockClient = mock(MetroTransitClient.class);
        directionService = new DirectionService(mockClient);
    }

    @Test
    void shouldReturnMatchingDirectionId() {
        Direction north = new Direction();
        north.setDirectionId(0);
        north.setDirectionName("Northbound");

        when(mockClient.getDirectionsForRoute("901")).thenReturn(List.of(north));

        int directionId = directionService.getMatchedDirection("901", "north").getDirectionId();

        assertEquals(0, directionId);
    }

    @Test
    void shouldThrowNotFoundExceptionForInvalidDirection() {
        Direction south = new Direction();
        south.setDirectionId(1);
        south.setDirectionName("Southbound");

        when(mockClient.getDirectionsForRoute("901")).thenReturn(List.of(south));

        assertThrows(NotFoundException.class, () -> {
            directionService.getMatchedDirection("901", "west").getDirectionId();
        });
    }
}
