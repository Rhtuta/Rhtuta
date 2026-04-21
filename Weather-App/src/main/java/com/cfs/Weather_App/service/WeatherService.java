package com.cfs.Weather_App.service;

import com.cfs.Weather_App.dto.*;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.url}")
    private String apiForecastUrl;

    public RestTemplate template = new RestTemplate();

    public String test()
    {
        return "good";
    }

    public WeatherResponse getResponse(String city){
        String url= apiUrl+"?key="+apiKey+"&q="+city;
        Root response = template.getForObject(url, Root.class);
       // return response;
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(response.getLocation().getName());
        weatherResponse.setRegion(response.getLocation().getRegion());
        weatherResponse.setCountry(response.getLocation().getCountry());
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());
        weatherResponse.setCondition(response.getCurrent().getCondition().getText());

        return weatherResponse;
    }

   public MyAppForecast getForcastResponse(String city, int days) {
        String url = apiForecastUrl + "?key=" + apiKey + "&q=" + city + "&days=" + days;
        Root apiResponse = template.getForObject(url, Root.class);
        MyAppForecast forcastResponse = new MyAppForecast();
        forcastResponse.setWeatherResponse(getResponse(city));
        List<DayTemp> dayTemp = new ArrayList<>();
        for (Forecastday d : apiResponse.getForecast().getForecastday()) {
            DayTemp day = new DayTemp();
            day.setDate(d.getDate());
            day.setMinTemp(d.getDay().getMintemp_c());
            day.setMaxTemp(d.getDay().getMaxtemp_c());
            day.setAvgTemp(d.getDay().getAvgtemp_c());

            dayTemp.add(day);

        }
        forcastResponse.setDayTemp(dayTemp);
        return forcastResponse;
    }
}
