package com.example.myguitarclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonActivity extends Activity {
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) { ///надо проверить используется ли она
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity);


        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(LessonList.class);
            }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }
    public void openActivity(Class<?> cls) {

        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}
