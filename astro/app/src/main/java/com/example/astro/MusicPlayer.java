package com.example.astro;

/*import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MusicPlayer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MusicPlayer() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MusicPlayer newInstance(String param1, String param2) {
        MusicPlayer fragment = new MusicPlayer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_player, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}*/
        import android.content.Context;
        import android.media.AudioManager;
        import android.media.MediaPlayer;
        import android.net.Uri;
        import android.os.Binder;
        import android.os.Handler;
        import android.os.Message;
        import android.text.TextUtils;

        import java.io.IOException;



public class MusicPlayer extends Binder {

    // Save local audio file uri ( local storage file. ).
    private Uri audioFileUri = null;

    // Save web audio file url.
    private String audioFileUrl = "";

    // Check if stream audio.
    private boolean streamAudio = false;

    // Media player that play audio.
    private MediaPlayer audioPlayer = null;

    // Caller activity context, used when play local audio file.
    private Context context = null;

    // This Handler object is a reference to the caller activity's Handler.
    // In the caller activity's handler, it will update the audio play progress.
    private Handler audioProgressUpdateHandler;

    // This is the message signal that inform audio progress updater to update audio progress.
    final int UPDATE_AUDIO_PROGRESS_BAR = 1;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private String getAudioFileUrl() {
        return audioFileUrl;
    }

    void setAudioFileUrl() {
        this.audioFileUrl = "http://www.dev2qa.com/demo/media/test.mp3";
    }

    private boolean isStreamAudio() {
        return streamAudio;
    }

    void setStreamAudio() {
        this.streamAudio = true;
    }

    private Uri getAudioFileUri() {
        return audioFileUri;
    }

    public void setAudioFileUri(Uri audioFileUri) {
        this.audioFileUri = audioFileUri;
    }

    public Handler getAudioProgressUpdateHandler() {
        return audioProgressUpdateHandler;
    }

    void setAudioProgressUpdateHandler(Handler audioProgressUpdateHandler) {
        this.audioProgressUpdateHandler = audioProgressUpdateHandler;
    }

    // Start play audio.
    void startAudio()
    {
        initAudioPlayer();
        if(audioPlayer!=null) {
            audioPlayer.start();
        }
    }

    // Pause playing audio.
    void pauseAudio()
    {
        if(audioPlayer!=null) {
            audioPlayer.pause();
        }
    }

    // Stop play audio.
    void stopAudio()
    {
        if(audioPlayer!=null) {
            audioPlayer.stop();
            destroyAudioPlayer();
        }
    }

    // Initialise audio player.
    private void initAudioPlayer()
    {
        try {
            if (audioPlayer == null) {
                audioPlayer = new MediaPlayer();

                if (!TextUtils.isEmpty(getAudioFileUrl())) {
                    if (isStreamAudio()) {
                        audioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    }
                    audioPlayer.setDataSource(getAudioFileUrl());
                } else {
                    audioPlayer.setDataSource(getContext(), getAudioFileUri());
                }

                audioPlayer.prepare();

                // This thread object will send update audio progress message to caller activity every 1 second.
                Thread updateAudioProgressThread = new Thread()
                {
                    @Override
                    public void run() {
                        while(true)
                        {
                            // Create update audio progress message.
                            Message updateAudioProgressMsg = new Message();
                            updateAudioProgressMsg.what = UPDATE_AUDIO_PROGRESS_BAR;

                            // Send the message to caller activity's update audio prgressbar Handler object.
                            audioProgressUpdateHandler.sendMessage(updateAudioProgressMsg);

                            // Sleep one second.
                            try {
                                Thread.sleep(1000);
                            }catch(InterruptedException ex)
                            {
                                ex.printStackTrace();
                            }
                        }
                    }
                };
                // Run above thread object.
                updateAudioProgressThread.start();
            }
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // Destroy audio player.
    private void destroyAudioPlayer()
    {
        if(audioPlayer!=null)
        {
            if(audioPlayer.isPlaying())
            {
                audioPlayer.stop();
            }

            audioPlayer.release();

            audioPlayer = null;
        }
    }

    // Return current audio play position.
    private int getCurrentAudioPosition()
    {
        int ret = 0;
        if(audioPlayer != null)
        {
            ret = audioPlayer.getCurrentPosition();
        }
        return ret;
    }

    // Return total audio file duration.
    private int getTotalAudioDuration()
    {
        int ret = 0;
        if(audioPlayer != null)
        {
            ret = audioPlayer.getDuration();
        }
        return ret;
    }

    // Return current audio player progress value.
    int getAudioProgress()
    {
        int ret = 0;
        int currAudioPosition = getCurrentAudioPosition();
        int totalAudioDuration = getTotalAudioDuration();
        if(totalAudioDuration > 0) {
            ret = (currAudioPosition * 100) / totalAudioDuration;
        }
        return ret;
    }
}
