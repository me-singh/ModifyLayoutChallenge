package com.example.kadyan.personalmanagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.kadyan.personalmanagerdemo.Activities.ListsActivity;
import com.example.kadyan.personalmanagerdemo.Fragments.MessagesFragment;
import com.example.kadyan.personalmanagerdemo.Fragments.NotificationFragment;
import com.example.kadyan.personalmanagerdemo.Fragments.SearchFragment;
import com.example.kadyan.personalmanagerdemo.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomeFragment.newInstance()).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        TextView profileTextView=findViewById(R.id.nav_profile);
        TextView listsTextView=findViewById(R.id.nav_lists);
        profileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        listsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListsActivity.class));
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ViewPager viewPager=findViewById(R.id.mainViewpager);
        tabLayout = findViewById(R.id.mainTabLayout);

        MyViewPagerAdapter myViewPagerAdapter =new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_notifications_none_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_mail_outline_black_24dp);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:{
                    return HomeFragment.newInstance();
                }
                case 1:{
                    return SearchFragment.newInstance();
                }
                case 2:{
                    return NotificationFragment.newInstance();
                }
                case 3:{
                    return MessagesFragment.newInstance();
                }
            }
            return HomeFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
