package com.oms_infotech.www.e_kart;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText edmail,edpass;
    Button loginbtn;
    TextView textView;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<String> emailarray=new ArrayList<>();
    ArrayList<String> passarray=new ArrayList<>();
    int i=0,j=0;
    String mail,chkmail,chkpass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sqLiteDatabase=openOrCreateDatabase("EkartDatabase",MODE_PRIVATE,null);
        sharedPreferences=getSharedPreferences("share",Context.MODE_PRIVATE);
        String a=sharedPreferences.getString("token",String.valueOf(0));
        //Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
        if(a!=String.valueOf(0))
        {

            Intent in=new Intent(MainActivity.this,Main2Activity.class);
            //in.putExtra("UserId",chkmail);
            startActivity(in);
        }

        edmail=(EditText)findViewById(R.id.editText);
        edpass=(EditText)findViewById(R.id.editText2);
        textView=(TextView)findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        loginbtn=(Button) findViewById(R.id.button);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 chkmail = edmail.getText().toString();
                 chkpass = edpass.getText().toString();

                Cursor cursor = sqLiteDatabase.rawQuery("select * from Hell", null);
                cursor.moveToFirst();
                do {
                    mail = cursor.getString(cursor.getColumnIndex("email"));
                    String pass = cursor.getString(cursor.getColumnIndex("password"));
                    emailarray.add(mail);
                    passarray.add(pass);
                }while (cursor.moveToNext());

                for (i = 0; i < emailarray.size(); i++) {
                    if (emailarray.get(i).equals(chkmail) && passarray.get(i).equals(chkpass)) {
                        j = j + 10;
                    }
                }
                if (j == 0) {
                    if (chkmail.length() > 0 && chkpass.length() > 0) {
                        Toast.makeText(MainActivity.this, "Wrong E-mail/Password", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(chkmail.length() == 0) {
                            Toast.makeText(MainActivity.this, "Please enter the E-mail", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    editor=sharedPreferences.edit();
                    editor.putString("token", mail);
                    editor.apply();
                   //Toast.makeText(getApplicationContext(), chkmail ,Toast.LENGTH_LONG).show();
                    Intent in = new Intent(MainActivity.this, Main2Activity.class);
                    in.putExtra("UserId",chkmail);
                    startActivity(in);
                    finish();

                }
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        } else if (id == R.id.nav_Signup) {
            Intent intent=new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
