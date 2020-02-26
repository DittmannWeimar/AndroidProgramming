package sdu.androidprogrammering.gesturecolorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;
    private ColorChanger colorChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gesture listener instantiate
        mDetector = new GestureDetectorCompat(this,this);
        colorChanger = (ColorChanger) findViewById(R.id.background);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
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
        Log.i("MainActivity", "Flinged");

        if(e1.getX() - e2.getX() < 0 && e1.getY() - e2.getY() < 0){
            colorChange(1);
        }else if(e1.getX() - e2.getX() < 0 && e1.getY() - e2.getY() > 0){
            colorChange(2);
        }else if(e1.getX() - e2.getX() > 0 && e1.getY() - e2.getY() < 0){
            colorChange(3);
        }else if(e1.getX() - e2.getX() > 0 && e1.getY() - e2.getY() > 0){
            colorChange(4);
        }else{
            colorChange(0);
        }
        return true;
    }

    private void colorChange(int colorPick){
        switch(colorPick){
            case 1:
                colorChanger.setBackgroundColor(Color.RED);
                break;
            case 2:
                colorChanger.setBackgroundColor(Color.BLUE);
                break;
            case 3:
                colorChanger.setBackgroundColor(Color.GREEN);
                break;
            case 4:
                colorChanger.setBackgroundColor(Color.CYAN);
                break;
            default:
                colorChanger.setBackgroundColor(Color.BLACK);
                break;
        }
    }
}
