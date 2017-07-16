package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
/**
 * Created by DHEERAJ on 14-06-2017.
 */
public class Soundstuff extends Activity implements View.OnClickListener, View.OnLongClickListener {
    int explosion = 0;
    SoundPool sp;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        setContentView(v);
        sp = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
        explosion = sp.load(this,R.raw.exp,1);
        mp = MediaPlayer.create(this,R.raw.gun);
     }

    @Override
    public void onClick(View view) {
    if(explosion!=0)
        sp.play(explosion,1,1,0,0,1);

    }

    @Override
    public boolean onLongClick(View view) {
        mp.start();
        return false;

    }
}
