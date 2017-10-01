package com.weather.repositories;

import org.json.*;
import com.weather.WeatherRequest;
import com.weather.reports.CurrentWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class CurrentWeatherRepository extends Repository {
    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        String response = this.readUrl("/find", params);

        return new CurrentWeatherReport(new JSONObject(response));
    }
}
