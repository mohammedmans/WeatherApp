package com.example.mohammedmansour.weatherapp.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.mohammedmansour.weatherapp.API.JSON.City;
import com.example.mohammedmansour.weatherapp.API.JSON.ListItem;
import com.example.mohammedmansour.weatherapp.API.JSON.Main;
import com.example.mohammedmansour.weatherapp.API.JSON.WeatherItem;

@Database(entities = {City.class, ListItem.class, Main.class, WeatherItem.class}, version = 1, exportSchema = false)
public abstract class WeatherDB extends RoomDatabase {
    private static WeatherDB myDB = null;
    
    public abstract WeatherDao weatherDao();

    public static WeatherDB getInstance(Context context){
        if(myDB ==null){

            myDB =
                    Room.databaseBuilder(context.getApplicationContext()
                            ,WeatherDB.class,"Weather-DB")
                            .allowMainThreadQueries()
                            .build();
        }
        return myDB;
    }
}
