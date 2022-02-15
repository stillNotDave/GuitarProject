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

public class LessonSeven extends Activity {

    private Button buttonBack;
    private Button buttonEmPerebor;
    private Button buttonCPerebor;
    private Button buttonGPerebor;
    private Button buttonDPerebor;
    private Button buttonBoi;

    private MediaPlayer Player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_seven);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        Player = MediaPlayer.create(this,R.raw.em_perebor_feat_boi);
        buttonEmPerebor = findViewById(R.id.buttonEmPerebor);
        buttonEmPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.em_perebor_feat_boi);

                soundPlay(Player);
            }
        });

        buttonCPerebor = findViewById(R.id.buttonCPerebor);
        buttonCPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.c_perebor_feat_boi);

                soundPlay(Player);
            }
        });

        buttonGPerebor = findViewById(R.id.buttonGPerebor);
        buttonGPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.g_perebor_feat_boi);

                soundPlay(Player);
            }
        });

        buttonDPerebor = findViewById(R.id.buttonDPerebor);
        buttonDPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.d_perebor_feat_boi);

                soundPlay(Player);
            }
        });

        buttonBoi = findViewById(R.id.buttonNewBoi);
        buttonBoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.boi_for_lesson_seven);

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
