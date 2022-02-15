package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.myguitarclass.Sound.soundPlay;

public class LessonZero extends Activity {
    private Button buttonBack;
    private Button stringFirstE;
    private Button stringB;
    private Button stringG;
    private Button stringD;
    private Button stringA;
    private Button stringE;

    private MediaPlayer stringOne;
    private MediaPlayer stringTwo;
    private MediaPlayer stringThree;
    private MediaPlayer stringFour;
    private MediaPlayer stringFive;
    private MediaPlayer stringSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_zero);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        stringOne = MediaPlayer.create(this, R.raw.string1_0);
        stringTwo = MediaPlayer.create(this,R.raw.string2_0);
        stringThree = MediaPlayer.create(this,R.raw.string3_0);
        stringFour = MediaPlayer.create(this,R.raw.string4_0);
        stringFive = MediaPlayer.create(this,R.raw.string5_0);
        stringSix = MediaPlayer.create(this,R.raw.string2_0);

        stringFirstE = findViewById(R.id.stringe);
        stringFirstE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringOne);
            }
        });
        stringB = findViewById(R.id.stringB);
        stringB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringTwo);
            }
        });
        stringG = findViewById(R.id.stringG);
        stringG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringThree);
            }
        });
        stringD = findViewById(R.id.stringD);
        stringD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringFour);
            }
        });
        stringA = findViewById(R.id.stringA);
        stringA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringFive);
            }
        });
        stringE = findViewById(R.id.stringE);
        stringE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringSix);
            }
        });


    }

    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}