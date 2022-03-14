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

public class LessonFour extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button boiTwoWithoutDeaf;

    private MediaPlayer boiNumberTwoWithoutDeaf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_four);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        boiNumberTwoWithoutDeaf = MediaPlayer.create(this,R.raw.boi_two_without_deaf);

        boiTwoWithoutDeaf = findViewById(R.id.buttonBoiWithoutDeaf);
        boiTwoWithoutDeaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(boiNumberTwoWithoutDeaf);
            }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}
