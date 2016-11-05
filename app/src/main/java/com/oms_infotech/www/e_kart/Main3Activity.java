package com.oms_infotech.www.e_kart;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button signupbtn;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sqLiteDatabase=openOrCreateDatabase("EkartDatabase",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("create table if not exists Hell(fname varchar,lname varchar,email varchar,mobile varchar,password varchar)");
        ed1=(EditText)findViewById(R.id.editText3);
        ed2=(EditText)findViewById(R.id.editText4);
        ed3=(EditText)findViewById(R.id.editText5);
        ed4=(EditText)findViewById(R.id.editText6);
        ed5=(EditText)findViewById(R.id.editText7);
        ed6=(EditText)findViewById(R.id.editText8);
        signupbtn=(Button)findViewById(R.id.button2);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed1.length() == 0) {
                    Toast.makeText(Main3Activity.this, "Please enter the First name", Toast.LENGTH_SHORT).show();
                } else if (ed2.length() == 0) {
                    Toast.makeText(Main3Activity.this, "Please enter the Last name", Toast.LENGTH_SHORT).show();
                } else if (ed3.length() == 0) {
                    Toast.makeText(Main3Activity.this, "Please enter the E-mail", Toast.LENGTH_SHORT).show();
                } else if (ed4.length() == 0) {
                    Toast.makeText(Main3Activity.this, "Please enter the Mobile no.", Toast.LENGTH_SHORT).show();
                } else if (ed5.length() == 0) {
                    Toast.makeText(Main3Activity.this, "Please enter the Password", Toast.LENGTH_SHORT).show();
                } else if (!ed6.getText().toString().equals(ed5.getText().toString())) {
                    Toast.makeText(Main3Activity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                }
                String fname=ed1.getText().toString();
                String lname=ed2.getText().toString();
                String email=ed3.getText().toString();
                String mobileno=ed4.getText().toString();
                String password=ed5.getText().toString();

                sqLiteDatabase.execSQL("insert into Hell values('"+fname+"','"+lname+"','"+email+"','"+mobileno+"','"+password+"')");
                Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT);
                Intent in = new Intent(Main3Activity.this, Main2Activity.class);
                in.putExtra("UserId",email);
                startActivity(in);
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main3, menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_Login) {
            Intent intent=new Intent(Main3Activity.this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Signup) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
