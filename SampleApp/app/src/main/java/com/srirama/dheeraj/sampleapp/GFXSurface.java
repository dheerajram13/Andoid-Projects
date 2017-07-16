package com.srirama.dheeraj.sampleapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by DHEERAJ on 14-06-2017.
 */
public class GFXSurface extends Activity implements View.OnTouchListener{// implementing the ontouchlistener
    MySurface ourSurface;     // create a class
    float x,y,sX,sY,fX,fY,dX,dY,aniX,aniY,scaledX,scaledY;   // declare the float variables
    Bitmap test, irm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurface = new MySurface(this); //constructor for the class we have declared at the begining of the program
        ourSurface.setOnTouchListener(this);
        x = 0;      //intialize the x and y to 0
        y = 0;
        sX = 0;      //intialize the sx and sy to 0
        sY = 0;
        fX = 0;      //intialize the fx and fy to 0
        fY = 0;

        test = BitmapFactory.decodeResource(getResources(),R.drawable.sam);
        irm = BitmapFactory.decodeResource(getResources(),R.drawable.irm);
        setContentView(ourSurface);
    }

    @Override
    protected void onPause() {
        super.onPause();               //this is the onPause method which is sub of the pause method in the class created
       ourSurface.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();           //this is the onResume method which is sub of the resume method in the class created
        ourSurface.resume();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
       try{
             Thread.sleep(50);
        } catch (InterruptedException e) {
           e.printStackTrace();
       }

        x = event.getX();      //this is for geting the postion of x and y when touched
        y = event.getY();
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               sX = event.getX();
               sY = event.getY();
               dX = dY = aniX = aniY = scaledX = scaledY = fY = fX =  0;
                 break;
           case  MotionEvent.ACTION_UP:
               fX = event.getX();
               fY = event.getY();
               dX = fX - sX;
               dY = fY - sY;
               scaledX = dX/30;
               scaledY = dY/30;
               x=y=0;
               break;


       }
        return true;
    }
    public class MySurface  extends SurfaceView implements Runnable{

        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = true;
        public MySurface(Context context) {
            super(context);
            ourHolder = getHolder();

        }
        public void pause(){
            isRunning = false;
            while (true){
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread = null;
        }
        public void resume(){
            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }
        public void run() {
            while (isRunning){
                if (!ourHolder.getSurface().isValid()) {
                    continue;
                }
                Canvas canvas =  ourHolder.lockCanvas();
                canvas.drawRGB(02, 02, 130);
                if (x!=0 && y!=0){
                    canvas.drawBitmap(test,x-(test.getWidth()/2),y-(test.getHeight()/2),null);
                }
                if (sX!=0 && sY !=0){
                    canvas.drawBitmap(irm,sX-(irm.getWidth()/2),sY-(irm.getHeight()/2),null);
                }
                if (sX!=0 && fY!=0){
                    canvas.drawBitmap(test,fX-(test.getWidth()/2)-aniX,fY-(test.getHeight()/2)-aniY,null);
                    canvas.drawBitmap(irm,fX-(irm.getWidth()/2),fY-(irm.getHeight()/2),null);
                }
                ourHolder.unlockCanvasAndPost(canvas);
            }
            aniX = aniX + scaledX;
            aniY = aniY +scaledY;
        }
    }


}
