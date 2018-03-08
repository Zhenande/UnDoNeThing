package com.example.abc.khoaluan;

import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Utils.FragmentDangNhapPagerAdapter;
import Utils.FragmentMainPagerAdapter;

public class DangNhapActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentDangNhapPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        viewPager = (ViewPager)findViewById(R.id.dangNhap_view_pager);

        adapter = new FragmentDangNhapPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);


        tabLayout = findViewById(R.id.dangNhap_tab_menu);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
