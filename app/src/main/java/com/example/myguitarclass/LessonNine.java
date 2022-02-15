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

public class LessonNine extends Activity {

    private Button buttonBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_nine);


        ImageView chordHm = findViewById(R.id.chordHm);
        chordHm.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.hm_fingering));
        ImageView a_barre = findViewById(R.id.a_barre);
        a_barre.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.a_barre_fingering));
        ImageView g_barre = findViewById(R.id.g_barre);
        g_barre.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.g_barre_fingering));

        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });

    }
    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}

