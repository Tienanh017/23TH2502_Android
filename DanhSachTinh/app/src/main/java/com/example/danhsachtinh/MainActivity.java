package com.example.danhsachtinh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến dsTenTinhThanhVN ở cấp lớp
    ArrayList<String> dsTenTinhThanhVN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Hiển thị danh sách tỉnh thành lên ListView
        dsTenTinhThanhVN = new ArrayList<>();
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình Dương");

        // Khởi tạo ArrayAdapter
        ArrayAdapter<String> arrayAdapterTinhThanh = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN
        );

        // Áp dụng adapter vào ListView
        ListView lvTenTinhThanhVN = findViewById(R.id.lvDanhsachtt);
        lvTenTinhThanhVN.setAdapter(arrayAdapterTinhThanh);

        // Gán sự kiện khi nhấn lâu vào một item trong ListView
        lvTenTinhThanhVN.setOnItemLongClickListener(BoLangNghevaXL);

        // Điều chỉnh insets cho view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Sự kiện xử lý khi nhấn lâu vào item trong ListView
    AdapterView.OnItemLongClickListener BoLangNghevaXL = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
            // Hiển thị Toast khi nhấn lâu vào item
            Toast.makeText(MainActivity.this, "Nhấn lâu: " + dsTenTinhThanhVN.get(i), Toast.LENGTH_LONG).show();
            return true;
        }
    };
}
