package it.apuliadigitalmaker.esame.src.repository;

import org.springframework.data.repository.CrudRepository;
import it.apuliadigitalmaker.esame.src.entity.CountryWeather;
import java.util.Optional;

public interface CountryWeatherRepository extends CrudRepository<CountryWeather, Long> {
    Optional<CountryWeather> findByCountryName(String countryName);
}