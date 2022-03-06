package com.example.myguitarclass;

import static com.example.myguitarclass.Sound.soundPlay;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonEighteen extends Activity {

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
                openActivity(LessonList.class);
            }
        });

        OpenningZvezda = MediaPlayer.create(this, R.raw.opening_zvezda);
        buttonOpenningZvezda = findViewById(R.id.buttonPodelennyBoi);
        buttonOpenningZvezda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(OpenningZvezda);
            }
        });

    }
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}

