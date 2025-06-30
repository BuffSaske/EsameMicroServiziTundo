package it.apuliadigitalmaker.esame.src.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CountryWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) 
    private String countryName;
    private String capital;
    private double latitude;
    private double longitude;
    private long population;
    private String currency;
    private String flagPng;
    private double temperature;
    private int weatherCode;
    private LocalDateTime retrievedAt;
    private Boolean visited;
    private String notes;
    private Integer rating;

    
    public CountryWeather() {}

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String country) {
        this.countryName = country;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getPopulation() {
        return this.population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFlagPng() {
        return this.flagPng;
    }

    public void setFlagPng(String flagPng) {
        this.flagPng = flagPng;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeatherCode() {
        return this.weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public LocalDateTime getRetrievedAt() {
        return this.retrievedAt;
    }

    public void setRetrievedAt(LocalDateTime retrievedAt) {
        this.retrievedAt = retrievedAt;
    }

    public Boolean isVisited() {
        return this.visited;
    }

    public Boolean getVisited() {
        return this.visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" +
            " country='" + getCountryName() + "'" +
            ", capital='" + getCapital() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", population='" + getPopulation() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", flagPng='" + getFlagPng() + "'" +
            ", temperature='" + getTemperature() + "'" +
            ", weatherCode='" + getWeatherCode() + "'" +
            ", retrievedAt='" + getRetrievedAt() + "'" +
            ", visited='" + isVisited() + "'" +
            ", notes='" + getNotes() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    
    }