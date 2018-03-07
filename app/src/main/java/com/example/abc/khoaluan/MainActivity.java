package com.example.abc.khoaluan;

import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Utils.FragmentMainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentMainPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        viewPager = (ViewPager)findViewById(R.id.main_view_pager);

        adapter = new FragmentMainPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);


        tabLayout = findViewById(R.id.main_tab_menu);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
