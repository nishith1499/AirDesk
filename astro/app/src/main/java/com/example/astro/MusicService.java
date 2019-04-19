package com.example.astro;

/*import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.MediaController;

import org.jetbrains.annotations.Nullable;

public class MusicService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player= MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}*/

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

