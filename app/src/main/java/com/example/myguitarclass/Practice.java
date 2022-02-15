package com.example.myguitarclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Practice extends AppCompatActivity {

    private Button button_main_to_training;
    private Button button_main_to_guitar_tuning;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack=findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(MainActivity.class);
            }
        });

        button_main_to_training=findViewById(R.id.training);
        button_main_to_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_main_to_guitar_tuning=findViewById(R.id.tuning);
        button_main_to_guitar_tuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity(GuitarTuning.class);
            }
        });
    }


    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }

}
