package com.example.myguitarclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.myguitarclass.ChooseString.paramString;

public class Training extends AppCompatActivity {

    private Button buttonBack;
    private Button buttonTrainingNotes;
    private Button buttonTrainingChords;
    static int paramIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_notes_or_strings);

        buttonBack=findViewById(R.id.back);
        buttonTrainingNotes=findViewById(R.id.training_by_notes);
        buttonTrainingChords =findViewById(R.id.training_by_chords);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
                    openActivity(Practice.class);


            }
        });

        buttonTrainingNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ChooseString.class);
            }
        });

        buttonTrainingChords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramIntent=1; //для перехода между экранамами choose_string,training_notes_or_string и game_with_4_answers
                paramString = 0;
                openActivity(Game.class);
            }
        });
    }

    public void openActivity_game_with_4_answers(){
        Intent intent = new Intent(this, Game.class);
        paramIntent=1; //для перехода между экранамами choose_string,training_notes_or_string и game_with_4_answers
        paramString = 0; //гипотетическая струна нужна, чтобы была возможность создать массив в Sound по тому же шаблану что и в note_sound

        //getExtra для передачи данных здесь не реализованно, так как оно выводило страные ошибки при хождении между актиновстями

        startActivity(intent);
    }

    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}