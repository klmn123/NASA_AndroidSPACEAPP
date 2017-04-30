package com.example.supertramp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private WebView Z_tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Z_tracker = (WebView) findViewById(R.id.spaceapp);
        WebSettings webSettings = Z_tracker.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Z_tracker.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        Z_tracker.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        Z_tracker.getSettings().setAppCacheEnabled(true);
        Z_tracker.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        Z_tracker.loadUrl("https://airbornescience.nasa.gov/tracker/#!/map");
        Z_tracker.setWebViewClient(new WebViewClient());
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nasa_status) {
            Z_tracker.loadUrl("https://airbornescience.nasa.gov/tracker/#!/status/list");



            // Handle the camera action
        } else if (id == R.id.nasa_home) {

            Z_tracker.loadUrl("https://www.nasa.gov/");

        } else if (id == R.id.nasa_asp) {
            Z_tracker.loadUrl("https://airbornescience.nasa.gov/");

        } else if (id == R.id.neatest_your_location) {
            Intent intent2 = new Intent(MainActivity.this,NearestLocation.class);
            startActivity(intent2);

        } else if (id == R.id.aircraft_data) {
            Z_tracker.loadUrl("https://asp-archive.arc.nasa.gov/");

        } else if (id == R.id.status_entery_manual) {

            Intent intent2 = new Intent(MainActivity.this,NewAircraftEntery.class);
            startActivity(intent2);

        }
        else if (id == R.id.about) {

            Intent intent2 = new Intent(MainActivity.this,About.class);
            startActivity(intent2);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (Z_tracker.canGoBack()) {
                        Z_tracker.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
