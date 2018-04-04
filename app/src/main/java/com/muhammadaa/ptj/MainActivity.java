package com.muhammadaa.ptj;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.muhammadaa.ptj.views.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationViewEx navigation;

    android.support.v4.app.FragmentTransaction ft;
    Fragment currentFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new HomeFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container_main, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_order:
                    return true;
                case R.id.navigation_article:
                    return true;
                case R.id.navigation_akun:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new HomeFragment();
        ft.replace(R.id.container_main, currentFragment);
        ft.commit();

        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
