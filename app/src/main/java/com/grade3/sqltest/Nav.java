package com.grade3.sqltest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Nav extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
         navigationView = (NavigationView) findViewById(R.id.nav_view);


        // 將drawerLayout和toolbar整合，會出現「三」按鈕
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.bringToFront();
        drawerLayout.bringToFront();
        navigationView.setNavigationItemSelectedListener(navigationViewbtn);

    }
    private NavigationView.OnNavigationItemSelectedListener navigationViewbtn=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            drawerLayout.closeDrawer(GravityCompat.START);
            int id = menuItem.getItemId();


            if (id == R.id.nav_home) {

                Intent intent=new Intent();
                intent.setClass(Nav.this, MainActivity.class);
                startActivity(intent);
            }
            else if (id == R.id.nav_gallery) {
                mytoast("iiii");
            }
            return true;
        }
    };
    private void mytoast(String str)
    {
        Toast toast=Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
