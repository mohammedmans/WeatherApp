package com.example.mohammedmansour.weatherapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohammedmansour.weatherapp.API.JSON.ListItem;
import com.example.mohammedmansour.weatherapp.API.JSON.Main;
import com.example.mohammedmansour.weatherapp.API.JSON.WeatherItem;
import com.example.mohammedmansour.weatherapp.R;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.CustomViewHolder> {
    List<WeatherItem> weatherItems;
    List<Main> mainList;
    List<ListItem> listItems;
    Context context;


    public WeatherAdapter(List<WeatherItem> weatherItems, List<Main> mainList, Context context) {
        this.weatherItems = weatherItems;
        this.context = context;
        this.mainList = mainList;
    }

    public WeatherAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item_view, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
//        WeatherItem weatherItem = weatherItems.get(i);
        ListItem listItem = listItems.get(i);
        customViewHolder.temp.setText(Double.toString(listItem.getMain().getTemp()));
//        Main main = mainList.get(i);
//        customViewHolder.temp.setText(Double.toString(main.getTemp()));
        customViewHolder.date.setText(listItem.getDtTxt());
    }

    @Override
    public int getItemCount() {
        if (listItems == null) return 0;
        return listItems.size();
    }

    public void setUpdatedData(List<ListItem> listItems) {
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView temp, date;
        View parnet;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            temp = view.findViewById(R.id.temp_tv);
            date = view.findViewById(R.id.date_tv);
            parnet = view;

        }
    }

}
