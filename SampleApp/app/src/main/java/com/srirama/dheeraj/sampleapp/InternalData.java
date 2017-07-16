package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by DHEERAJ on 22-06-2017.
 */
public class InternalData extends Activity implements View.OnClickListener {
    EditText ed1;
    TextView tv1;
    FileOutputStream fos;
    String  FILENAME = "InternalString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedprefs);
         intialize();
    }

    private void intialize(){
        Button bt1 = (Button)findViewById(R.id.load);
        Button bt2 = (Button)findViewById(R.id.save);
        ed1 = (EditText)findViewById(R.id.editText2);
        tv1 = (TextView)findViewById(R.id.textV1);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
       try {
           fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
           fos.close();
       }catch(FileNotFoundException e){
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.load:
               new loadSomeStuff().execute(FILENAME);
                break;
            case R.id.save:
                String data = ed1.getText().toString();
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

        }
    }

public class loadSomeStuff extends AsyncTask<String,Integer,String>{

    ProgressDialog dialog;

    protected void onPreExecute(){
       dialog =new ProgressDialog(InternalData.this);
       dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       dialog.setMax(100);
       dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String collected = null;
        FileInputStream fis = null;
        for(int i =0;i < 20;i++){
            publishProgress(5);

            try {
                Thread.sleep(88);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dialog.dismiss();
        try {
            fis  = openFileInput(FILENAME);
            byte[] dataArray = new byte[fis.available()];
            while (fis.read(dataArray) != -1){
                collected = new String(dataArray);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                return  collected;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected void onProgressUpdate(Integer...progress){
     dialog.incrementProgressBy(progress[0]);

    }

    protected void onPostExecute(String result){
        tv1.setText(result);
    }


}

}
