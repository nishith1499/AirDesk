package com.example.astro;


import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class home extends AppCompatActivity  {
    private Button start, stop,pause,next, previous;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start=(Button)findViewById(R.id.startmusic);
        stop=(Button)findViewById(R.id.stopmusic);
        pause==(Button)findViewById(R.id.pausemusic);
        next=(Button)findViewById(R.id.nextmusic);
        previous=(Button)findViewById(R.id.prevmusic);
        player=MediaPlayer.create(home.this,R.raw.);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setLooping(true);
                player.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player=MediaPlayer.create(home.this,R.raw.);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
            }
        });
    }


}
