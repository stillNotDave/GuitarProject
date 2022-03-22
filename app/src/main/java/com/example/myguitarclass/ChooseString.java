package com.example.myguitarclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseString extends AppCompatActivity {

    private Button buttonBack;
    private Button button_1_string;
    private Button button_2_string;
    private Button button_3_string;
    private Button button_4_string;
    private Button button_5_string;
    private Button button_6_string;


    static int paramString; //параметр выбора струны необходим, чтобы тренировать слух по конкретной струне

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_string);

        buttonBack=findViewById(R.id.button11);//находим нужную кнопку по айди
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    finish();
                    openActivity(Training.class);
                }
                catch (Exception e){
                }
            }
        });
        button_1_string=findViewById(R.id.button);
        button_1_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=0;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button_2_string=findViewById(R.id.button9);
        button_2_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=1;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button_3_string=findViewById(R.id.button6);
        button_3_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=2;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);


            }
        });
        button_4_string=findViewById(R.id.button10);
        button_4_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=3;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button_5_string=findViewById(R.id.button7);
        button_5_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=4;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button_6_string=findViewById(R.id.button8);
        button_6_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=5;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

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
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}