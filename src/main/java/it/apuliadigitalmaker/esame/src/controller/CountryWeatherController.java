package it.apuliadigitalmaker.esame.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigitalmaker.esame.src.dto.CountryWeatherDto;
import it.apuliadigitalmaker.esame.src.dto.UpdateCountryRequest;
import it.apuliadigitalmaker.esame.src.service.interfaces.ICountryWeatherService;

@RestController
@RequestMapping("/country-weather")
public class CountryWeatherController {

    @Autowired
    private ICountryWeatherService service;

    @GetMapping("/{countryName}")
    public ResponseEntity<CountryWeatherDto> getCountryWeather(@PathVariable String countryName) {
        CountryWeatherDto result = service.getCountryWeather(countryName);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{countryName}")
    public ResponseEntity<CountryWeatherDto> updateCountry(
            @PathVariable String countryName,
            @RequestBody UpdateCountryRequest updateRequest) {
        CountryWeatherDto result = service.updateCountry(countryName, updateRequest);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}