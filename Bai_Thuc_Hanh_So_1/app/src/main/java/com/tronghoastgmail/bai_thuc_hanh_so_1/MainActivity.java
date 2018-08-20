package com.tronghoastgmail.bai_thuc_hanh_so_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener{
    TextView htten;
    TextView htloi;
    EditText nhapten;
    EditText nhaptuoi;
    EditText nhaphsl;
    Button nhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();

    }

    private void AddEvents() {
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThongTinCaNhan();
            }
        });
    }

    private void xuLyHienThongTinCaNhan() {

        if(nhapten.getText().toString().isEmpty())
        {
            htloi.setText("Vui lòng nhập tên");
        }else if (nhaptuoi.getText().toString().isEmpty()
                || nhaphsl.getText().toString().isEmpty())
            {
                htten.setText("Nhập Sai");
                htloi.setText("");
            }else {
            String layten = nhapten.getText().toString();
            int laytuoi = Integer.parseInt(nhaptuoi.getText().toString());
            double layhsl = Double.parseDouble(nhaphsl.getText().toString());
            NhanVien nv = new NhanVien();
            nv.setHoTen(layten);
            nv.setTuoi(laytuoi);
            nv.setHeSoLuong(layhsl);
            htten.setText(nv.toString());
            htloi.setText("");
        }
    }

    private void AddControls() {
        htten = findViewById(R.id.hoten);
        htloi = findViewById(R.id.baoloi);
        nhapten = findViewById(R.id.nhapten);
        nhaptuoi = findViewById(R.id.nhaptuoi);
        nhaphsl = findViewById(R.id.nhaphsl);
        nhap = findViewById(R.id.buttonnhap);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }


}
