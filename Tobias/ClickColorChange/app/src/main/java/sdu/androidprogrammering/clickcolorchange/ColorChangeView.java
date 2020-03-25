package sdu.androidprogrammering.clickcolorchange;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class ColorChangeView extends View implements GestureDetector.OnGestureListener {

    Paint circle = new Paint();
    private int top_left_rect_color = Color.RED;
    private int top_right_rect_color = Color.GREEN;
    private int bottom_left_rect_color = Color.BLUE;
    private int bottom_right_rect_color = Color.YELLOW;

    public ColorChangeView(Context context) {
        super(context);
    }

    public ColorChangeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ColorChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        return false;
    }

    @Override
    public void onDraw(Canvas canvas){

    }
}
