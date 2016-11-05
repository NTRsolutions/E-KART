package com.oms_infotech.www.e_kart;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView usernametv,emailtv;
    SQLiteDatabase sqLiteDatabase;
    String fname,lname;
    SharedPreferences sharedPreferences;
    ViewPager viewPager;
    TabLayout tabLayout;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sqLiteDatabase=openOrCreateDatabase("EkartDatabase",MODE_PRIVATE,null);
        String email = getIntent().getExtras().getString("UserId");
        sharedPreferences =getSharedPreferences("share", Context.MODE_PRIVATE);
        String a=sharedPreferences.getString("token",String.valueOf(0));


        Cursor cursor = sqLiteDatabase.rawQuery("select * from Hell where email='" + a + "'", null);
       //Cursor c = sqLiteDatabase.rawQuery("select email from Hello where email='" + email + "'", null);


        viewPager=(ViewPager)findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);
        //View view= navigationView.inflateHeaderView(R.layout.nav_header_main);
        usernametv = (TextView) view.findViewById(R.id.usernametv);
        emailtv=(TextView)view.findViewById(R.id.emailtv);
        cursor.moveToFirst();
        do {
             fname = cursor.getString(cursor.getColumnIndex("fname"));
             lname = cursor.getString(cursor.getColumnIndex("lname"));
             email=cursor.getString(cursor.getColumnIndex("email"));
        }while(cursor.moveToNext());

        usernametv.setText(fname+" "+lname);
        emailtv.setText(email);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        final Button electronics,Lifestyle,HomeAppliances,Accessories;
        electronics=(Button)findViewById(R.id.nav_electronics);
       if(id==R.id.nav_electronics) {
           viewPager.setCurrentItem(0);

       }else if (id == R.id.nav_lifestyle) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nav_appliances) {
           viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_accessories) {
           viewPager.setCurrentItem(3);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }else if (id == R.id.nav_logout) {
           sharedPreferences =getSharedPreferences("share", Context.MODE_PRIVATE);
           editor=sharedPreferences.edit();
           editor.remove("token");
           editor.apply();
           //Intent intent=new Intent(Main2Activity.this,MainActivity.class);
          // startActivity(intent);
           finish();
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ElectronicsTab() ,"Electronics");
        viewPagerAdapter.addFragment(new Lifestyle(),"Lifestyle");
        viewPagerAdapter.addFragment(new Home_Appliances(),"Home Appliances");
        viewPagerAdapter.addFragment((new Accessories()),"Accessories");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
