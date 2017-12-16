package com.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
public class WeatherRequest {
    protected String city;
    protected String code;
    protected String units = "metric";

    protected Double latitude;
    protected Double longtitude;

    public WeatherRequest(String city, String code) {
        this.city = city;
        this.code = code;
    }

    public WeatherRequest(String city, String code, String units) {
        this.city = city;
        this.code = code;
        this.units = units;
    }

    public WeatherRequest(Double latitude, Double longtitude, String units) {
        this.latitude = latitude;
        this.longtitude = longtitude;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public static List<WeatherRequest> requestsFromFile() throws IOException {
        FileHandler fh = new FileHandler();

        List<String> lines = fh.read("input.txt");
        List<WeatherRequest> requests = new ArrayList<>();

        lines.forEach(line -> {
            String[] parts = line.split(",");

            if (parts.length == 2) {
                requests.add(new WeatherRequest(parts[0], parts[1]));
            }
        });

        return requests;
    }

    public static WeatherRequest requestFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city with country code (Tallinn,EE): ");
        String input = scanner.nextLine();

        String[] parts = input.split(",");

        return new WeatherRequest(parts[0], parts[1]);
    }
}
