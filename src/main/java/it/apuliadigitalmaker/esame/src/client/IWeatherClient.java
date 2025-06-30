package it.apuliadigitalmaker.esame.src.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "open-meteo", url = "https://api.open-meteo.com/v1", fallback = ClientFallback.class)
public interface IWeatherClient {
    @GetMapping("/forecast")
    Map<String, Object> getForecast(
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @RequestParam("current_weather") boolean currentWeather
    );
}
