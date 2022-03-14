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

public class LessonFourteen extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button buttonChordsAAndFmDiez;

    private MediaPlayer ChordsAAndFmDiez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_fourteen);



        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        ChordsAAndFmDiez = MediaPlayer.create(this,R.raw.chords_for_lesson_fourteen);
        buttonChordsAAndFmDiez = findViewById(R.id.buttonLessonFourteen);
        buttonChordsAAndFmDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(ChordsAAndFmDiez);
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}

