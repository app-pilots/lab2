package com.grup2.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    Button btnVideo,btnCalendario,btnMapa,btnGraficoLineal,btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVideo=(Button)findViewById(R.id.btnVideo);
        btnCalendario=(Button)findViewById(R.id.btnCalendario);
        btnGraficoLineal=(Button)findViewById(R.id.btnGraficoLineal);
        btnMenu=(Button)findViewById(R.id.btnMenu);
        btnMapa=(Button)findViewById(R.id.btnMapa);



        //primer commmite Roberto Valarezo
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