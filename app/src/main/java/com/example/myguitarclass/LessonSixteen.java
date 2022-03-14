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

public class LessonSixteen extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button buttonRhythmRaggy;
    private Button buttonVzbivka;

    private  MediaPlayer RhythmRaggy;
    private MediaPlayer Vzbivka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_sixteen);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        RhythmRaggy = MediaPlayer.create(this,R.raw.rhythm_raggy);
        buttonRhythmRaggy = findViewById(R.id.buttonRitmGaggy);
        buttonRhythmRaggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(RhythmRaggy);
            }
        });

        Vzbivka = MediaPlayer.create(this,R.raw.vzbivka);
        buttonVzbivka = findViewById(R.id.buttonVzbivka);
        buttonVzbivka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(Vzbivka);
            }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}

