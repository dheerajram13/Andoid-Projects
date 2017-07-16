package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DHEERAJ on 22-06-2017.
 */
public class Sharedprefs extends Activity implements View.OnClickListener {
  EditText ed1;
  TextView tv1;
    static String filename = "MySharedString";
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedprefs);
        intialize();
       someData = getSharedPreferences(filename,0);
    }

    private void intialize(){
        Button bt1 = (Button)findViewById(R.id.load);
        Button bt2 = (Button)findViewById(R.id.save);
        ed1 = (EditText)findViewById(R.id.editText2);
        tv1 = (TextView)findViewById(R.id.textV1);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.load:
                someData = getSharedPreferences(filename,0);
                String datareturn = someData.getString("sharedString","couldn't load data");
                tv1.setText(datareturn);
                break;
            case R.id.save:
                String data = ed1.getText().toString();
                SharedPreferences.Editor editor  = someData.edit();
                editor.putString("sharedString",data);
                editor.commit();
                 break;

        }
    }
}

