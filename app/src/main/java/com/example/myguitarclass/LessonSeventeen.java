package com.example.myguitarclass;

import static com.example.myguitarclass.Sound.soundPlay;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonSeventeen extends Activity {

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
                openActivity(LessonList.class);
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
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}

