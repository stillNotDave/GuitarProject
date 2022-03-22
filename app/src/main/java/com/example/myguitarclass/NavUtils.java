
package com.example.myguitarclass;

import android.content.Context;
import android.content.Intent;

import static com.example.myguitarclass.Training.paramIntent;

public class NavUtils {

    public static void openActivity(Context context,Class<?> cls) {

        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    public static void openActivity(Context context) {
        Intent intent = new Intent();

        if(paramIntent==1) {
            intent = new Intent(context, Training.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
        else
        {
            intent = new Intent(context, ChooseString.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }
}
