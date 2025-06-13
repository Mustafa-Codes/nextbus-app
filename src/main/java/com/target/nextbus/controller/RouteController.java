package com.target.nextbus.controller;


import com.target.nextbus.model.Route;
import com.target.nextbus.service.RouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public Route getRoute(@RequestParam String name) {
        return routeService.findRouteByName(name);
    }

}
