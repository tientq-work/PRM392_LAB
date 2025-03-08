package com.example.onelinepayment;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    EditText edtSoluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.buttonConfirm);
        edtSoluong = findViewById(R.id.editTextSoluong);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSoluong.getText() == null || edtSoluong.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhập số lượng mua", Toast.LENGTH_SHORT).show();
                    return;
                }

                String s = edtSoluong.getText().toString();
                double total = Double.parseDouble(s) * 1000000;

                Intent intent = new Intent(MainActivity.this, OrderPayment.class);
                intent.putExtra("soluong", edtSoluong.getText().toString());
                intent.putExtra("total", total);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}