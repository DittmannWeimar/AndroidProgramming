package sdu.androidprogrammering.imageswapper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int imageIndex;
    ArrayList<Bitmap> images = new ArrayList<>();
    ImageView midView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.nextButton).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeToImageNext();
                }
            }
        );

        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.midimage));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.havealike));

        midView = findViewById(R.id.midImageView);
        imageIndex = 0;
        setImage();
    }

    public void changeToImageNext(){
        if(imageIndex < images.size()-1){
            imageIndex++;
        }else{
            imageIndex = 0;
        }
        setImage();
    }

    private void setImage(){
        midView.setImageBitmap(images.get(imageIndex));
    }
}
