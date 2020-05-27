package com.example.clickcolorchange;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;


public class ColorChange extends View implements GestureDetector.OnGestureListener {
    private Paint circlePaint;
    private Paint borderPaint;
    private GestureDetectorCompat detector;
    private int topLeftColor = Color.RED;
    private int topRightColor = Color.GREEN;
    private int bottomLeftColor = Color.BLUE;
    private int bottomRightColor = Color.YELLOW;
    private Paint topLeftPaint;
    private Paint topRightPaint;
    private Paint bottomLeftPaint;
    private Paint bottomRightPaint;
    private Rect topLeftRect;
    private Rect topRightRect;
    private Rect bottomLeftRect;
    private Rect bottomRightRect;

    public ColorChange(Context context) {
        super(context);
    }

    public ColorChange(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.WHITE);
        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStrokeWidth(5f);

        detector = new GestureDetectorCompat(getContext(), this);
    }

    public ColorChange(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ColorChange(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        topLeftPaint = new Paint();
        topRightPaint = new Paint();
        bottomLeftPaint = new Paint();
        bottomRightPaint = new Paint();
        topLeftRect = new Rect(0,0, getWidth()/2,getHeight()/2);
        topRightRect = new Rect(getWidth()/2, 0, getWidth(), getHeight()/2);
        bottomLeftRect =  new Rect(0, getHeight()/2, getWidth()/2, getHeight());
        bottomRightRect = new Rect(getWidth()/2, getHeight()/2, getWidth(), getHeight());

        topLeftPaint.setStyle(Paint.Style.FILL);
        topLeftPaint.setColor(topLeftColor);
        topRightPaint.setStyle(Paint.Style.FILL);
        topRightPaint.setColor(topRightColor);
        bottomLeftPaint.setStyle(Paint.Style.FILL);
        bottomLeftPaint.setColor(bottomLeftColor);
        bottomRightPaint.setStyle(Paint.Style.FILL);
        bottomRightPaint.setColor(bottomRightColor);

        canvas.drawRect(topLeftRect, topLeftPaint);
        canvas.drawRect(topRightRect, topRightPaint);
        canvas.drawRect(bottomLeftRect, bottomLeftPaint);
        canvas.drawRect(bottomRightRect,bottomRightPaint);

        canvas.drawRect(topLeftRect, borderPaint);
        canvas.drawRect(topRightRect, borderPaint);
        canvas.drawRect(bottomLeftRect, borderPaint);
        canvas.drawRect(bottomRightRect, borderPaint);

        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()*0.1f, circlePaint);
        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()*0.1f, borderPaint);
    }

    public boolean onTouchEvent(MotionEvent event){
        if (this.detector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
    //Hej

    @Override
    public boolean onDown(MotionEvent e) {
        int halfWidth = getWidth()/2;
        int halfHeight =  getHeight()/2;

        if (e.getX() <= halfWidth && e.getY() <= halfHeight){
            circlePaint.setColor(topLeftColor);
        } else if (e.getX() > halfWidth && e.getY() <= halfHeight){
            circlePaint.setColor(topRightColor);
        } else if (e.getX() <= halfWidth && e.getY() > halfHeight){
            circlePaint.setColor(bottomLeftColor);
        } else if (e.getX() > halfWidth && e.getY() > halfHeight){
            circlePaint.setColor(bottomRightColor);
        }
        invalidate();
        return true;
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
        return false;
    }
}
