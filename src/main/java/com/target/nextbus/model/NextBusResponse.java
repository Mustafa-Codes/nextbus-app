package com.target.nextbus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextBusResponse {
    private String route;
    private String stop;
    private String direction;
    private String message;
}
