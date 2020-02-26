package com.example.flingcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity /*implements GestureDetector.OnGestureListener*/{

    private GestureDetectorCompat detector;
    Colorview colorview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*colorview = (Colorview) findViewById(R.id.backGroundColorView);
        detector = new GestureDetectorCompat(this, this);*/

    }
/*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.detector.onTouchEvent(event)){
            return true;
        }

        return super.onTouchEvent(event);
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
        changeColorOne(e1, e2);
        return true;

    }

    private void changeColorOne(MotionEvent e1, MotionEvent e2){
        if(e1.getX()-e2.getX() < 0 && e1.getY() - e2.getY() < 0){
            colorview.setBackgroundColor(Color.BLUE);
        } else if(e1.getX()-e2.getX() < 0 && e1.getY() - e2.getY() > 0){
            colorview.setBackgroundColor(Color.RED);
        } else if(e1.getX()-e2.getX() > 0 && e1.getY() - e2.getY() < 0){
            colorview.setBackgroundColor(Color.GREEN);
        } else if(e1.getX()-e2.getX() > 0 && e1.getY() - e2.getY() > 0){
            colorview.setBackgroundColor(Color.YELLOW);
        }
    } */

}
