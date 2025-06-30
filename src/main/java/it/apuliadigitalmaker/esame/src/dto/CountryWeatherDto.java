package it.apuliadigitalmaker.esame.src.dto;

public class CountryWeatherDto {
    private Long id;
    private String countryName;
    private String capital;
    private long population;
    private String currency;
    private String flagPng;
    private WeatherDto weather;
    private Boolean visited;
    private String notes;
    private Integer rating;


    public CountryWeatherDto() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFlagPng() {
        return flagPng;
    }

    public void setFlagPng(String flagPng) {
        this.flagPng = flagPng;
    }

    public WeatherDto getWeather() {
        return weather;
    }

    public void setWeather(WeatherDto weather) {
        this.weather = weather;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CountryWeatherDto [country=" + countryName + ", capital=" + capital + ", population=" + population
                + ", currency=" + currency + ", flagPng=" + flagPng + ", weather=" + weather + "]";
    }
}