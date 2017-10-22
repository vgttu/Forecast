package com.weather.reports;

import org.json.*;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class CurrentWeatherReport extends Report {
    public CurrentWeatherReport(JSONObject json) {
        this.city = json.getString("name");
        this.code = json.getJSONObject("sys").getString("country");

        this.currentTemperature = json.getJSONObject("main").getDouble("temp");
        this.minimalTemperature = json.getJSONObject("main").getDouble("temp_min");
        this.maximumTemperature = json.getJSONObject("main").getDouble("temp_max");
    }
}
