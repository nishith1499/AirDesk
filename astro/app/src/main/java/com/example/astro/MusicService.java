package com.example.astro;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class MusicService extends Service {

    private MusicPlayer audioServiceBinder = new MusicPlayer();

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return audioServiceBinder;
    }
}

