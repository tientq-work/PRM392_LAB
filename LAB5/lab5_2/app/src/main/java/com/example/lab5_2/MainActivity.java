package com.example.lab5_2;

import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;
    private List<Module> moduleList;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        moduleList = new ArrayList<>();
        moduleList.add(new Module("ListView trong Android", "ListView trong Android là một thành phần dùng để nhóm nhiều mục (item)...", "Android", R.drawable.android));
        moduleList.add(new Module("Xử lý sự kiện trong iOS", "Xử lý sự kiện trong iOS. Sau khi các bạn đã biết cách thiết kế giao diện...", "iOS", R.drawable.ios));
        moduleAdapter = new ModuleAdapter(moduleList, new ModuleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedPosition = position;
            }
        });
        recyclerView.setAdapter(moduleAdapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
        Button btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    showUpdateDialog(selectedPosition);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một item để cập nhật!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    moduleAdapter.removeItem(selectedPosition);
                    selectedPosition = -1;
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một item để xóa!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm Module Mới");
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_module, null);
        builder.setView(dialogView);

        final EditText etTitle = dialogView.findViewById(R.id.etTitle);
        final EditText etDescription = dialogView.findViewById(R.id.etDescription);
        final EditText etPlatform = dialogView.findViewById(R.id.etPlatform);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                String platform = etPlatform.getText().toString();
                int imageResId = R.drawable.android;
                if (title.isEmpty() || description.isEmpty() || platform.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                moduleAdapter.addItem(new Module(title, description, platform, imageResId));
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void showUpdateDialog(int position) {
        Module module = moduleList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cập Nhật Module");

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_module, null);
        builder.setView(dialogView);

        final EditText etTitle = dialogView.findViewById(R.id.etTitle);
        final EditText etDescription = dialogView.findViewById(R.id.etDescription);
        final EditText etPlatform = dialogView.findViewById(R.id.etPlatform);

        etTitle.setText(module.getTitle());
        etDescription.setText(module.getDescription());
        etPlatform.setText(module.getPlatform());

        builder.setPositiveButton("Cập Nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                String platform = etPlatform.getText().toString();
                int imageResId = R.drawable.android;
                moduleAdapter.updateItem(position, new Module(title, description, platform, imageResId));
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
