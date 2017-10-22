package com.weather.repositories;

import org.json.*;
import com.weather.WeatherRequest;
import com.weather.reports.ThreeDayWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class ThreeDayWeatherRepository extends Repository {
    public ThreeDayWeatherReport getThreeDayWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        String response = this.readUrl("/forecast", params);

        return new ThreeDayWeatherReport(new JSONObject(response));
    }
}
