package com.example.supertramp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewLanded extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_landed);


        Button AARPTheMagazine = (Button)findViewById(R.id.new_entery_takeoff);
        AARPTheMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(NewLanded.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}
