package com.bn116.sig.outsider_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    static boolean isOfficer = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyInfoFragment()).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReportFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.report_menu);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CallVisitFragment()).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OutsiderManagementFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId())
            {
                case R.id.my_info_menu:
                    selectedFragment = new MyInfoFragment();
                    break;
                case R.id.report_menu:
                    selectedFragment = new ReportFragment();
//                    Toast.makeText(getApplicationContext(), "보고", Toast.LENGTH_SHORT);
                    break;
                case R.id.call_visit_menu:
                    selectedFragment = new CallVisitFragment();
                    break;
                case R.id.outsider_management_menu:
                    selectedFragment = new OutsiderManagementFragment();
                    break;
            }

            if( selectedFragment != null )
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };
}
