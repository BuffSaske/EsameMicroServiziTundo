package it.apuliadigitalmaker.esame.src.dto;

public class WeatherDto {
    private double temperature;
    private int weatherCode;
    private String retrievedAt;

    public WeatherDto() {
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getRetrievedAt() {
        return retrievedAt;
    }

    public void setRetrievedAt(String retrievedAt) {
        this.retrievedAt = retrievedAt;
    }

    @Override
    public String toString() {
        return "WeatherDto [temperature=" + temperature + ", weatherCode=" + weatherCode + ", retrievedAt=" + retrievedAt + "]";
    }
}