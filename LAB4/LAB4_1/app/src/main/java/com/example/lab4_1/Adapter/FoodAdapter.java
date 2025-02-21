package com.example.lab4_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab4_1.Object.Food;
import com.example.lab4_1.R;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Food currentFood = getItem(position);
        ImageView imgFood = convertView.findViewById(R.id.imgFood);
        TextView tvFoodName = convertView.findViewById(R.id.tvFoodName);
        TextView tvFoodPrice = convertView.findViewById(R.id.tvFoodPrice);
        imgFood.setImageResource(currentFood.getImageResId());
        tvFoodName.setText(currentFood.getName());
        tvFoodPrice.setText(currentFood.getPrice());

        return convertView;
    }
}
