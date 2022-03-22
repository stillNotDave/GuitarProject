package com.example.myguitarclass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.tuning_sound;

public class Camerton extends AppCompatActivity {
    Context context = this;
    private  Button buttonBack;
    private  Button buttonTitle;
    private  Button buttonStringOne;
    private  Button buttonStringTwo;
    private  Button buttonStringThree;
    private  Button buttonStringFour;
    private  Button buttonStringFive;
    private  Button buttonStringSix;
    private  Button chooseTuning;

    int numberTuning=0;

    private MediaPlayer title_sound;
    private MediaPlayer string_one;
    private MediaPlayer string_two;
    private MediaPlayer string_three;
    private MediaPlayer string_four;
    private MediaPlayer string_five;
    private MediaPlayer string_six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guitar_tuning);

        title_sound = MediaPlayer.create(this,R.raw.tuning_e_major);
        string_one = MediaPlayer.create(this,R.raw.string1_0);
        string_two = MediaPlayer.create(this,R.raw.string2_0);
        string_three = MediaPlayer.create(this,R.raw.string3_0);
        string_four = MediaPlayer.create(this, R.raw.string4_0);
        string_five = MediaPlayer.create(this,R.raw.string5_0);
        string_six = MediaPlayer.create(this,R.raw.string6_0);

        buttonTitle=findViewById(R.id.buttonDm);
        buttonTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(title_sound);
            }
        });

        buttonBack=findViewById(R.id.button21);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context,Practice.class);
            }
        });

        buttonStringOne=findViewById(R.id.stringe);
        buttonStringOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_one);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringTwo=findViewById(R.id.stringB);
        buttonStringTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_two);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringThree=findViewById(R.id.stringG);
        buttonStringThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_three);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringFour=findViewById(R.id.stringD);
        buttonStringFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_four);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringFive=findViewById(R.id.stringA);
        buttonStringFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_five);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringSix=findViewById(R.id.stringE);
        buttonStringSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(string_six);
                Promt_toast(numberTuning,v.getId());
            }

        });

        chooseTuning =findViewById((R.id.button34)); //начала попупа
        chooseTuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Camerton.this, chooseTuning);//привязываем попуп к активностии и кнопке
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.E_major:
                                numberTuning=0;
                                Change_tuning();

                                return true;
                            case R.id.Drop_D:
                                numberTuning=1;
                                Change_tuning();

                                return true;
                            case R.id.Drop_C:
                                numberTuning=2;
                                Change_tuning();

                                return true;
                            case R.id.DADGAD:
                                numberTuning=3;
                                Change_tuning();

                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        finish();

    }




    public MediaPlayer ChangeSound(int sound){
        MediaPlayer mp = MediaPlayer.create(this,sound);
        return mp;
    }
    @SuppressLint("NonConstantResourceId")
    public void Promt_toast(int number_tuning, int number_string) //вывод подсказок по настройке гитары
    {

        switch (number_tuning){
            case 0:
                break;
            case 1:
                switch (number_string) { //это стоит доработать
                    case R.id.stringe:
                        Toast.makeText(Camerton.this, "Как и в стандартном строе", Toast.LENGTH_LONG).show();

                        break;
                    case R.id.stringB:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();

                        break;
                    case R.id.stringG:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringD:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringA:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringE:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();

                        break;
                }
                break;
            case 2:
                switch (number_string) {
                    case R.id.stringe:
                        Toast.makeText(Camerton.this, "Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringB:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringG:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringD:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringA:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringE:
                        Toast.makeText(Camerton.this,"Опустите струну на 2 тона относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case 3:
                switch (number_string) {
                    case R.id.stringe:
                        Toast.makeText(Camerton.this, "Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringB:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringG:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringD:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringA:
                        Toast.makeText(Camerton.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringE:
                        Toast.makeText(Camerton.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }
    }
    public void Change_tuning(){
        buttonTitle.setText(tuning_sound[numberTuning][0].getSound_name());
        buttonStringOne.setText(tuning_sound[numberTuning][1].getSound_name());
        buttonStringTwo.setText(tuning_sound[numberTuning][2].getSound_name());
        buttonStringThree.setText(tuning_sound[numberTuning][3].getSound_name());
        buttonStringFour.setText(tuning_sound[numberTuning][4].getSound_name());
        buttonStringFive.setText(tuning_sound[numberTuning][5].getSound_name());
        buttonStringSix.setText(tuning_sound[numberTuning][6].getSound_name());

        title_sound=ChangeSound(tuning_sound[numberTuning][0].getSound_id());
        string_one=ChangeSound(tuning_sound[numberTuning][1].getSound_id());
        string_two=ChangeSound(tuning_sound[numberTuning][2].getSound_id());
        string_three = ChangeSound(tuning_sound[numberTuning][3].getSound_id());
        string_four = ChangeSound(tuning_sound[numberTuning][4].getSound_id());
        string_five = ChangeSound(tuning_sound[numberTuning][5].getSound_id());
        string_six=ChangeSound(tuning_sound[numberTuning][6].getSound_id());
    }


}


