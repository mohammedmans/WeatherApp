package com.example.mohammedmansour.weatherapp.API;

import com.example.mohammedmansour.weatherapp.API.JSON.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("forecast")
    Call<WeatherResponse> getWeathers(@Query("appid") String appid,
                                      @Query("q") String country,
                                      @Query("cnt") int numOfDays);
}
