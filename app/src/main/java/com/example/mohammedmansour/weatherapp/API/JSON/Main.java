package com.example.mohammedmansour.weatherapp.API.JSON;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity
public class Main {
    @NonNull
    @ColumnInfo
    @PrimaryKey
    private String Main_id;

    @SerializedName("temp")
    private double temp;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("grnd_level")
    private double grndLevel;

    @SerializedName("temp_kf")
    private double tempKf;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("sea_level")
    private double seaLevel;

    @SerializedName("temp_max")
    private double tempMax;

    public String getMain_id() {
        return Main_id;
    }

    public void setMain_id(String main_id) {
        Main_id = main_id;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public double getGrndLevel() {
        return grndLevel;
    }

    public void setTempKf(double tempKf) {
        this.tempKf = tempKf;
    }

    public double getTempKf() {
        return tempKf;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMax() {
        return tempMax;
    }

    @Override
    public String toString() {
        return
                "Main{" +
                        "temp = '" + temp + '\'' +
                        ",temp_min = '" + tempMin + '\'' +
                        ",grnd_level = '" + grndLevel + '\'' +
                        ",temp_kf = '" + tempKf + '\'' +
                        ",humidity = '" + humidity + '\'' +
                        ",pressure = '" + pressure + '\'' +
                        ",sea_level = '" + seaLevel + '\'' +
                        ",temp_max = '" + tempMax + '\'' +
                        "}";
    }
}