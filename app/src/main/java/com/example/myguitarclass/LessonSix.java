package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.soundStop;

public class LessonSix extends Activity {

    private Button buttonBack;
    private Button pereborAm;
    private Button pripev;

    private MediaPlayer Player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_six);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        Player = MediaPlayer.create(this,R.raw.am_perebor_for_lesson_six);
        pereborAm = findViewById(R.id.buttonAmPerebor);
        pereborAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.am_perebor_for_lesson_six);

                soundPlay(Player);
            }
        });

        pripev = findViewById(R.id.buttonPripevPerebor);
        pripev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.pripev_nautilus_for_lesson_six);

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
