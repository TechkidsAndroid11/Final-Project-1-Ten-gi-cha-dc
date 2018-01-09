package com.example.haihm.shelf.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.haihm.shelf.R;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TabLayout tlBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        tlBottomBar = findViewById(R.id.tl_bottom_bar);

        setupTabLayout();
    }

    private void setupTabLayout() {
        tlBottomBar.addTab(tlBottomBar.newTab().setIcon(R.drawable.ic_shopping_cart_black_24dp));
        tlBottomBar.addTab(tlBottomBar.newTab().setIcon(R.drawable.ic_attach_money_black_24dp));
        tlBottomBar.addTab(tlBottomBar.newTab().setIcon(R.drawable.ic_person_black_24dp));

        tlBottomBar.getTabAt(0).setText("Rao vặt");
        tlBottomBar.getTabAt(1).setText("Đấu giá");
        tlBottomBar.getTabAt(2).setText("Tôi");
    }


}
