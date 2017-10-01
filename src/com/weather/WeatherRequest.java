package com.weather;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class WeatherRequest {
    protected String city;
    protected String code;
    protected String units = "metric";

    public WeatherRequest(String city, String code) {
        this.city = city;
        this.code = code;
    }

    public WeatherRequest(String city, String code, String units) {
        this.city = city;
        this.code = code;
        this.units = units;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
