package com.example.myguitarclass;

import static com.example.myguitarclass.NavUtils.openActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Practice extends AppCompatActivity {

    Context context = this;

    private Button buttonMainToTraining;
    private Button buttonMainToGuitarTuning;
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
                openActivity(context,MainActivity.class);
            }
        });

        buttonMainToTraining=findViewById(R.id.training);
        buttonMainToTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openActivity(context,Training.class);
            }
        });

        buttonMainToGuitarTuning=findViewById(R.id.tuning);
        buttonMainToGuitarTuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(context,Camerton.class);
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
            finish();

    }
//    public void openActivity(Class<?> cls) {
//       // finish();
//        Intent intent = new Intent(this, cls);
//        startActivity(intent);
//    }

}
