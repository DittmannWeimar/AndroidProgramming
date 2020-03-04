package com.example.flingcolor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

import static android.graphics.Color.*;


public class Colorview extends View implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat detector;

    /*private final int[] colors = {
            BLACK,
            DKGRAY,
            GRAY,
            LTGRAY,
            WHITE,
            RED,
            GREEN,
            BLUE,
            YELLOW,
            CYAN,
            MAGENTA
    };

    private int colourIndexr; */

    public Colorview(Context context) {
        super(context);
    }

    public Colorview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
            });
        detector = new GestureDetectorCompat(getContext(), this);
    }

    public Colorview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Colorview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        /*if (velocityX > 0) {
            colourIndex--;
        } else if (velocityX < 0) {
            colourIndex++;
        }
        if (colourIndex >= colors.length) {
            colourIndex = colors.length -1;
        }
        if (colourIndex < 0) {
            colourIndex = 0;
        }
        invalidate();*/

            if(e1.getX()-e2.getX() < 0 && e1.getY() - e2.getY() < 0){
                this.setBackgroundColor(Color.BLUE);
            } else if(e1.getX()-e2.getX() < 0 && e1.getY() - e2.getY() > 0){
                this.setBackgroundColor(Color.RED);
            } else if(e1.getX()-e2.getX() > 0 && e1.getY() - e2.getY() < 0){
                this.setBackgroundColor(Color.GREEN);
            } else if(e1.getX()-e2.getX() > 0 && e1.getY() - e2.getY() > 0){
                this.setBackgroundColor(Color.YELLOW);
            }

        return true;
    }

    /*@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(colors[colourIndex]);
        p.setStyle(Paint.Style.FILL);
        canvas.drawPaint(p);

    }*/
}
