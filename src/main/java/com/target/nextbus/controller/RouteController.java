package com.target.nextbus.controller;


import com.target.nextbus.model.Route;
import com.target.nextbus.model.Stop;
import com.target.nextbus.service.DepartureService;
import com.target.nextbus.service.DirectionService;
import com.target.nextbus.service.RouteService;
import com.target.nextbus.service.StopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

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
        int directionId = directionService.getDirectionId(routeObject.getRoute_id(), direction);
        Stop stopObject = stopService.findStop(routeObject.getRoute_id(), directionId, stop);

        return "Stop code: " + stopObject.getPlace_code();
    }

    @GetMapping("/next")
    public String getNextBusTime(
            @RequestParam String route,
            @RequestParam String direction,
            @RequestParam String stop
    ) {
        Route routeObject = routeService.findRouteByName(route);
        int directionId = directionService.getDirectionId(routeObject.getRoute_id(), direction);
        Stop stopObject = stopService.findStop(routeObject.getRoute_id(), directionId, stop);
        return departureService.getNextDepartureMessage(routeObject.getRoute_id(), directionId, stopObject.getPlace_code());
    }
}
