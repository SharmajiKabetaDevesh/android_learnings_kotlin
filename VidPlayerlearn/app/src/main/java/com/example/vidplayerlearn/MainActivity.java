package com.example.vidplayerlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vid = findViewById(R.id.vid);
        String path = "android.resource://" + getPackageName() + "/raw/videoplayback";
        Uri uri = Uri.parse(path);
        vid.setVideoURI(uri);
        vid.start();

        MediaController mc = new MediaController(this);
        vid.setMediaController(mc);
        mc.setAnchorView(vid);
    }
}
