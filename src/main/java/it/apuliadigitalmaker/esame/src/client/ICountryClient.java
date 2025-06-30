package it.apuliadigitalmaker.esame.src.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.apuliadigitalmaker.esame.src.dto.CountryDto;

@FeignClient(name = "rest-countries", url = "https://restcountries.com/v3.1", fallback = ClientFallback.class)
public interface ICountryClient {
    @GetMapping("/name/{country}")
    CountryDto[] getByName(@PathVariable("country") String country);
}