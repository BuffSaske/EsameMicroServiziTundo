package it.apuliadigitalmaker.esame.src.dto;

import java.util.Map;

public class CountryDto {
    private Name name;
    private double[] latlng;
    private String[] capital;
    private long population;
    private Map<String, String> flags;
    private Map<String, Currency> currencies;

    public static class Name {
        private String common;

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }
    }

    public static class Currency {
        private String name;
        private String symbol;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    // Getter e Setter
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public double[] getLatlng() {
        return latlng;
    }

    public void setLatlng(double[] latlng) {
        this.latlng = latlng;
    }

    public String[] getCapital() {
        return capital;
    }

    public void setCapital(String[] capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Map<String, String> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, String> flags) {
        this.flags = flags;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", latlng='" + getLatlng() + "'" +
            ", capital='" + getCapital() + "'" +
            ", population='" + getPopulation() + "'" +
            ", flags='" + getFlags() + "'" +
            ", currencies='" + getCurrencies() + "'" +
            "}";
    }
}