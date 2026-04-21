package com.cfs.Weather_App.controller;

import com.cfs.Weather_App.dto.MyAppForecast;
import com.cfs.Weather_App.dto.WeatherResponse;
import com.cfs.Weather_App.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){
        return weatherService.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return weatherService.getResponse(city);
    }

    @GetMapping("/forcast")
    public MyAppForecast getForeCast(@RequestParam String city, @RequestParam int days) {
        return weatherService.getForcastResponse(city,days);
    }
}
