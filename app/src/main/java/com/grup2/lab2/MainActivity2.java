package com.grup2.lab2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MainActivity2 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void abrirVideo(View v){
        Intent video= new Intent(this,VideoViewActivity.class);
        startActivity(video);


    }
    public void abrirCalendario(View v){
        Intent calendario= new Intent(this,CalendarActivity.class);
        startActivity(calendario);

    }

    public void abrirMapa(View v){

    }

    public void abrirGrafico(View v){

    }

    public void abrirMenu(View v){
        Intent menu= new Intent(this,MainActivity2.class);
        startActivity(menu);

    }
}