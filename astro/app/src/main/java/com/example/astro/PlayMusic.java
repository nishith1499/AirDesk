package com.example.astro;

/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }
}*/
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.dev2qa.example.R;

public class PlayMusic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private MusicPlayer audioServiceBinder = null;

    private Handler audioProgressUpdateHandler = null;

    // Show played audio progress.
    private ProgressBar backgroundAudioProgress;

    private TextView audioFileUrlTextView;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    // This service connection object is the bridge between activity and background service.
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // Cast and assign background service's onBind method returned iBander object.
            audioServiceBinder = (MusicPlayer) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        setTitle("dev2qa.com - Play Audio Use Background Service");

        // Bind background audio service when activity is created.
        bindAudioService();

        final String audioFileUrl = "http://www.dev2qa.com/demo/media/test.mp3";

        backgroundAudioProgress = (ProgressBar)findViewById(R.id.play_audio_in_background_service_progressbar);

        // Get audio file url textview.
        audioFileUrlTextView = (TextView)findViewById(R.id.audio_file_url_text_view);
        if(audioFileUrlTextView != null)
        {
            // Show web audio file url in the text view.
            audioFileUrlTextView.setText("Audio File Url. \n" + audioFileUrl);
        }

        // Click this button to start play audio in a background service.
        Button startBackgroundAudio = (Button)findViewById(R.id.start_audio_in_background);
        startBackgroundAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set web audio file url
                audioServiceBinder.setAudioFileUrl(audioFileUrl);

                // Web audio is a stream audio.
                audioServiceBinder.setStreamAudio(true);

                // Set application context.
                audioServiceBinder.setContext(getApplicationContext());

                // Initialize audio progress bar updater Handler object.
                createAudioProgressbarUpdater();
                audioServiceBinder.setAudioProgressUpdateHandler(audioProgressUpdateHandler);

                // Start audio in background service.
                audioServiceBinder.startAudio();

                backgroundAudioProgress.setVisibility(ProgressBar.VISIBLE);

                Toast.makeText(getApplicationContext(), "Start play web audio file.", Toast.LENGTH_LONG).show();
            }
        });

        // Click this button to pause the audio played in background service.
        Button pauseBackgroundAudio = (Button)findViewById(R.id.pause_audio_in_background);
        pauseBackgroundAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioServiceBinder.pauseAudio();
                Toast.makeText(getApplicationContext(), "Play web audio file is paused.", Toast.LENGTH_LONG).show();
            }
        });

        // Click this button to stop the media player in background service.
        Button stopBackgroundAudio = (Button)findViewById(R.id.stop_audio_in_background);
        stopBackgroundAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioServiceBinder.stopAudio();
                backgroundAudioProgress.setVisibility(ProgressBar.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Stop play web audio file.", Toast.LENGTH_LONG).show();
            }
        });
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_music);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Bind background service with caller activity. Then this activity can use
    // background service's AudioServiceBinder instance to invoke related methods.
    private void bindAudioService()
    {
        if(audioServiceBinder == null) {
            Intent intent = new Intent(PlayMusic.this, MusicService.class);

            // Below code will invoke serviceConnection's onServiceConnected method.
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        }
    }

    // Unbound background audio service with caller activity.
    private void unBoundAudioService()
    {
        if(audioServiceBinder != null) {
            unbindService(serviceConnection);
        }
    }

    @Override
    protected void onDestroy() {
        // Unbound background audio service when activity is destroyed.
        unBoundAudioService();
        super.onDestroy();
    }

    // Create audio player progressbar updater.
    // This updater is used to update progressbar to reflect audio play process.
    private void createAudioProgressbarUpdater()
    {
        /* Initialize audio progress handler. */
        if(audioProgressUpdateHandler==null) {
            audioProgressUpdateHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // The update process message is sent from AudioServiceBinder class's thread object.
                    if (msg.what == audioServiceBinder.UPDATE_AUDIO_PROGRESS_BAR) {

                        if( audioServiceBinder != null) {
                            // Calculate the percentage.
                            int currProgress =audioServiceBinder.getAudioProgress();

                            // Update progressbar. Make the value 10 times to show more clear UI change.
                            backgroundAudioProgress.setProgress(currProgress*10);
                        }
                    }
                }
            };
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        switch(id)
        {
            case R.id.nav_home:
                Intent home=new Intent(this,home.class);
                startActivity(home);
                break;
            case R.id.nav_library:
                Intent lib=new Intent(this,library.class);
                startActivity(lib);
                break;
            case R.id.nav_playmusic:

                break;
            case R.id.nav_aboutus:
                Intent abt=new Intent(this,aboutus.class);
                startActivity(abt);
                break;
            case R.id.nav_todo:
                Intent to=new Intent(this,todo.class);
                startActivity(to);
                break;
            case R.id.nav_pdfopener:
                Intent pdf=new Intent(this,pdfopener.class);
                startActivity(pdf);
                break;
            case R.id.nav_randomfacts:
                Intent random=new Intent(this,randomfacts.class);
                startActivity(random);
                break;
            case R.id.nav_logout:
                Intent log=new Intent(this,login.class);
                SharedPreferences pref=getSharedPreferences("user_details",MODE_PRIVATE);
                SharedPreferences.Editor e=pref.edit();
                e.clear();

                e.apply();
                startActivity(log);
                break;
            default:break;
        }
        return false;
    }
}
