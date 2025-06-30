package it.apuliadigitalmaker.esame.src.client;

import java.util.HashMap;
import java.util.Map;

import it.apuliadigitalmaker.esame.src.dto.CountryDto;

public class ClientFallback implements IWeatherClient, ICountryClient {
    @Override
    public CountryDto[] getByName(String country) {
        return new CountryDto[0];
    }

    @Override
    public Map<String, Object> getForecast(double latitude, double longitude, boolean currentWeather) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> currentWeatherMap = new HashMap<>();
        currentWeatherMap.put("temperature", 0.0);
        currentWeatherMap.put("weathercode", 0);
        currentWeatherMap.put("time", "N/A");
        response.put("current_weather", currentWeatherMap);
        return response;
    }
} 