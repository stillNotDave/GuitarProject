package com.example.myguitarclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseString extends AppCompatActivity {

    private Button buttonBack;
    private Button button1String;
    private Button button2String;
    private Button button3String;
    private Button button4String;
    private Button button5String;
    private Button button6String;


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
        button1String=findViewById(R.id.button);
        button1String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=0;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button2String=findViewById(R.id.button9);
        button2String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=1;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button3String=findViewById(R.id.button6);
        button3String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=2;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);


            }
        });
        button4String=findViewById(R.id.button10);
        button4String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=3;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button5String=findViewById(R.id.button7);
        button5String.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                paramString=4;
                Training.paramIntent=2;//передаем параметр,чтобы потом правильно вернуться на ктивность
                openActivity( Game.class);

            }
        });
        button6String=findViewById(R.id.button8);
        button6String.setOnClickListener(new View.OnClickListener() {
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