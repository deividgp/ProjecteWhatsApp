package com.example.projectewhatsapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    MediaController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv= findViewById(R.id.videoView);
        control = new MediaController(this);
        String videoPath = "android.resource://" + getPackageName()+ "/"+R.raw.exemple;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);

        MediaController mediaControl = new MediaController(this);
        vv.setMediaController(mediaControl);
        mediaControl.setAnchorView(vv);

        //vv.start();
    }


}
