

package com.example.myguitarclass;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.myguitarclass.NavUtils.openActivity;
import static com.example.myguitarclass.Training.paramIntent;

public class TunerActivity extends AppCompatActivity {

    private static final String TAG = TunerActivity.class.getCanonicalName();//мусор?
    Context context = this;
    public static final String STATE_NEEDLE_POS = "needle_pos";
    public static final String STATE_PITCH_INDEX = "pitch_index";
    public static final String STATE_LAST_FREQ = "last_freq";
    private static final int PERMISSION_REQUEST_RECORD_AUDIO = 443;


    private Button buttonBack;
    private Button chooseTuning;
    private Tuning mTuning;// m - бесполезная вещь рекомендованная гуглом
    private AudioProcessor mAudioProcessor;//?
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();// потока для записи звука
    private NeedleView mNeedleView; //указатель
    private TuningView mTuningView;
    private TextView mFrequencyView;

    private boolean mProcessing = false;

    private int mPitchIndex;
    private float mLastFreq;


    @Override
    protected void onStart() {
        super.onStart();
        if(Utils.checkPermission(this, Manifest.permission.RECORD_AUDIO)) {
            startAudioProcessing();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mProcessing) {
            mAudioProcessor.stop();
            mProcessing = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void requestPermissions() {
        if (!Utils.checkPermission(this, Manifest.permission.RECORD_AUDIO)) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {

                DialogUtils.showPermissionDialog(this, getString(R.string.permission_record_audio), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(TunerActivity.this,
                                new String[]{Manifest.permission.RECORD_AUDIO},
                                PERMISSION_REQUEST_RECORD_AUDIO);
                    }
                });

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        PERMISSION_REQUEST_RECORD_AUDIO);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    startAudioProcessing();
        }


    private void startAudioProcessing() {
        if (mProcessing)
            return;


        mAudioProcessor = new AudioProcessor(); //проверить можно ли объединить init с конструктором
        mAudioProcessor.init();
        mAudioProcessor.setPitchDetectionListener(new AudioProcessor.PitchDetectionListener() {
            @Override
            public void onPitchDetected(final float freq, double avgIntensity) {

                final int index = mTuning.closestPitchIndex(freq); //определяет индекс тона
                final Pitch pitch = mTuning.pitches[index];
                double interval = 1200 * Utils.log2(freq / pitch.frequency); // преобразование герцев в центы
                final float needlePos = (float) (interval / 100);
                final boolean goodPitch = Math.abs(interval) < 5.0; //вспомогательная переменная для отображения галочки
                runOnUiThread(new Runnable() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void run() {
                        mTuningView.setSelectedIndex(index, true);
                        mNeedleView.setTickLabel(0.0F, String.format("%.02fHz", pitch.frequency));// вывод частоты записи
                        mNeedleView.animateTip(needlePos);
                        mFrequencyView.setText(String.format("%.02fHz", freq));


                        final View goodPitchView = findViewById(R.id.good_pitch_view);//переделать
                        if (goodPitchView != null) {
                            if (goodPitch) {
                                if (goodPitchView.getVisibility() != View.VISIBLE) {
                                    Utils.reveal(goodPitchView);//отображаем или не отображаем галочку
                                }
                            } else if (goodPitchView.getVisibility() == View.VISIBLE) {
                                Utils.hide(goodPitchView);
                            }
                        }
                    }
                });

                mPitchIndex = index;
                mLastFreq = freq;

            }
        });
        mProcessing = true;
        mExecutor.execute(mAudioProcessor);// старт отдельного потока для записи звука
    }



    @Override
    protected void onPause() {
        super.onPause();
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuner);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//сохроняет экран включенным
        //mTuning = Tuning.getTuning(this, Preferences.getString(this, getString(R.string.pref_tuning_key), getString(R.string.standard_tuning_val)));//инициализация тюнинга, в зависимости от выбранного строя
        mTuning = Tuning.getTuning(this, "Standard");
        mNeedleView = (NeedleView) findViewById(R.id.pitch_needle_view);//насйтрока отображения указателя
        mNeedleView.setTickLabel(-1.0F, "-100c");
        mNeedleView.setTickLabel(0.0F, String.format("%.02fHz", mTuning.pitches[0].frequency));
        mNeedleView.setTickLabel(1.0F, "+100c");

        int primaryTextColor = Utils.getAttrColor(this, android.R.attr.textColorPrimary);

        mTuningView = findViewById(R.id.tuning_view);
        mTuningView.setTuning(mTuning);


        mFrequencyView = (TextView) findViewById(R.id.frequency_view);
        mFrequencyView.setText(String.format("%.02fHz", mTuning.pitches[0].frequency));

        ImageView goodPitchView = (ImageView) findViewById(R.id.good_pitch_view);//галочка
        goodPitchView.setColorFilter(primaryTextColor);

       requestPermissions();//уда
        buttonBack=findViewById(R.id.button21);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openActivity(context, MainActivity.class);

            }
        });
        chooseTuning =findViewById((R.id.button34)); //начала попупа
        chooseTuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, chooseTuning);//привязываем попуп к активностии и кнопке
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu_tuner, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.E_major:
                                //numberTuning=0;
                                mTuningView.setTuning(Tuning.getTuning(context,"Standard"));

                                return true;
                            case R.id.Open_A:
                                //numberTuning=1;
                                mTuningView.setTuning( Tuning.getTuning(context,"Open A"));

                                return true;
                            case R.id.Open_G:
                               // numberTuning=2;
                                mTuningView.setTuning(Tuning.getTuning(context,"Open G"));

                                return true;
                            case R.id.Open_D:
                                //numberTuning=3;
                                mTuningView.setTuning( Tuning.getTuning(context,"Open D"));

                                return true;
                            case R.id.Drop_D:
                                //numberTuning=3;
                                mTuningView.setTuning( Tuning.getTuning(context,"Drop D"));

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


    //настройки нужно будет перенести
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                NavUtils.showSettingsActivity(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
