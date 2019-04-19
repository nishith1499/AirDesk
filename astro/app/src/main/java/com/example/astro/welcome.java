package com.example.astro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class welcome extends AppCompatActivity {
    Timer timer;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        SharedPreferences pref =getSharedPreferences(user_details,MODE_PRIVATE);
        String name=pref.getString("name");
        text.setText("Welcome "+name);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(welcome.this, home.class);
                startActivity(i);
                finish();
            }
        }, 5000);

    }
}
