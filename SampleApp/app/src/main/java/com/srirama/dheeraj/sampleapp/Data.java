package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DHEERAJ on 09-06-2017.
 */
public class Data extends Activity implements View.OnClickListener {
    EditText edit1;
    TextView tv1;
    Button butt1,butt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        intialize();
    }

    private void intialize(){
        edit1 = (EditText)findViewById(R.id.edText);
        tv1 = (TextView)findViewById(R.id.tvView);
        butt1 =(Button)findViewById(R.id.button1);
        butt2 =(Button)findViewById(R.id.button2);
        butt1.setOnClickListener(this);
        butt2.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
              String bread = edit1.getText().toString();
              Bundle basket = new Bundle();
                basket.putString("key",bread);
                Intent in = new Intent(Data.this,OpenedClass.class);
                in.putExtras(basket);
                startActivity(in);
                break;
            case R.id.button2:
                Intent i = new Intent(Data.this,OpenedClass.class);
                startActivityForResult(i,0);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle basket = data.getExtras();
            String s = basket.getString("answer");
            tv1.setText(s);
        }

    }
}
