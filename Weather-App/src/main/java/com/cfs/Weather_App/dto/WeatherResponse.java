package com.cfs.Weather_App.dto;

public class WeatherResponse {

    private String city;

    private String region;

    private String country;

    private Double temperature;

    private String condition;

    public WeatherResponse() {
    }

    public WeatherResponse(String city, String region, String country, Double temperature, String condition) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
