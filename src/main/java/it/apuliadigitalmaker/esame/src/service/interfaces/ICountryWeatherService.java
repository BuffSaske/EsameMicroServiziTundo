package it.apuliadigitalmaker.esame.src.service.interfaces;

import it.apuliadigitalmaker.esame.src.dto.CountryWeatherDto;
import it.apuliadigitalmaker.esame.src.dto.UpdateCountryRequest;

public interface ICountryWeatherService {
    CountryWeatherDto getCountryWeather(String countryName);
    CountryWeatherDto updateCountry(String countryName, UpdateCountryRequest updateRequest);
}