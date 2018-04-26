package com.example.abc.khoaluan;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.FragmentDangNhapPagerAdapter;
import constants.Constants;
import fragment.DangKyFragment;

public class DangNhapActivity extends AppCompatActivity implements DangKyFragment.callBackData{

    private ViewPager viewPager;
    private FragmentDangNhapPagerAdapter adapter;
    private TabLayout tabLayout;
    private String name;

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

    @Override
    public void onReturnData(String name) {
        this.onBackPressed();
        this.name = name;
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra(Constants.NAME,name);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}
