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

public class LessonSeventeen extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button buttonESeven;

    private MediaPlayer ESeven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_seventeen);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        ESeven = MediaPlayer.create(this, R.raw.e_seven_perebor);
        buttonESeven = findViewById(R.id.buttonPereborNaESeven);
        buttonESeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(ESeven);
            }
        });




    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}

