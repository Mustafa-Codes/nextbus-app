package com.target.nextbus.model;

import lombok.Data;

@Data
public class Departure {
    private boolean actual;
    private String departure_text;
    private Long departure_time;

}
