package com.example.mohammedmansour.weatherapp.API.JSON;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class City {

    @SerializedName("country")
    private String country;

    @Ignore
    @SerializedName("coord")
    private Coord coord;

    @SerializedName("name")
    private String name;

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    private int id;

    @SerializedName("population")
    private int population;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return
                "City{" +
                        "country = '" + country + '\'' +
                        ",coord = '" + coord + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",population = '" + population + '\'' +
                        "}";
    }
}