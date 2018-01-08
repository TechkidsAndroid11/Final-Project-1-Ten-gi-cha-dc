package com.example.haihm.shelf.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.haihm.shelf.R;

public class DangSpRv extends AppCompatActivity {
    EditText etTenSP,etgiaSP,etDiaC,etMoTaSP;
    Spinner spLoaiSP;
    Button btRaoBan;
    String []loaiSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_sp_rv);
        setupUI();
    }

    private void setupUI() {
        etTenSP = findViewById(R.id.et_ten_sp);
        etgiaSP = findViewById(R.id.et_gia);
        etDiaC = findViewById(R.id.et_diaC);
        etMoTaSP = findViewById(R.id.et_mo_ta);
        spLoaiSP = findViewById(R.id.sp_loai_sp);
        btRaoBan = findViewById(R.id.bt_rao_ban);
        loaiSP = getResources().getStringArray(R.array.loai_sp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,loaiSP);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLoaiSP.setAdapter(adapter);
    }
}
