

package com.example.myguitarclass;

import android.annotation.SuppressLint;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;


public class AudioProcessor implements Runnable {

    private static final String TAG = AudioProcessor.class.getCanonicalName();

    private static final int[] SAMPLE_RATES = {44100, 22050, 16000, 11025, 8000}; //стандартные частоты дискретизации звуков


    public interface PitchDetectionListener {
        void onPitchDetected(float freq, double avgIntensity);
    }

    private float mLastComputedFreq = 0;

    private AudioRecord mAudioRecord;
    private PitchDetectionListener mPitchDetectionListener;
    private boolean mStop = false;


    public void setPitchDetectionListener(PitchDetectionListener pitchDetectionListener) {
        mPitchDetectionListener = pitchDetectionListener;
    }

    @SuppressLint("MissingPermission")// чтобы не ругался на 43 строчку
    public void init() {
        int bufSize = 16384;
        int avalaibleSampleRates = SAMPLE_RATES.length;//изменить в строке 48
        int i = 0;
        do {
            Log.d(TAG, "1=");
            int sampleRate = SAMPLE_RATES[i];
            int minBufSize = AudioRecord.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);//инимальный размер буфера, при котором объект AudioRecord сможет работать
            if (minBufSize != AudioRecord.ERROR_BAD_VALUE && minBufSize != AudioRecord.ERROR) {
                mAudioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, Math.max(bufSize, minBufSize * 4));
                //источник записи, частота записи, настройка аудио канала, возвращаемое значение, размер буфера
            }
            i++;
        }
        while (i < avalaibleSampleRates && (mAudioRecord == null || mAudioRecord.getState() != AudioRecord.STATE_INITIALIZED));
        Log.d(TAG, "2=");
    }

    public void stop() {
        mStop = true;
        mAudioRecord.stop();
        mAudioRecord.release();
    }

    @Override
    public void run() {

        //убрать логирование
        Log.d(TAG, "sampleRate="+mAudioRecord.getSampleRate());

        if(mAudioRecord.getState() != AudioRecord.STATE_INITIALIZED) {
           Log.e(TAG, "AudioRecord not initialized");
        }
        Log.d(TAG, "3=");
        mAudioRecord.startRecording();
        int bufSize = 8192;
        final int sampleRate = mAudioRecord.getSampleRate();
        final short[] buffer = new short[bufSize];

        do {
            final int read = mAudioRecord.read(buffer, 0, bufSize);
            if (read > 0) {
                final double intensity = averageIntensity(buffer, read);//?

                int maxZeroCrossing = (int) (250 * (read / 8192) * (sampleRate / 44100.0));//демонические вычисления

                if (intensity >= 50 && zeroCrossingCount(buffer) <= maxZeroCrossing) {

                    float freq = getPitch(buffer, read / 4, read, sampleRate, 50, 500);
                    if (Math.abs(freq - mLastComputedFreq) <= 5f) {
                        mPitchDetectionListener.onPitchDetected(freq, intensity);//вызывается, когда записанная дорожка удовлетворяет условиям
                    }
                    mLastComputedFreq = freq;


                }
            }
        } while (!mStop);

        Log.d(TAG, "Thread terminated");
    }

    private double averageIntensity(short[] data, int frames) {//средняя частота

        double sum = 0;
        for (int i = 0; i < frames; i++) {
            sum += Math.abs(data[i]);
        }
        return sum / frames;

    }

    private int zeroCrossingCount(short[] data) {//?
        int len = data.length;
        int count = 0;
        boolean prevValPositive = data[0] >= 0;
        for (int i = 1; i < len; i++) {
            boolean positive = data[i] >= 0;
            if (prevValPositive == !positive)
                count++;

            prevValPositive = positive;
        }
        return count;
    }

    private float getPitch(short[] data, int windowSize, int frames, float sampleRate, float minFreq, float maxFreq) {

        float maxOffset = sampleRate / minFreq; //определение смещения
        float minOffset = sampleRate / maxFreq;


        int minSum = Integer.MAX_VALUE;
        int minSumLag = 0; //минимальаня сумма задержки
        int[] sums = new int[Math.round(maxOffset) + 2];

        for (int lag = (int) minOffset; lag <= maxOffset; lag++) {
            int sum = 0;
            for (int i = 0; i < windowSize; i++) {

                int oldIndex = i - lag;

                int sample = ((oldIndex < 0) ? data[frames + oldIndex] : data[oldIndex]);

                sum += Math.abs(sample - data[i]);
            }

            sums[lag] = sum;

            if (sum < minSum) {
                minSum = sum;
                minSumLag = lag;
            }
        }

		// квадратичная интерполяция для исправления ошибок
		float delta = (float) (sums[minSumLag + 1] - sums[minSumLag - 1]) / ((float)
			(2 * (2 * sums[minSumLag] - sums[minSumLag + 1] - sums[minSumLag - 1])));
		return sampleRate / (minSumLag + delta);
    }


}
