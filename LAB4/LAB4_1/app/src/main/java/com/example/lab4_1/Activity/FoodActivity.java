package com.example.lab4_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


import com.example.lab4_1.Adapter.FoodAdapter;
import com.example.lab4_1.Object.Food;
import com.example.lab4_1.R;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    private ListView foodListView;
    private ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_food_activity);
        foodListView = findViewById(R.id.foodListView);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.pho, "Phở Hà Nội", "30,000 VND"));
        foodList.add(new Food(R.drawable.bun_bo_hue, "Bún Bò Huế", "35,000 VND"));
        foodList.add(new Food(R.drawable.mi_quang, "Mì Quảng", "40,000 VND"));
        foodList.add(new Food(R.drawable.hu_tieu, "Hủ Tíu Sài Gòn", "25,000 VND"));
        FoodAdapter adapter = new FoodAdapter(this, foodList);
        foodListView.setAdapter(adapter);

        foodListView.setOnItemClickListener((parent, view, position, id) -> {
            Food selectedFood = foodList.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selection", selectedFood.getName());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
