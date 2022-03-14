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

public class LessonFive extends Activity {
    Context context = this;
    private Button buttonBack;
    private Button boiNa34;

    private MediaPlayer boi34;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_five);

        ImageView imageView = findViewById(R.id.boiWithVocal);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.boi_na_three_four_with_vocal));


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });

        boi34 = MediaPlayer.create(this,R.raw.boi_3_4);
        boiNa34 = findViewById(R.id.buttonBoi3Na4);
        boiNa34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(boi34);
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}
