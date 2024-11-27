package com.weather.weather_app.Model;

import lombok.Data;

@Data
public class Clima {
    private String cidade;
    private String condicao;
    private double temperatura;
}
