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

public class LessonOne extends Activity {
    private Button buttonBack;
    private Button boiOne;
    private Button am;
    private Button c;
    private Button dm;
    private Button g;

    private MediaPlayer Player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_one);


        ImageView amFingering = findViewById(R.id.amFingering);
        amFingering.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.am_fingering));

        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });


        Player = MediaPlayer.create(this,R.raw.boi_one);



        boiOne = findViewById(R.id.buttonBoiOneWithChords);
        boiOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.boi_one);
                //
                soundPlay(Player);
            }
        });

        am = findViewById(R.id.buttonAm);
        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               soundStop(Player);

                Player = ChangeSound(R.raw.chord_am);
                soundPlay(Player);
            }
        });
        c = findViewById(R.id.buttonC);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.chord_c);

                soundPlay(Player);
            }
        });
        dm = findViewById(R.id.buttonDm);
        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.chord_dm);

                soundPlay(Player);
            }
        });
        g = findViewById(R.id.buttonG);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.chord_g);

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