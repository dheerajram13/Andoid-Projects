package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by DHEERAJ on 16-06-2017.
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView showResults;
    long start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        th = (TabHost)findViewById(R.id.tabHost);
        Button newTab = (Button)findViewById(R.id.bAddTab);
        Button bStart = (Button)findViewById(R.id.bStart);
        Button bStop = (Button)findViewById(R.id.bStop);
        showResults = (TextView)findViewById(R.id.tvShow);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        newTab.setOnClickListener(this);
        th.setup();
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("StopWatch");
        th.addTab(specs);
        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Tab 2");
        th.addTab(specs);
        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Add a Tab");
        th.addTab(specs);
        start = 0;
    }

    @Override
    public void onClick(View view) {

    switch (view.getId()){
        case R.id.bAddTab:
            TabHost.TabSpec ourspec = th.newTabSpec("tag1");
            ourspec.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String s) {
                    TextView text = new TextView(Tabs.this);
                    text.setText("Hello! This is Dheeraj");
                    return (text);
                }
            });
            ourspec.setIndicator("New");
            th.addTab(ourspec);
            break;
        case R.id.bStart:
           start = System.currentTimeMillis();
            break;
        case R.id.bStop:
             stop = System.currentTimeMillis();

            if(start != 0){
                long result = stop - start;
                int mills  = (int) result;
                int sec = (int)result/1000;
                int min = sec/60;
                mills = mills%100;
                sec = sec %60;

                showResults.setText(String.format("%d:%02d:%02d",min,sec,mills));
            }
            break;
    }
    }

}
