package com.example.myguitarclass;

import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.soundStop;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonSixteen extends Activity {

    private Button buttonBack;
    private Button buttonRhythmRaggy;
    private Button buttonVzbivka;

    private  MediaPlayer Player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_sixteen);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        Player = MediaPlayer.create(this, R.raw.rhythm_raggy);
        buttonRhythmRaggy = findViewById(R.id.buttonRitmGaggy);
        buttonRhythmRaggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.rhythm_raggy);

                soundPlay(Player);
            }
        });


        buttonVzbivka = findViewById(R.id.buttonVzbivka);
        buttonVzbivka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.vzbivka);

                soundPlay(Player);
            }
        });


    }
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
    public MediaPlayer ChangeSound(int sound){
        MediaPlayer mp = MediaPlayer.create(this,sound);
        return mp;
    }
}

