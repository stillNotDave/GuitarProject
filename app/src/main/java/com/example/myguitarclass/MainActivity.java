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
    private Button buttonToTheory;
    private Button buttonToPractice;
    private Button buttonToTuner;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_or_theory);


        buttonToTheory = findViewById(R.id.theory);
        buttonToTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(context,LessonList.class);
            }
        });

        ////////////////////////////////////

        /////////////////////////////////////

        buttonToPractice = findViewById(R.id.practice);
        buttonToPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(context, Practice.class);
            }

        });
        buttonToTuner = findViewById(R.id.tuner);
        buttonToTuner.setOnClickListener(new View.OnClickListener() {
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

