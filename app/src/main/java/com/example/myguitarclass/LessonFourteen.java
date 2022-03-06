package com.example.myguitarclass;

import static com.example.myguitarclass.Sound.soundPlay;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonFourteen extends Activity {

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
                openActivity(LessonList.class);
            }
        });

        ChordsAAndFmDiez = MediaPlayer.create(this, R.raw.chords_for_lesson_fourteen);
        buttonChordsAAndFmDiez = findViewById(R.id.buttonLessonFourteen);
        buttonChordsAAndFmDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(ChordsAAndFmDiez);
            }
        });

    }
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}

