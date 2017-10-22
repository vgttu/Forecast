package com.weather.reports;

/**
 * Created by Vladimir Gaidushin on 22.10.2017.
 * Junity Development, LLC.
 */
abstract public class Report {
    protected String city;
    protected String code;

    protected Double latitude;
    protected Double longtitude;

    protected Double currentTemperature;
    protected Double minimalTemperature;
    protected Double maximumTemperature;

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongtitude() {
        return longtitude;
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
