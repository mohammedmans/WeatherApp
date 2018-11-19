package com.example.mohammedmansour.weatherapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mohammedmansour.weatherapp.API.APIManager;
import com.example.mohammedmansour.weatherapp.API.JSON.City;
import com.example.mohammedmansour.weatherapp.API.JSON.ListItem;
import com.example.mohammedmansour.weatherapp.API.JSON.WeatherItem;
import com.example.mohammedmansour.weatherapp.API.JSON.WeatherResponse;
import com.example.mohammedmansour.weatherapp.Adapters.WeatherAdapter;
import com.example.mohammedmansour.weatherapp.Base.BaseActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity {
    RecyclerView recyclerView;
    TabLayout tabLayout;
    LinearLayoutManager layoutManager;
    WeatherAdapter weatherAdapter;
    public static String[] cityNames;
    public static final String appid = "95b00d0afe7c5a1c72061058b4b6b146";
    public static final int cnt = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        tabLayout = findViewById(R.id.tablayout);
        cityNames = getResources().getStringArray(R.array.cityNames);
        //Log.e("cities",""+cityNames.length);
        layoutManager = new LinearLayoutManager(this);
        weatherAdapter = new WeatherAdapter(null, activity);
        recyclerView.setAdapter(weatherAdapter);
        recyclerView.setLayoutManager(layoutManager);

        fillTablayout();
        getWeather();
    }

    public void getWeather() {
        ShowProgressBar();
        APIManager.getServices()
                .getWeathers(appid,"Cairo",cnt)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        HideProgressBar();
                        if(response.body().getCod().equals("200")){
                            weatherAdapter.setUpdatedData(response.body().getList());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getMessage());
                    }
                });
    }

    public void fillTablayout() {
        for (int i = 0; i < cityNames.length; ++i) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(cityNames[i]);
            tabLayout.addTab(tab);
        }
        tabLayout.getTabAt(0).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                loadWeather(tab.getText().toString());
                //Log.e("cityname",tab.getText().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                loadWeather(tab.getText().toString());
                //Log.e("cityname",tab.getText().toString());
            }
        });
    }

    public void loadWeather(String cityName) {
        ShowProgressBar();
        APIManager.getServices()
                .getWeathers(appid,cityName,cnt)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        HideProgressBar();
                        if(response.body().getCod().equals("200")){
                            weatherAdapter.setUpdatedData(response.body().getList());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getLocalizedMessage());
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String url = "https://www.facebook.com/DawaDoz";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
