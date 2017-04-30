package com.example.supertramp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class NewAircraftEntery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_aircraft_entery);


        TabHost tabHost = (TabHost) findViewById(R.id.tab_entry);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.takeoff);
        tabSpec.setIndicator("Take Off Entry");
        tabHost.addTab(tabSpec);
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("creator");
        tabSpec1.setContent(R.id.landing);
        tabSpec1.setIndicator("Landed Entry");
        tabHost.addTab(tabSpec1);

        Button NewTakeOff = (Button)findViewById(R.id.b_new_entery_takeoff);
        NewTakeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(NewAircraftEntery.this,Loaded.class);
                startActivity(intent2);
            }
        });
        Button Landed = (Button)findViewById(R.id.b_entery_landed);
        Landed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(NewAircraftEntery.this,Loaded.class);
                startActivity(intent2);
            }
        });
    }
}
