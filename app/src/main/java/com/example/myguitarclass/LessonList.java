package com.example.myguitarclass;

import android.app.Activity;
import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

public class LessonList extends Activity {

    private Button buttonBack;
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);

        lvMain = (ListView) findViewById(R.id.list);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.forbes, android.R.layout.simple_list_item_1);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch ( position){
                    case 0:
                        openActivity(LessonZero.class);
                        break;
                    case 1:
                        openActivity(LessonOne.class);
                        break;
                    case 2:
                        openActivity(LessonTwo.class);
                        break;
                    case 3:
                        openActivity(LessonThree.class);
                        break;
                    case 4:
                        openActivity(LessonFour.class);
                        break;
                    case 5:
                        openActivity(LessonFive.class);
                        break;
                    case 6:
                        openActivity(LessonSix.class);
                        break;
                    case 7:
                        openActivity(LessonSeven.class);
                        break;
                    case 8:
                        openActivity(LessonEight.class);
                        break;
                    case 9:
                        openActivity(LessonNine.class);
                        break;
                }


            }
        });

        buttonBack = findViewById(R.id.button11);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                openActivity(MainActivity.class);
            }
        });

    }


    public void openActivity(Class<?> cls) {

        Intent a = new Intent(this, cls);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}