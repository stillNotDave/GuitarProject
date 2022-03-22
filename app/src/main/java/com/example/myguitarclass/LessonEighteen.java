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

public class LessonEighteen extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button buttonOpenningZvezda;

    private MediaPlayer OpenningZvezda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_eighteen);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        OpenningZvezda = MediaPlayer.create(this,R.raw.opening_zvezda);
        buttonOpenningZvezda = findViewById(R.id.buttonPodelennyBoi);
        buttonOpenningZvezda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(OpenningZvezda);
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}

