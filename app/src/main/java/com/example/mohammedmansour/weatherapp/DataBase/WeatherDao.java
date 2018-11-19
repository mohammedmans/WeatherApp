package com.example.mohammedmansour.weatherapp.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.mohammedmansour.weatherapp.API.JSON.ListItem;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void addAllWeather(List<ListItem>listItems);

    @Query("delete from ListItem")
    void removeAllWeather();

    @Query("select * from ListItem")
    List<ListItem> getWeather();

    @Query("select * from ListItem where listItem_id=:cityName")
    List<ListItem> getWeatherByCity(String cityName);
}
