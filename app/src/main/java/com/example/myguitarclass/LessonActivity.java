package com.example.myguitarclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.myguitarclass.NavUtils.openActivity;

public class LessonActivity extends Activity {
    private Button buttonBack;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,LessonList.class);
            }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }


}
