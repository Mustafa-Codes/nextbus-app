package com.target.nextbus.controller;


import com.target.nextbus.model.Direction;
import com.target.nextbus.model.NextBusResponse;
import com.target.nextbus.model.Route;
import com.target.nextbus.model.Stop;
import com.target.nextbus.service.DepartureService;
import com.target.nextbus.service.DirectionService;
import com.target.nextbus.service.RouteService;
import com.target.nextbus.service.StopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
    private static final Logger log = LoggerFactory.getLogger(RouteController.class);
    private final RouteService routeService;
    private final DirectionService directionService;
    private final StopService stopService;
    private final DepartureService departureService;

    public RouteController(RouteService routeService,
                           DirectionService directionService,
                           StopService stopService, DepartureService departureService) {
        this.routeService = routeService;
        this.directionService = directionService;
        this.stopService = stopService;
        this.departureService = departureService;
    }

    @GetMapping
    public Route getRoute(@RequestParam String name) {
        return routeService.findRouteByName(name);
    }

    @GetMapping("/stop")
    public String getDirectionAndStop(
            @RequestParam String route,
            @RequestParam String direction,
            @RequestParam String stop
    ) {
        Route routeObject = routeService.findRouteByName(route);
        Direction matchedDirection = directionService.getMatchedDirection(routeObject.getRouteId(), direction);
        Stop stopObject = stopService.findStop(routeObject.getRouteId(), matchedDirection.getDirectionId(), stop);

        return "Stop code: " + stopObject.getPlaceCode();
    }

    @GetMapping("/next")
    public String getNextBusTime(
            @RequestParam String route,
            @RequestParam String direction,
            @RequestParam String stop
    ) {
        Route routeObject = routeService.findRouteByName(route);
        Direction matchedDirection = directionService.getMatchedDirection(routeObject.getRouteId(), direction);
        Stop stopObject = stopService.findStop(routeObject.getRouteId(), matchedDirection.getDirectionId(), stop);
        return departureService.getNextDepartureMessage(routeObject.getRouteId(), matchedDirection.getDirectionId(), stopObject.getPlaceCode());
    }

    @GetMapping("/nextbus")
    public NextBusResponse getNextBusJson(
            @RequestParam String route,
            @RequestParam String direction,
            @RequestParam String stop
    ) {
        log.info("GET /route/nextbus | route='{}', direction='{}', stop='{}'", route, direction, stop);

        Route routeObject = routeService.findRouteByName(route);
        Direction matchedDirection = directionService.getMatchedDirection(routeObject.getRouteId(), direction);
        Stop stopObject = stopService.findStop(routeObject.getRouteId(), matchedDirection.getDirectionId(), stop);
        String message = departureService.getNextDepartureMessage(routeObject.getRouteId(), matchedDirection.getDirectionId(), stopObject.getPlaceCode());

        log.info("Resolved next bus: {} | {} | {} → {}", routeObject.getRouteLabel(), stopObject.getDescription(), direction, message);

        return new NextBusResponse(
                routeObject.getRouteLabel(),
                stopObject.getDescription(),
                matchedDirection.getDirectionName().toLowerCase(),
                message
        );
    }
}
