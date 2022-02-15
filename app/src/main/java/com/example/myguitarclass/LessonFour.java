package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.myguitarclass.Sound.soundPlay;

public class LessonFour extends Activity {

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
                openActivity(LessonList.class);
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
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}
