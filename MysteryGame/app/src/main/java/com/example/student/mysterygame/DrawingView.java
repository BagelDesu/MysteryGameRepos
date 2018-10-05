package com.example.student.mysterygame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class DrawingView extends View
{
    //colors
    Paint pink = new Paint();
    Paint purple = new Paint();


    public float x = 0;
    public float y = 0;

    public void setX(float newx) { x = newx;}
    public void setY(float newy) {y = newy;}
    public float moveCircleX () {return x;}
    public float moveCircleY () {return y;}






    public DrawingView (Context context, AttributeSet attr)
    {

        super(context,attr);
        pink.setColor(Color.parseColor("#FFC56486"));
        purple.setColor(Color.parseColor("#FF9C60B8"));
        purple.setStyle(Paint.Style.STROKE);
        purple.setStrokeWidth(15);

    }

    @Override
    public boolean onTouchEvent (MotionEvent event)
    {
        x = event.getX();
        y = event.getY();

        invalidate();
        return true;


    }

    @Override
    protected void onDraw(Canvas canvas)
    {
       float targetX = this.getWidth()/2;
       float targetY = this.getHeight()/2;
       canvas.drawCircle(targetX,targetY, 150,purple); // the target

       canvas.drawCircle(x,y,30,pink); //tilt ball

    }
}
