package com.example.haihm.shelf;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    TabLayout tlLogin;
    ViewPager vpLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
    }

    private void setupUI() {
        tlLogin = findViewById(R.id.tl_login);
        vpLogin = findViewById(R.id.vp_login);

        setupTabLayout();
        LoginPagerAdapter loginPagerAdapter = new LoginPagerAdapter(getSupportFragmentManager());
        vpLogin.setAdapter(loginPagerAdapter);
        vpLogin.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlLogin));
    }

    private void setupTabLayout() {
        tlLogin.addTab(tlLogin.newTab().setText("Đăng nhập"));
        tlLogin.addTab(tlLogin.newTab().setText("Đăng ký"));
        tlLogin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpLogin.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
