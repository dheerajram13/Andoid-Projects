package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by DHEERAJ on 27-06-2017.
 */
public class SQLite extends Activity implements View.OnClickListener {

   Button sqlUpdate,sqlView;
   EditText sqlName,sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.sqllite);
         sqlUpdate = (Button)findViewById(R.id.sqlUpdate);
         sqlView = (Button)findViewById(R.id.sqlView);
         sqlName = (EditText)findViewById(R.id.sqlName);
        sqlHotness = (EditText)findViewById(R.id.sqlHotness);
        sqlUpdate.setOnClickListener(this);
        sqlView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sqlUpdate:
                boolean didItWork = true;
            try {
                String name = sqlName.getText().toString();
                String hotness = sqlHotness.getText().toString();

                HotOrNot entry = new HotOrNot(SQLite.this);
                entry.open();
                entry.createEntry(name, hotness);
                entry.close();
            }catch (Exception e){
                didItWork = false;
                String error = e.toString();
                Dialog di = new Dialog(this);
                di.setTitle("Dang it!");
                TextView tv = new TextView(this);
                tv.setText(error);
                di.setContentView(tv);
                di.show();

            }finally {
                if(didItWork){
                    Dialog di = new Dialog(this);
                    di.setTitle("Heck yaa!");
                    TextView tv = new TextView(this);
                    tv.setText("Success");
                    di.setContentView(tv);
                    di.show();
                }
            }

                break;

            case R.id.sqlView:
              Intent intent = new Intent("com.srirama.dheeraj.sampleapp.SQLView");
                startActivity(intent);
                break;
        }

    }
}
