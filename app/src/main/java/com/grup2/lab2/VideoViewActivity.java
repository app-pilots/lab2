package com.grup2.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.VideoView;

public class  VideoViewActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bienvenidos));
        videoView.start();
        //nue


    }
}