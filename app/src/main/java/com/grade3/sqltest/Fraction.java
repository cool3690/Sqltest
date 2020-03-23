package com.grade3.sqltest;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Fraction extends AppCompatActivity {
ImageView pic;
TextView ans;
Switch sw;

    AutoCompleteTextView autext;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    int [] c=new int[10] ;
    private String[] tests= new String[2];
    String[] arr1 = { "mSERVER", "wySQL", "yracle","congoDB","yyyye" };
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fraction);
        /*   */

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // 用toolbar做為APP的ActionBar


        pic=(ImageView)findViewById(R.id.pic);
        ans=(TextView)findViewById(R.id.ans);
        sw=(Switch)findViewById(R.id.sw);
        autext=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        pic.setOnClickListener(btn);
        for(int i=0;i<10;i++){c[i]=0;}
        Random random=new Random();
        int r=random.nextInt(9)+2;
        GlobalVariable gv = (GlobalVariable)getApplicationContext();
         tests = gv.getPart(); //取得陣列
        ans.setText(tests[1]);
        sw.setOnCheckedChangeListener(swbtn);
        ArrayAdapter adapter = new ArrayAdapter
                (this,android.R.layout.select_dialog_item, arr1);

        autext.setThreshold(1);
       autext.setAdapter(adapter);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(navigationViewbtn);


    }
    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private NavigationView.OnNavigationItemSelectedListener navigationViewbtn=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            drawerLayout.closeDrawer(GravityCompat.START);
            int id = menuItem.getItemId();


            if (id == R.id.nav_home) {

                Intent intent=new Intent();
                intent.setClass(Fraction.this, MainActivity.class);
                startActivity(intent);
            }
            else if (id == R.id.nav_gallery) {

                //return true;
            }
            return true;
        }
    };

  /*    */
    private ImageView.OnClickListener btn=new ImageView.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.pic:
                //    int imageid = getResources().getIdentifier("c1", "drawable", getPackageName());
                 //   String imageName = getResources().getResourceName(imageid);
                    if(c[0]==0)
                        check0(0);
                    else
                        check1(0);
                    break;
            }
        }
    };
    private Switch.OnCheckedChangeListener swbtn=new Switch.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton.isChecked()) {
                mytoast("ON");
            } else {
                mytoast("OFF");
            }
        }
    };
    private void check0(int x)
    {
        c[x]=1;
        pic.setImageResource(R.drawable.c2);
    }
    private void check1(int x)
    {
        c[x]=0;
        pic.setImageResource(R.drawable.c1);
    }
    private void mytoast(String str)
    {
        Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
