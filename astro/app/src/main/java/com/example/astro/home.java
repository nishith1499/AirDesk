package com.example.astro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity implements View.OnClickListener {
    private Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        start=(Button)findViewById(R.id.startmusic);
        stop=(Button)findViewById(R.id.stopmusic);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==start){
            startService(new Intent(this,MusicService.class));
        }
        else if(v==stop){
            stopService(new Intent(this,MusicService.class));
        }
    }
}
