package com.example.haihm.shelf.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.haihm.shelf.R;
import com.example.haihm.shelf.adapter.ThemAnhSPAdapter;
import com.example.haihm.shelf.event.OnClickAddPhotoEvent;
import com.example.haihm.shelf.utils.ImageUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DangSpDGActivity extends AppCompatActivity {
    private static final String TAG = "DangSpDGActivity";
    EditText etTenSP,etgiaSP,etDiaC,etMoTaSP,etBuocG;
    Spinner spLoaiSP;
    Button btRaoBan;
    RadioButton rb_3h,rb_6h,rb_12h,rb_1ngay;
    String []loaiSP;
    List<String> lanhSP;
    RecyclerView recyclerView;
    ThemAnhSPAdapter anhSPAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_sp_dg);
        EventBus.getDefault().register(this);
        setupUI();
    }

    private void setupUI() {
        etTenSP = findViewById(R.id.et_ten_sp);
        etgiaSP = findViewById(R.id.et_gia);
        etBuocG = findViewById(R.id.et_buoc_gia);
        etDiaC = findViewById(R.id.et_diaC);
        etMoTaSP = findViewById(R.id.et_mo_ta);
        spLoaiSP = findViewById(R.id.sp_loai_sp);
        rb_3h = findViewById(R.id.rb_3h);
        rb_6h = findViewById(R.id.rb_6h);
        rb_12h = findViewById(R.id.rb_12h);
        rb_1ngay = findViewById(R.id.rb_1ngay);
        btRaoBan = findViewById(R.id.bt_rao_ban);
        recyclerView = findViewById(R.id.rv_anh_sp_dg);
        loaiSP = getResources().getStringArray(R.array.loai_sp);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,loaiSP);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLoaiSP.setAdapter(adapter);

        lanhSP = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.add_picture);
        lanhSP.add(ImageUtils.endcodeImageToBase64(bitmap));

        anhSPAdapter = new ThemAnhSPAdapter(lanhSP,this);
        recyclerView.setAdapter(anhSPAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    @Subscribe(sticky = true)
    public void OnReceivedOnClickAddPhotoEvent(OnClickAddPhotoEvent onClickAddPhotoEvent){
        selectFuntion();
    }
    private void selectFuntion() {
        final String[] item = {"Chụp ảnh", "Mở Bộ sưu tập", "Huỷ"};

        AlertDialog.Builder builder = new AlertDialog.Builder(DangSpDGActivity.this);
        builder.setTitle("Thêm Ảnh");
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(item[i].equals("Chụp ảnh")){
                    cameraIntent();
                }
                else if(item[i].equals("Mở Bộ sưu tập")){
                    galleryIntent();
                }
                else{
                    dialogInterface.dismiss();
                }
            }
        }).show();

    }
    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*"); // mở tất cả các folder lưa trữ ảnh
        intent.setAction(Intent.ACTION_GET_CONTENT); // đi đến folder mình chọn
        startActivityForResult(Intent.createChooser(intent, "Chọn Ảnh"), 1);
    }

    private void cameraIntent() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = ImageUtils.getUriFromImage(this);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        //check xem co ton tai intent nao khong

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Bitmap bitmap = null;
                Log.d(TAG, "onActivityResult: ");
                if (data != null) {
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e(TAG, "Data Null!!!!");
                }
                lanhSP.add(0,ImageUtils.endcodeImageToBase64(bitmap));
                anhSPAdapter.notifyDataSetChanged();
            }
            else if(requestCode == 2){
                Bitmap bitmap = null;
                if (resultCode == RESULT_OK) {
                    Log.e("check request", "I'm here");
                    bitmap = ImageUtils.getBitmap(this);
                    lanhSP.add(0,ImageUtils.endcodeImageToBase64(bitmap));
                    anhSPAdapter.notifyDataSetChanged();
                }

            }

        }
    }
}
