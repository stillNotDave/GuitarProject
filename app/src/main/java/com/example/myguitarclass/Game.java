package com.example.myguitarclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


import static com.example.myguitarclass.ChooseString.paramString;
import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Training.paramIntent;


public class Game extends AppCompatActivity {
    Context context = this;
    private  Button buttonBack;
    private  Button buttonSoundPlay;
    private  Button button_one;
    private  Button button_two;
    private  Button button_three;
    private  Button button_four;
    static int position;
    int color;
    int answerContainerOnClick=0; //для хранения номера нажатой кнопки
    int answer[]={-1,-1,-1,-1}; //для храненя номеров ответов
    int forText[]={0,0,0,0};//для хранения id текста ноты или аккорда для кнопках
    Sound soundContainer[][];// сюда помещается масссив звуков,  с которым работаем в данный момент. (ноты или аккорды)
    int variant[];
    private MediaPlayer titleSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_lauoyt_with_4_answers);

        TextView textView = findViewById(R.id.textView3);
        titleSound = RandomSound();
        titleSound.setVolume(30,30);
        MakeAnswerArr();
        PrepareForText();
        buttonBack=findViewById(R.id.button20);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context);

            }
        });

        buttonSoundPlay=findViewById(R.id.sound_b);
        buttonSoundPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Sound.soundPlay(titleSound);
                textView.setText("");
            }
        });

        button_one=findViewById(R.id.otvet1);
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerContainerOnClick=0;
                textView.setText(CheckAnswer()); //вывод текста в зависимости от правильности ответа
                textView.setTextColor(color);// выбор цвета в зависимости от правильности ответа
            }
        });

        button_two=findViewById(R.id.otvet2);

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerContainerOnClick=1;
                textView.setText(CheckAnswer());
                textView.setTextColor(color);
            }
        });

        button_three=findViewById(R.id.otvet3);

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerContainerOnClick=2;
                textView.setText(CheckAnswer());
                textView.setTextColor(color);
            }
        });

        button_four=findViewById(R.id.otvet4);
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerContainerOnClick=3;
                textView.setText(CheckAnswer());
                textView.setTextColor(color);
            }

        });
        ChangeTextOnButton();
    }
    @Override
    protected void onStop() {
        super.onStop();

        finish();

    }

    public MediaPlayer RandomSound()
    {
        Random random = new Random();
        if(paramIntent==2) { //инициализация массивов звуков и вариантов в завиомости от выбора тренировки (ноты или акорды)
            soundContainer= Sound.note_sound.clone();
            position = random.nextInt(12);
            variant= new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        }else
        {
            soundContainer= Sound.chord_sound.clone();
            position = random.nextInt(24);
            variant= new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12,13,14,15,16,17,18,19,20,21,22,23};
        }

        MediaPlayer mp = MediaPlayer.create(this, soundContainer[paramString][position].getSound_id());

        return mp;
    }
    public void MakeAnswerArr()
    {
        Random random = new Random();
       int rand_move = random.nextInt(4);
       answer[0]=-1;
       answer[1]=-1;
       answer[2]=-1;
       answer[3]=-1;
       answer[rand_move]= position; //в рандомное место в массиве помещаю номер правильного ответа
    }
    public String CheckAnswer()
    {
        if(answer[answerContainerOnClick]!=-1)
        {
            return RightAnswer();
        }
        else{
           return  WrongAnswer();
        }

    }
    public String RightAnswer() {
        color = Color.argb(255, 153, 255, 0);
        titleSound = RandomSound();
        MakeAnswerArr();
        PrepareForText();
        ChangeTextOnButton();
        return "Верно";
    }
    public void PrepareForText()
    {

        variant[position]=-1;//исключаем из рандомных нот правильный ответ, чтобы случайно не создать несколько кнопок с правильным ответом

        for(int i=0;i<4;i++)
        {
            int help_for=0; //вспомогательная переменная для работы цикла
            if(answer[i]==position)//блок для правильного ответа
            {
                forText[i]=position;
            }
            else{
                for(;help_for==0;){ //идем по циклу пока не найдем свободную неправильную ноту для кнопок
                    int rand_container =Randomize();
                    if(variant[rand_container]!=-1){
                        forText[i] = rand_container;
                        variant[rand_container]=-1;
                        help_for=1;
                    }
                }


            }
        }


    }
    public String WrongAnswer()
    {
        color = Color.argb(255, 255, 21, 0);
        String str = "Не верно, это было: "+soundContainer[paramString][position].getSound_name();
        titleSound = RandomSound();
        MakeAnswerArr();
        PrepareForText();
        ChangeTextOnButton();
        return str;
    }
    /*public void openActivity(){ //для перехода назад по активностям
        Intent intent = new Intent();

        if(paramIntent==1) {
            intent = new Intent(this, Training.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else
        {
            intent = new Intent(this, ChooseString.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }*/

    public int  Randomize() {
        Random random = new Random();
        int rand_container = random.nextInt(12);
        return rand_container;
    }
    public void ChangeTextOnButton()
    {
        button_one.setText(soundContainer[paramString][forText[0]].getSound_name());//в зависимости от выбранной струны выводин название нот на кнопки
        button_two.setText(soundContainer[paramString][forText[1]].getSound_name());
        button_three.setText(soundContainer[paramString][forText[2]].getSound_name());
        button_four.setText(soundContainer[paramString][forText[3]].getSound_name());
    }

}

