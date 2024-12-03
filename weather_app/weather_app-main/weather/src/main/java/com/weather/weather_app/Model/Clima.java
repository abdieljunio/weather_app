package com.weather.weather_app.Model;

import lombok.Data;

@Data
public class Clima {
    private Location location;
    private Current current;
}
