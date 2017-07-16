package com.srirama.dheeraj.sampleapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by DHEERAJ on 13-06-2017.
 */
public class Myview extends View {
    Bitmap gball;
    float changingY;
    Typeface font;
    public Myview(Context context) {
        super(context);
     gball= BitmapFactory.decodeResource(getResources(),R.drawable.green);
      font = Typeface.createFromAsset(context.getAssets(),"G-Unit.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint textpaint = new Paint();
        textpaint.setARGB(50,254,10,50);
        textpaint.setTextAlign(Paint.Align.CENTER);
        textpaint.setTextSize(50);
        textpaint.setTypeface(font);
        canvas.drawText("Dheeraj",canvas.getWidth()/2,200,textpaint);
        canvas.drawBitmap(gball, (canvas.getWidth() / 2), changingY, null);
        if (changingY < canvas.getHeight()){
            changingY += 10;
        }
        else{
            changingY =0;
        }
        Rect middleRect = new Rect();
        middleRect.set(0, 400, canvas.getWidth(), 550);
        Paint ourBlue = new Paint();
        ourBlue.setColor(Color.BLUE);
        canvas.drawRect(middleRect,ourBlue);
        invalidate();

    }
}
