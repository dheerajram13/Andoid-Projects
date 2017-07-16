package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by DHEERAJ on 21-06-2017.
 */
public class flipper extends Activity implements View.OnClickListener {

    ViewFlipper flippy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flippy = (ViewFlipper)findViewById(R.id.viewFlipper1);
        flippy.setOnClickListener(this);
        flippy.setFlipInterval(500);
        flippy.startFlipping();
    }

    @Override
    public void onClick(View view) {
       flippy.showNext();
    }
}
