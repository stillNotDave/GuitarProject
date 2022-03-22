package com.example.myguitarclass;

import android.media.MediaPlayer;

public class Sound { //класс для хранения данных о звуках
    public int sound_id;
    public String sound_name;
    public Sound(int sound_id,String sound_name){
            this.sound_id=sound_id;
            this.sound_name=sound_name;
    }
public static Sound[][] note_sound = {{new Sound(R.raw.string1_0,"E"),new Sound(R.raw.string1_1,"F"),new Sound(R.raw.string1_2,"F#"),new Sound(R.raw.string1_3,"G"),new Sound(R.raw.string1_4,"G#"),new Sound(R.raw.string1_5,"A"),new Sound(R.raw.string1_6,"A#"),new Sound(R.raw.string1_7,"B"),new Sound(R.raw.string1_8,"C"),new Sound(R.raw.string1_9,"C#"),new Sound(R.raw.string1_10,"D"),new Sound(R.raw.string1_11,"D#")},
                        {new Sound(R.raw.string2_0,"B"),new Sound(R.raw.string2_1,"C"),new Sound(R.raw.string2_2,"C#"),new Sound(R.raw.string2_3,"D"),new Sound(R.raw.string2_4,"D#"),new Sound(R.raw.string2_5,"E"),new Sound(R.raw.string2_6,"F"),new Sound(R.raw.string2_7,"F#"),new Sound(R.raw.string2_8,"G"),new Sound(R.raw.string2_9,"G#"),new Sound(R.raw.string2_10,"A"),new Sound(R.raw.string2_11,"A#")},
                        {new Sound(R.raw.string3_0,"G"),new Sound(R.raw.string3_1,"G#"),new Sound(R.raw.string3_2,"A"),new Sound(R.raw.string3_3,"A#"),new Sound(R.raw.string3_4,"B"),new Sound(R.raw.string3_5,"C"),new Sound(R.raw.string3_6,"C#"),new Sound(R.raw.string3_7,"D"),new Sound(R.raw.string3_8,"D#"),new Sound(R.raw.string3_9,"E"),new Sound(R.raw.string3_10,"F"),new Sound(R.raw.string3_11,"F#")},
                        {new Sound(R.raw.string4_0,"D"),new Sound(R.raw.string4_1,"D#"),new Sound(R.raw.string4_2,"E"),new Sound(R.raw.string4_3,"F"),new Sound(R.raw.string4_4,"F#"),new Sound(R.raw.string4_5,"G"),new Sound(R.raw.string4_6,"G#"),new Sound(R.raw.string4_7,"A"),new Sound(R.raw.string4_8,"A#"),new Sound(R.raw.string4_9,"B"),new Sound(R.raw.string4_10,"C"),new Sound(R.raw.string4_11,"C#")},
                        {new Sound(R.raw.string5_0,"A"),new Sound(R.raw.string5_1,"A#"),new Sound(R.raw.string5_2,"B"),new Sound(R.raw.string5_3,"C"),new Sound(R.raw.string5_4,"C#"),new Sound(R.raw.string5_5,"D"),new Sound(R.raw.string5_6,"D#"),new Sound(R.raw.string5_7,"E"),new Sound(R.raw.string5_8,"F"),new Sound(R.raw.string5_9,"F#"),new Sound(R.raw.string5_10,"G"),new Sound(R.raw.string5_11,"G#")},
                        {new Sound(R.raw.string6_0,"E"),new Sound(R.raw.string6_1,"F"),new Sound(R.raw.string6_2,"F#"),new Sound(R.raw.string6_3,"G"),new Sound(R.raw.string6_4,"G#"),new Sound(R.raw.string6_5,"A"),new Sound(R.raw.string6_6,"A#"),new Sound(R.raw.string6_7,"B"),new Sound(R.raw.string6_8,"C"),new Sound(R.raw.string6_9,"C#"),new Sound(R.raw.string6_10,"D"),new Sound(R.raw.string6_11,"D#")}} ;
public  static Sound[][] chord_sound = {{new Sound(R.raw.chord_d,"D"),new Sound(R.raw.chord_a,"A"),new Sound(R.raw.chord_a_diez,"A#"),
            new Sound(R.raw.chord_am,"Am"),new Sound(R.raw.chord_am_diez,"Am#"),new Sound(R.raw.chord_b,"B"),
            new Sound(R.raw.chord_bm,"Bm"),new Sound(R.raw.chord_c,"C"),new Sound(R.raw.chord_c_diez,"C#"),
            new Sound(R.raw.chord_cm,"Cm"),new Sound(R.raw.chord_cm_diez,"Cm#"),new Sound(R.raw.chord_d_diez,"D#"),
            new Sound(R.raw.chord_dm,"Dm"),new Sound(R.raw.chord_e,"E"),new Sound(R.raw.chord_em,"Em"),
            new Sound(R.raw.chord_f,"F"),new Sound(R.raw.chord_f_diez,"F#"),new Sound(R.raw.chord_fm,"Fm"),
            new Sound(R.raw.chord_fm_diez,"Fm#"),new Sound(R.raw.chord_g,"G"),new Sound(R.raw.chord_g_diez,"G#"),
            new Sound(R.raw.chord_dm_diez,"Dm#"),new Sound(R.raw.chord_gm,"Gm"),new Sound(R.raw.chord_gm_diez,"Gm#")}};
    public  static Sound[][] tuning_sound = {{new Sound(R.raw.tuning_e_major,"E major"),new Sound(R.raw.string1_0,"e"),new Sound(R.raw.string1_0,"B"),
            new Sound(R.raw.string3_0,"G"),new Sound(R.raw.string4_0,"D"),new Sound(R.raw.string5_0,"A"),
            new Sound(R.raw.string6_0,"E")},
            {new Sound(R.raw.tuning_drop_d,"Drop D"),new Sound(R.raw.string1_0,"e"),new Sound(R.raw.string1_0,"B"),
            new Sound(R.raw.string3_0,"G"),new Sound(R.raw.string4_0,"D"),new Sound(R.raw.string5_0,"A"),
            new Sound(R.raw.d_6str_for_dadgad_drop_d,"D")},
            {new Sound(R.raw.tuning_drop_c,"Drop C"),new Sound(R.raw.d_1str_for_dadgad_drop_c,"D"),new Sound(R.raw.a_2str_for_dadgad_drop_c,"A"),
            new Sound(R.raw.f_3str_for_drop_c,"F"),new Sound(R.raw.c_4str_for_drop_c,"C"),new Sound(R.raw.g_5str_for_drop_c,"G"),
            new Sound(R.raw.c_6str_for_drop_c,"C")},
            {new Sound(R.raw.tuning_dadgad,"DADGAD"),new Sound(R.raw.d_1str_for_dadgad_drop_c,"D"),new Sound(R.raw.a_2str_for_dadgad_drop_c,"A"),
            new Sound(R.raw.string3_0,"G"),new Sound(R.raw.string4_0,"D"),new Sound(R.raw.string5_0,"A"),
            new Sound(R.raw.d_6str_for_dadgad_drop_d,"D")}};

    public int getSound_id() {
        return sound_id;
    }

    public String getSound_name() {
        return sound_name;
    }

    public static void soundPlay(MediaPlayer sound){
        sound.setVolume(30,30);
        sound.seekTo(0); //для проигрыша трека с начала
        sound.start();
    }
}
