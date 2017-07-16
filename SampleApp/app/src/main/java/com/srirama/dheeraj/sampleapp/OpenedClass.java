package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by DHEERAJ on 09-06-2017.
 */
public class OpenedClass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {
   TextView question,te1;
    Button retData;
    RadioGroup selection;
    String gotBread,setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
       intialize();
       // Bundle gotBasket = getIntent().getExtras();
      // gotBread = gotBasket.getString("key");
       //question.setText(gotBread);
    }


    private void intialize(){
        question = (TextView)findViewById(R.id.tvQue);
         te1 = (TextView)findViewById(R.id.tvText);
        retData = (Button)findViewById(R.id.send);
        selection =(RadioGroup)findViewById(R.id.rgAns);
        retData.setOnClickListener(this);
        selection.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View view) {
          Intent person =  new Intent();
           Bundle backpack = new Bundle();
           backpack.putString("answer",setData);
          person.putExtras(backpack);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radio1:
                setData = "Probably right!";
                break;
            case R.id.radio2:
                setData = " Definitely  right!";
                break;
            case R.id.radio3:
                setData =  " You are right! ";
                break;
        }
          te1.setText(setData);
    }
}
