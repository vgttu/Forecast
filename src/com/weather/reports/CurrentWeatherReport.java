package com.weather.reports;

import org.json.*;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class CurrentWeatherReport {
    protected String city;
    protected String code;

    protected Double currentTemperature;
    protected Double minimalTemperature;
    protected Double maximumTemperature;

    public CurrentWeatherReport(JSONObject json) {
        JSONArray list = json.getJSONArray("list");
        JSONObject data = list.getJSONObject(0);

        this.city = data.getString("name");
        this.code = data.getJSONObject("sys").getString("country");

        this.currentTemperature = data.getJSONObject("main").getDouble("temp");
        this.minimalTemperature = data.getJSONObject("main").getDouble("temp_min");
        this.maximumTemperature = data.getJSONObject("main").getDouble("temp_max");
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getMinimalTemperature() {
        return minimalTemperature;
    }

    public Double getMaximumTemperature() {
        return maximumTemperature;
    }

    @Override
    public String toString() {
        return "CurrentWeatherReport{" +
                "city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", currentTemperature=" + currentTemperature +
                ", minimalTemperature=" + minimalTemperature +
                ", maximumTemperature=" + maximumTemperature +
                '}';
    }
}
