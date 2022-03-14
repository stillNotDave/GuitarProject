package com.example.myguitarclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Sound.soundPlay;

public class LessonThree extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button boiTwo;
    private Button hSeven;

    private MediaPlayer boiNumberTwo;
    private MediaPlayer chordHSeven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_three);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        boiNumberTwo = MediaPlayer.create(this,R.raw.boi_two);
        chordHSeven = MediaPlayer.create(this,R.raw.chord_h_seven);

        boiTwo = findViewById(R.id.buttonBoiTwo);
        boiTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(boiNumberTwo);
            }
        });

        hSeven = findViewById(R.id.buttonHSeven);
        hSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(chordHSeven);
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}
