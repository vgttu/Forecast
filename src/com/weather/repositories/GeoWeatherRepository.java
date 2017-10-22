package com.weather.repositories;

import org.json.*;
import com.weather.WeatherRequest;
import com.weather.reports.GeoWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class GeoWeatherRepository extends Repository {
    public GeoWeatherReport getGeoWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("lat", String.valueOf(request.getLatitude()));
        params.put("lon", String.valueOf(request.getLongtitude()));
        params.put("units", request.getUnits());

        String response = this.readUrl("/weather", params);

        return new GeoWeatherReport(new JSONObject(response));
    }
}
