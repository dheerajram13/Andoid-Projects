package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by DHEERAJ on 05-06-2017.
 */
public class Splash extends Activity {
    MediaPlayer oursong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        oursong = MediaPlayer.create(Splash.this,R.raw.shape);
        oursong.start();
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new  Intent("com.srirama.dheeraj.sampleapp.MENU");
                    startActivity(intent);
                }
            }
        };
        timer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        oursong.release();
        finish();
    }
}
