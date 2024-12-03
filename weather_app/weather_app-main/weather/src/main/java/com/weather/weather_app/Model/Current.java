package com.weather.weather_app.Model;

import lombok.Getter;

@Getter
public class Current {
    private double temp_c;
    private double temp_f;
    private double humidity;
    private double wind_mph;
    private Condition condition;

    // Setters
    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setWind_mph(double wind_mph) {
        this.wind_mph = wind_mph;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
