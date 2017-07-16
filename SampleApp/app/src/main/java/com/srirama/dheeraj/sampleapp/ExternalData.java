package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by DHEERAJ on 22-06-2017.
 */
public class ExternalData extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private TextView canWrite,canRead;
    private String state;
    boolean canR,canW;
    Spinner spinner;
    String[] paths = {"Music","Pictures","Downloads"};
    File path = null;
    File file = null;
    EditText saveFile;
    Button confirm,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        canWrite = (TextView) findViewById(R.id.write);
        canRead = (TextView) findViewById(R.id.read);
        confirm = (Button) findViewById(R.id.confirm);
        save = (Button) findViewById(R.id.saveFile);
        saveFile = (EditText)findViewById(R.id.etSave);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);
        state = Environment.getExternalStorageState();
        checkstate();

    }
    private void checkstate() {
        if(state.equals(Environment.MEDIA_MOUNTED)){
            canRead.setText("true");
            canWrite.setText("true");
            canW = canR = true;
        }else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            canRead.setText("true");
            canWrite.setText("false");
            canW = false;
            canR = true;
        }else{
            canRead.setText("false");
            canWrite.setText("false");
            canW = canR = false;
        }
        spinner =(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = spinner.getSelectedItemPosition();
                switch(position){
                    case 0:
                      path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                        break;
                    case 1:
                        path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        break;
                    case 2:
                        path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                        break;
                }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveFile:
             String eft = saveFile.getText().toString();
                file = new File(path,eft + ".png");
                checkstate();

                if (canW == canR == true){

                    path.mkdirs();
                    try {
                        InputStream is = getResources().openRawResource(R.drawable.green);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();
                        Toast tot = Toast.makeText(ExternalData.this,"File has been saved",Toast.LENGTH_LONG);
                        tot.show();
                      /*  MediaScannerConnection.scanFile(ExternalData.this, new String[] {file.toString(), null, new MediaScannerConnection.OnScanCompletedListener() {
                            public void onScanCompleted(String s, Uri uri) {
                               Toast to ;
                                to.makeText(ExternalData.this, "Scan Completed", Toast.LENGTH_SHORT);
                              to.show();
                            }
                        }});*/

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case R.id.confirm:
             save.setVisibility(View.VISIBLE);
                break;
        }


    }
}
