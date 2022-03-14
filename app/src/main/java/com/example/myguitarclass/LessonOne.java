package com.example.myguitarclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Sound.soundPlay;

public class LessonOne extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button boiOne;
    private Button am;
    private Button c;
    private Button dm;
    private Button g;

    private MediaPlayer boiNumberOne;
    private MediaPlayer chordAm;
    private MediaPlayer chordC;
    private MediaPlayer chordDm;
    private MediaPlayer chordG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_one);

        //ImageView amFingering = findViewById(R.id.amFingering);
        //amFingering.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.am_fingering));

        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });


        boiNumberOne = MediaPlayer.create(this,R.raw.boi_one);
        chordAm = MediaPlayer.create(this,R.raw.chord_am);
        chordC = MediaPlayer.create(this,R.raw.chord_c);
        chordDm = MediaPlayer.create(this,R.raw.chord_dm);
        chordG = MediaPlayer.create(this,R.raw.chord_g);

        boiOne = findViewById(R.id.buttonBoiOneWithChords);
        boiOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(boiNumberOne);
            }
        });

        am = findViewById(R.id.buttonAm);
        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(chordAm);
            }
        });
        c = findViewById(R.id.buttonC);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(chordC);
            }
        });
        dm = findViewById(R.id.buttonDm);
        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(chordDm);
            }
        });
        g = findViewById(R.id.buttonG);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(chordG);
            }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}