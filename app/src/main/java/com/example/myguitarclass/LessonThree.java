package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.soundStop;

public class LessonThree extends Activity {

    private Button buttonBack;
    private Button boiTwo;
    private Button hSeven;

    private MediaPlayer Player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_three);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

        Player = MediaPlayer.create(this,R.raw.boi_two);
        

        boiTwo = findViewById(R.id.buttonBoiTwo);
        boiTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.boi_two);

                soundPlay(Player);
            }
        });

        hSeven = findViewById(R.id.buttonHSeven);
        hSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop(Player);
                Player = ChangeSound(R.raw.chord_h_seven);

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
