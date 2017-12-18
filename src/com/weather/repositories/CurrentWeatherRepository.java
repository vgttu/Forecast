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
    public CurrentWeatherRepository() {
    }

    public CurrentWeatherRepository(boolean mock) {
        this.mock = mock;
    }

    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        String response = ! this.isMock() ? this.readUrl("/weather", params) : this.getMockString(request);

        return new CurrentWeatherReport(new JSONObject(response));
    }

    public static CurrentWeatherRepository mock() {
        return new CurrentWeatherRepository(true);
    }

    @Override
    public String getMockString(WeatherRequest request) {
        return "{\"coord\":{\"lon\":24.75,\"lat\":59.44},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":1,\"pressure\":1001,\"humidity\":100,\"temp_min\":1,\"temp_max\":1},\"visibility\":9000,\"wind\":{\"speed\":2.6,\"deg\":160},\"clouds\":{\"all\":90},\"dt\":1513439400,\"sys\":{\"type\":1,\"id\":5014,\"message\":0.0022,\"country\":\"" + request.getCode() + "\",\"sunrise\":1513408478,\"sunset\":1513430357},\"id\":590447,\"name\":\"" + request.getCity() + "\",\"cod\":200}";
    }
}
