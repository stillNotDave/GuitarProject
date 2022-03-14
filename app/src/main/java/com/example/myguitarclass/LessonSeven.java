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

public class LessonSeven extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button buttonEmPerebor;
    private Button buttonCPerebor;
    private Button buttonGPerebor;
    private Button buttonDPerebor;
    private Button buttonBoi;

    private MediaPlayer EmPerebor;
    private MediaPlayer CPerebor;
    private MediaPlayer GPerebor;
    private MediaPlayer DPerebor;
    private MediaPlayer newBoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_seven);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        EmPerebor = MediaPlayer.create(this,R.raw.em_perebor_feat_boi);
        buttonEmPerebor = findViewById(R.id.buttonEmPerebor);
        buttonEmPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(EmPerebor);
            }
        });

        CPerebor = MediaPlayer.create(this,R.raw.c_perebor_feat_boi);
        buttonCPerebor = findViewById(R.id.buttonCPerebor);
        buttonCPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(CPerebor);
            }
        });

        GPerebor = MediaPlayer.create(this,R.raw.g_perebor_feat_boi);
        buttonGPerebor = findViewById(R.id.buttonGPerebor);
        buttonGPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(GPerebor);
            }
        });

        DPerebor = MediaPlayer.create(this,R.raw.d_perebor_feat_boi);
        buttonDPerebor = findViewById(R.id.buttonDPerebor);
        buttonDPerebor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(DPerebor);
            }
        });

        newBoi = MediaPlayer.create(this,R.raw.boi_for_lesson_seven);
        buttonBoi = findViewById(R.id.buttonNewBoi);
        buttonBoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(newBoi);
            }
        });




    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}
