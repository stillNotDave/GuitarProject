package com.example.myguitarclass;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
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

import static com.example.myguitarclass.NavUtils.openActivity;

public class LessonList extends Activity {
    Context context = this;
    private Button buttonBack;
    ListView lvMain; //лист вью

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
                        openActivity(context,LessonZero.class);
                        break;
                    case 1:
                        openActivity(context,LessonOne.class);
                        break;
                    case 2:
                        openActivity(context,LessonTwo.class);
                        break;
                    case 3:
                        openActivity(context,LessonThree.class);
                        break;
                    case 4:
                        openActivity(context,LessonFour.class);
                        break;
                    case 5:
                        openActivity(context,LessonFive.class);
                        break;
                    case 6:
                        openActivity(context,LessonSix.class);
                        break;
                    case 7:
                        openActivity(context,LessonSeven.class);
                        break;
                    case 8:
                        openActivity(context,LessonEight.class);
                        break;
                    case 9:
                        openActivity(context,LessonNine.class);
                        break;
                    case 10:
                        openActivity(context,LessonTen.class);
                        break;
                    case 11:
                        openActivity(context,LessonEleven.class);
                        break;
                    case 12:
                        openActivity(context,LessonTwelve.class);
                        break;
                    case 13:
                        openActivity(context,LessonThirteen.class);
                        break;
                    case 14:
                        openActivity(context,LessonFourteen.class);
                        break;
                    case 15:
                        openActivity(context,LessonFifteen.class);
                        break;
                    case 16:
                        openActivity(context,LessonSixteen.class);
                        break;
                    case 17:
                        openActivity(context,LessonSeventeen.class);
                    case 18:
                        openActivity(context,LessonEighteen.class);
                        break;
                    case 19:
                        openActivity(context,LessonNineteen.class);


                }


            }
        });

        buttonBack = findViewById(R.id.button11);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                openActivity(context,MainActivity.class);
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }


}