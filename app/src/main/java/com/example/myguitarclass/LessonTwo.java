package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.soundStop;

public class LessonTwo extends Activity {

    private Button buttonBack;
    private Button boiOne;
    private Button boiWithChords;
    private Button em;
    private Button d;


    private MediaPlayer Player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_two);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        Player = MediaPlayer.create(this,R.raw.boi_one);


        boiOne = findViewById(R.id.buttonBoiOne);
        boiOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundStop(Player);
                Player = ChangeSound(R.raw.boi_one);

                soundPlay(Player);

            }
        });
        boiWithChords = findViewById(R.id.buttonBoiOneWithChords);
        boiWithChords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundStop(Player);
                Player = ChangeSound(R.raw.boi_one_with_chords);

                soundPlay(Player);

            }
        });
        em = findViewById(R.id.buttonEm);
        em.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundStop(Player);
                Player = ChangeSound(R.raw.chord_em);

                soundPlay(Player);

            }
        });
        d = findViewById(R.id.buttonD);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.chord_d);

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