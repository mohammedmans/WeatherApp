package com.example.mohammedmansour.weatherapp.API.JSON;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class WeatherItem {

    @SerializedName("icon")
    private String icon;

    @SerializedName("description")
    private String description;

    @SerializedName("main")
    private String main;

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    private int id;

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getMain() {
        return main;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "WeatherItem{" +
                        "icon = '" + icon + '\'' +
                        ",description = '" + description + '\'' +
                        ",main = '" + main + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}