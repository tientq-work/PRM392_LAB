package com.example.lab4_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo views
        tvResult = findViewById(R.id.tvResult);
        Button btnString = findViewById(R.id.btnString);
        Button btnNumber = findViewById(R.id.btnNumber);
        Button btnArray = findViewById(R.id.btnArray);
        Button btnBoolean = findViewById(R.id.btnBoolean);
        Button btnMixed = findViewById(R.id.btnMixed);

        // 1. Xử lý String
        btnString.setOnClickListener(v -> {
            String data = "Hello from Button!";
            displayResult("String Data", data);
        });

        // 2. Xử lý Number
        btnNumber.setOnClickListener(v -> {
            int intNumber = 100;
            double doubleNumber = 3.14;
            String result = String.format("Integer: %d\nDouble: %.2f", intNumber, doubleNumber);
            displayResult("Number Data", result);
        });

        // 3. Xử lý Array
        btnArray.setOnClickListener(v -> {
            String[] stringArray = {"Apple", "Banana", "Orange"};
            int[] intArray = {1, 2, 3, 4, 5};

            StringBuilder result = new StringBuilder();
            result.append("String Array: ").append(Arrays.toString(stringArray));
            result.append("\nInt Array: ").append(Arrays.toString(intArray));

            displayResult("Array Data", result.toString());
        });

        // 4. Xử lý Boolean
        btnBoolean.setOnClickListener(v -> {
            boolean isActive = true;
            boolean isValid = false;
            String result = String.format("Is Active: %b\nIs Valid: %b", isActive, isValid);
            displayResult("Boolean Data", result);
        });

        // 5. Xử lý Mixed
        btnMixed.setOnClickListener(v -> {
            // String
            String name = "John";

            // Number
            int age = 25;
            double score = 8.5;

            // Array
            String[] hobbies = {"Reading", "Gaming", "Coding"};
            int[] scores = {85, 90, 95};

            // Boolean
            boolean isStudent = true;

            StringBuilder result = new StringBuilder();
            result.append("Name: ").append(name)
                    .append("\nAge: ").append(age)
                    .append("\nScore: ").append(score)
                    .append("\nHobbies: ").append(Arrays.toString(hobbies))
                    .append("\nScores: ").append(Arrays.toString(scores))
                    .append("\nIs Student: ").append(isStudent);

            displayResult("Mixed Data", result.toString());
        });
    }

    private void displayResult(String title, String content) {
        String fullResult = String.format("=== %s ===\n%s", title, content);
        // Gán trực tiếp kết quả mới, xóa kết quả cũ
        tvResult.setText(fullResult);
    }
}