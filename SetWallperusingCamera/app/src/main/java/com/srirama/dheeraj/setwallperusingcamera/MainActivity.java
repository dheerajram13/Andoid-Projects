package com.srirama.dheeraj.setwallperusingcamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton ib;
    ImageView iv;
    Button but;
    final static int cameraData =0;
    Intent i;
    Bitmap  bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialize();
        InputStream is = getResources().openRawResource(R.drawable.im);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void intialize(){
        iv = (ImageView)findViewById(R.id.ivReturnPic);
        ib= (ImageButton)findViewById(R.id.ibTakepic);
        but = (Button)findViewById(R.id.setWallpaper);
        but.setOnClickListener(this);
        ib.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.setWallpaper:
                try {
                    getApplicationContext().setWallpaper(bmp);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                break;

            case R.id.ibTakepic:
                i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}






