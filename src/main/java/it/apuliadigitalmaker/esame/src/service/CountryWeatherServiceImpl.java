package it.apuliadigitalmaker.esame.src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.apuliadigitalmaker.esame.src.client.*;
import it.apuliadigitalmaker.esame.src.dto.*;
import it.apuliadigitalmaker.esame.src.entity.CountryWeather;
import it.apuliadigitalmaker.esame.src.repository.CountryWeatherRepository;
import it.apuliadigitalmaker.esame.src.service.interfaces.ICountryWeatherService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class CountryWeatherServiceImpl implements ICountryWeatherService {

    @Autowired
    private ICountryClient countryClient;
    @Autowired
    private IWeatherClient weatherClient;
    @Autowired
    private CountryWeatherRepository repository;

    @Override
    public CountryWeatherDto getCountryWeather(String countryName) {
        // 1. Cerca se esiste già nel DB
        Optional<CountryWeather> existing = repository.findByCountryName(countryName);

        if (existing.isPresent()) {
            return mapEntityToDto(existing.get());
        }

        // 2. Se non esiste, chiama le API esterne
        CountryDto[] countryData = countryClient.getByName(countryName);
        if (countryData == null || countryData.length == 0) {
            return null;
        }

        Map<String, Object> weatherResponse = weatherClient.getForecast(
                countryData[0].getLatlng()[0],
                countryData[0].getLatlng()[1],
                true);

        // 3. Salva nuovo record
        CountryWeather entity = createEntity(countryData[0], weatherResponse);
        return mapEntityToDto(repository.save(entity));
    }

    private CountryWeather createEntity(CountryDto country, Map<String, Object> weatherResponse) {
        CountryWeather entity = new CountryWeather();
        entity.setCountryName(country.getName().getCommon());
        entity.setCapital(country.getCapital()[0]);
        entity.setLatitude(country.getLatlng()[0]);
        entity.setLongitude(country.getLatlng()[1]);
        entity.setPopulation(country.getPopulation());

        if (!country.getCurrencies().isEmpty()) {
            Map.Entry<String, CountryDto.Currency> entry = country.getCurrencies().entrySet().iterator().next();
            entity.setCurrency(entry.getKey());
        }

        entity.setFlagPng(country.getFlags().get("png"));

        if (weatherResponse != null && weatherResponse.containsKey("current_weather")) {
            Map<String, Object> currentWeather = (Map<String, Object>) weatherResponse.get("current_weather");
            entity.setTemperature((Double) currentWeather.get("temperature"));
            entity.setWeatherCode((Integer) currentWeather.get("weathercode"));
        }

        entity.setRetrievedAt(LocalDateTime.now());
        return entity;
    }

    @Override
    public CountryWeatherDto updateCountry(String countryName, UpdateCountryRequest updateRequest) {
        Optional<CountryWeather> entityOpt = repository.findByCountryName(countryName);
        if (!entityOpt.isPresent()) {
            return null;
        }

        CountryWeather entity = entityOpt.get();
        if (updateRequest.getVisited() != null) {
            entity.setVisited(updateRequest.getVisited());
        }
        if (updateRequest.getNotes() != null) {
            entity.setNotes(updateRequest.getNotes());
        }
        if (updateRequest.getRating() != null) {
            entity.setRating(updateRequest.getRating());
        }

        repository.save(entity);
        return mapEntityToDto(entity);
    }

    private CountryWeatherDto mapEntityToDto(CountryWeather entity) {
        CountryWeatherDto dto = new CountryWeatherDto();
        dto.setId(entity.getId());
        dto.setCountryName(entity.getCountryName());
        dto.setCapital(entity.getCapital());
        dto.setPopulation(entity.getPopulation());
        dto.setCurrency(entity.getCurrency());
        dto.setFlagPng(entity.getFlagPng());

        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setTemperature(entity.getTemperature());
        weatherDto.setWeatherCode(entity.getWeatherCode());
        weatherDto.setRetrievedAt(entity.getRetrievedAt().toString());
        dto.setWeather(weatherDto);

        // Aggiungi il mapping dei nuovi campi
        dto.setVisited(entity.getVisited());
        dto.setNotes(entity.getNotes());
        dto.setRating(entity.getRating());

        return dto;
    }
}