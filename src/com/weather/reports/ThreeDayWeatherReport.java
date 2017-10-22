package com.weather.reports;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class ThreeDayWeatherReport extends Report {
    Map<String, Map<String, Double>> temperatures;

    public ThreeDayWeatherReport(JSONObject json) {
        this.city = json.getJSONObject("city").getString("name");
        this.code = json.getJSONObject("city").getString("country");

        JSONArray list = json.getJSONArray("list");
        Map<String, Map<String, Double>> temperatures = new HashMap<String, Map<String, Double>>();

        for (int i = 0; i < list.length(); i++) {
            JSONObject item = list.getJSONObject(i);

            if (temperatures.size() >= 3) {
                break;
            }

            Date date = new Date((long) item.getInt("dt") * 1000);
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            String key = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Map<String, Double> weather = temperatures.getOrDefault(key, null);

            if (weather == null) {
                weather = new HashMap<String, Double>();

                weather.put("min", item.getJSONObject("main").getDouble("temp_min"));
                weather.put("max", item.getJSONObject("main").getDouble("temp_max"));
            }

            if (weather.get("min") > item.getJSONObject("main").getDouble("temp_min")) {
                weather.put("min", item.getJSONObject("main").getDouble("temp_min"));
            }

            if (weather.get("max") < item.getJSONObject("main").getDouble("temp_max")) {
                weather.put("max", item.getJSONObject("main").getDouble("temp_max"));
            }

            temperatures.put(key, weather);
        }

        this.temperatures = temperatures;
    }

    public Map<String, Map<String, Double>> getTemperatures() {
        return temperatures;
    }
}
