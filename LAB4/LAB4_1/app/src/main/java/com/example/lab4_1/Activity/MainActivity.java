package com.example.lab4_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4_1.R;

public class MainActivity extends AppCompatActivity {
    private static final int FOOD_REQUEST = 1;
    private static final int DRINK_REQUEST = 2;
    private String selectedFood = null;
    private String selectedDrink = null;
    private TextView tvSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_main_activity);
        Button btnChonThucAn = findViewById(R.id.btnChonThucAn);
        Button btnChonDoUong = findViewById(R.id.btnChonDoUong);
        Button btnThoat = findViewById(R.id.btnThoat);
        tvSelection = findViewById(R.id.tvSelection);

        btnChonThucAn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivityForResult(intent, FOOD_REQUEST);
        });
        btnChonDoUong.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
            startActivityForResult(intent, DRINK_REQUEST);
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            String selection = data.getStringExtra("selection");
            if (requestCode == FOOD_REQUEST) {
                selectedFood = selection;
            } else if (requestCode == DRINK_REQUEST) {
                selectedDrink = selection;
            }

            updateSelectionDisplay();
        }
    }

    private void updateSelectionDisplay() {
        String displayText = "";
        if (selectedFood != null) {
            displayText += selectedFood;
        }
        if (selectedDrink != null) {
            if (!displayText.isEmpty()) {
                displayText += " - ";
            }
            displayText += selectedDrink;
        }
        if (displayText.isEmpty()) {
            displayText = "Chưa chọn món ăn và đồ uống";
        }

        tvSelection.setText(displayText);
    }
}