package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by DHEERAJ on 13-06-2017.
 */
public class GFX extends Activity {


    Myview ourView;
    PowerManager.WakeLock wl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"Hello!");
        super.onCreate(savedInstanceState);
        wl.acquire();
        ourView = new Myview(this);
        setContentView(ourView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wl.release();
    }
}
