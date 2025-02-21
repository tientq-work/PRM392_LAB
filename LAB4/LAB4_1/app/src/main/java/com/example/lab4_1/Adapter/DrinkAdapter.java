package com.example.lab4_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lab4_1.Object.Drink;
import com.example.lab4_1.R;

import java.util.ArrayList;

public class DrinkAdapter extends ArrayAdapter<Drink> {
    public DrinkAdapter(Context context, ArrayList<Drink> drinks) {
        super(context, 0, drinks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Drink currentDrink = getItem(position);
        ImageView imgDrink = convertView.findViewById(R.id.imgFood);
        TextView tvDrinkName = convertView.findViewById(R.id.tvFoodName);
        TextView tvDrinkPrice = convertView.findViewById(R.id.tvFoodPrice);
        imgDrink.setImageResource(currentDrink.getImageResId());
        tvDrinkName.setText(currentDrink.getName());
        tvDrinkPrice.setText(currentDrink.getPrice());

        return convertView;
    }
}