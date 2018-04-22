package com.example.abc.khoaluan;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import adapter.FragmentMainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentMainPagerAdapter adapter;
    private TabLayout tabLayout;
    private boolean doubleBackToSignOutPressedOnce = false;

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
    public void onBackPressed() {
        if (doubleBackToSignOutPressedOnce) {
            this.finishAffinity();
            return;
        }

        this.doubleBackToSignOutPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.exit_app_noti), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToSignOutPressedOnce=false;
            }
        }, 2000);
    }
}
