package com.grup2.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.MediaController;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class  VideoViewActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bienvenidos));

        MediaController mediaController= new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
        //nue


    }

    public void volver(View v){
        Intent volver= new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}