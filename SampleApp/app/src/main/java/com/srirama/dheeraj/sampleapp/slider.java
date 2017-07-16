package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by DHEERAJ on 15-06-2017.
 */
public class slider extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SlidingDrawer.OnDrawerOpenListener {
    SlidingDrawer sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);
        Button handle = (Button)findViewById(R.id.button);
        Button handle1 = (Button)findViewById(R.id.button1);
        Button handle2 = (Button)findViewById(R.id.button2);
        CheckBox ck  = (CheckBox)findViewById(R.id.checkBox);
        sd = (SlidingDrawer)findViewById(R.id.slidingDrawer);
        sd.setOnDrawerOpenListener(this);
        ck.setOnCheckedChangeListener(this);
        handle.setOnClickListener(this);
        handle1.setOnClickListener(this);
        handle2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
               sd.open();
                 break;
            case R.id.button1:
                sd.toggle();
                break;
            case R.id.button2:
               sd.close();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton chk, boolean b) {
       if (chk.isChecked()){
            sd.lock();
        }
        else{
           sd.unlock();

        }
    }

    @Override
    public void onDrawerOpened() {
        MediaPlayer mp  = MediaPlayer.create(this,R.raw.exp);
        mp.start();
    }
}
