package com.cyrine.pays;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private int flagResourceId;
    private String continent;
    private String capital;
    private String currency;

    public Country(String name, int flagResourceId, String continent, String capital, String currency) {
        this.name = name;
        this.flagResourceId = flagResourceId;
        this.continent = continent;
        this.capital = capital;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", flagResourceId=" + flagResourceId +
                ", continent='" + continent + '\'' +
                ", capital='" + capital + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getFlagResourceId() {
        return flagResourceId;
    }

    public String getContinent() {
        return continent;
    }

    public String getCapital() {
        return capital;
    }

    public String getCurrency() {
        return currency;
    }
}
