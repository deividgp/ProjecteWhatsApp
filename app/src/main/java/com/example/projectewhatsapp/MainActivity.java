package com.example.projectewhatsapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    VideoView vv;
    MediaController mediaControl;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv= findViewById(R.id.videoView);

        if (mediaControl == null){
            mediaControl = new MediaController(this);
            vv.setMediaController(mediaControl);
        }

        try {

            String videoPath = "android.resource://" + getPackageName()+ "/"+R.raw.documental;
            Uri uri = Uri.parse(videoPath);
            vv.setVideoURI(uri);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vv.seekTo(position);

                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        mediaControl.setAnchorView(vv);
                    }
                });
            }
        });

        Intent intent = new Intent (this, Xat.class);
        PendingIntent pend = PendingIntent.getActivity(this, 0, intent, 0);

        final Notification noti = new Notification.Builder(getApplicationContext())
                .setContentTitle("Nou missatge")
                .setContentText("Eduard Toda nou missatge de Whatsapp")
                .setContentIntent(pend)
                .setFullScreenIntent(pend, true)
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .addAction(android.R.drawable.stat_notify_chat,"",pend)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL)
                .build();

        final NotificationManager notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                notiManager.notify(1,noti);
            }
        }, 2000);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("CurrentPosition", vv.getCurrentPosition());
        vv.pause();
    }

}
