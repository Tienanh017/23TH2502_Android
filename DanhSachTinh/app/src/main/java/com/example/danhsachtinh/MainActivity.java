package com.example.danhsachtinh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Hiển thị danh sách tỉnh thành lên ListView
        // Bước 1: Tạo danh sách dữ liệu
        ArrayList<String> dsTenTinhThanhVN = new ArrayList<>();
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình Dương");

        // Bước 2: Khởi tạo ArrayAdapter
        ArrayAdapter<String> arrayAdapterTinhThanh = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN
        );

        // Bước 3: Áp dụng adapter vào ListView
        ListView lvTenTinhThanhVN = findViewById(R.id.lvDanhsachtt);
        lvTenTinhThanhVN.setAdapter(arrayAdapterTinhThanh);

        // Điều chỉnh insets cho view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
