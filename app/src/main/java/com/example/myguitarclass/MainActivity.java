package com.example.myguitarclass;

import static com.example.myguitarclass.NavUtils.openActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Context context = this;
    private Button button_to_theory;
    private Button button_to_practice;
    private Button button_to_tuner;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_or_theory);


        button_to_theory = findViewById(R.id.theory);
        button_to_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(context,LessonList.class);
            }
        });

        ////////////////////////////////////

        /////////////////////////////////////

        button_to_practice = findViewById(R.id.practice);
        button_to_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(context, Practice.class);
            }

        });
        button_to_tuner = findViewById(R.id.tuner);
        button_to_tuner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity( context,TunerActivity.class);
            }

        });
    }

    //системная кнопка назад
    // 2 нажатия чтобы выйти
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}

