package com.example.myguitarclass;

import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Sound.soundPlay;
import static com.example.myguitarclass.Sound.tuning_sound;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuitarTuning extends AppCompatActivity {
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

    private MediaPlayer titleSound;
    private MediaPlayer stringOne;
    private MediaPlayer stringTwo;
    private MediaPlayer stringThree;
    private MediaPlayer stringFour;
    private MediaPlayer stringFive;
    private MediaPlayer stringSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guitar_tuning);

        titleSound = MediaPlayer.create(this,R.raw.tuning_e_major);
        stringOne = MediaPlayer.create(this,R.raw.string1_0);
        stringTwo = MediaPlayer.create(this,R.raw.string2_0);
        stringThree = MediaPlayer.create(this,R.raw.string3_0);
        stringFour = MediaPlayer.create(this, R.raw.string4_0);
        stringFive = MediaPlayer.create(this,R.raw.string5_0);
        stringSix = MediaPlayer.create(this,R.raw.string6_0);

        buttonTitle=findViewById(R.id.buttonDm);
        buttonTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(titleSound);
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
                soundPlay(stringOne);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringTwo=findViewById(R.id.stringB);
        buttonStringTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringTwo);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringThree=findViewById(R.id.stringG);
        buttonStringThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringThree);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringFour=findViewById(R.id.stringD);
        buttonStringFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringFour);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringFive=findViewById(R.id.stringA);
        buttonStringFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringFive);
                Promt_toast(numberTuning,v.getId());
            }
        });

        buttonStringSix=findViewById(R.id.stringE);
        buttonStringSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlay(stringSix);
                Promt_toast(numberTuning,v.getId());
            }

        });

        chooseTuning =findViewById((R.id.button34)); //начала попупа
        chooseTuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(GuitarTuning.this, chooseTuning);//привязываем попуп к активностии и кнопке
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

                            case R.id.Open_D:
                                numberTuning=4;
                                Change_tuning();
                                return true;

                            case R.id.Open_G:
                                numberTuning=5;
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

    /*public void openActivity_MainActivity(){
        Intent intent = new Intent(this,Practice.class); //кнопка назад, открыть предыдущую активность
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }*/



    public MediaPlayer ChangeSound(int sound){
        MediaPlayer mp = MediaPlayer.create(this,sound);
        return mp;
    }
    @SuppressLint("NonConstantResourceId")
    public void Promt_toast(int number_tuning, int number_string) //вывод подсказок по настройке гитары
    {

        switch (number_tuning){
            case 0: //e major
                break;
            case 1: // drop d
                switch (number_string) {
                    case R.id.stringe:
                    case R.id.stringB:

                    case R.id.stringG:
                    case R.id.stringD:
                    case R.id.stringA:
                        Toast.makeText(GuitarTuning.this, "Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringE:
                        Toast.makeText(GuitarTuning.this,"Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case 2: //drop c
                switch (number_string) {
                    case R.id.stringe:
                    case R.id.stringB:
                    case R.id.stringG:
                    case R.id.stringD:
                    case R.id.stringA:
                        Toast.makeText(GuitarTuning.this, "Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringE:
                        Toast.makeText(GuitarTuning.this,"Опустите струну на 2 тона относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case 3: //dadgad
                switch (number_string) {
                    case R.id.stringe:
                    case R.id.stringB:
                    case R.id.stringE:
                        Toast.makeText(GuitarTuning.this, "Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringG:
                    case R.id.stringD:
                    case R.id.stringA:
                        Toast.makeText(GuitarTuning.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case 4: //open d
                switch (number_string){
                    case R.id.stringe:
                    case R.id.stringB:
                    case R.id.stringE:
                        Toast.makeText(GuitarTuning.this, "Опустите струну на тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringG:
                        Toast.makeText(GuitarTuning.this, "Опустите струну на пол тона относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringD:
                    case R.id.stringA:
                        Toast.makeText(GuitarTuning.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
            case 5: //open g
                switch (number_string){
                    case R.id.stringe:
                    case R.id.stringA:
                    case R.id.stringE:
                        Toast.makeText(GuitarTuning.this, "Опустите струну тон относительно стандартного строя", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.stringB:
                    case R.id.stringG:
                    case R.id.stringD:
                        Toast.makeText(GuitarTuning.this,"Как и в стандартном строе", Toast.LENGTH_LONG).show();
                        break;
                }
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

        titleSound=ChangeSound(tuning_sound[numberTuning][0].getSound_id());
        stringOne=ChangeSound(tuning_sound[numberTuning][1].getSound_id());
        stringTwo=ChangeSound(tuning_sound[numberTuning][2].getSound_id());
        stringThree = ChangeSound(tuning_sound[numberTuning][3].getSound_id());
        stringFour = ChangeSound(tuning_sound[numberTuning][4].getSound_id());
        stringFive = ChangeSound(tuning_sound[numberTuning][5].getSound_id());
        stringSix=ChangeSound(tuning_sound[numberTuning][6].getSound_id());
    }


}


