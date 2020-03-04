package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Bitmap> images = new ArrayList<>();
    private int imageIndex;
    private int arrayAmountIndex;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        loadImages();

        ((Button) findViewById(R.id.next)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                nextImage();
            }
        });

        ((Button) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                previousImage();
            }
        });
    }

    private void loadImages(){
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_62592));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_210723));
        images.add(BitmapFactory.decodeResource(getResources(), R.drawable.pexels_photo_462353));
        arrayAmountIndex = images.size()-1;
        setImage();
    }

    private void setImage(){
        imageView.setImageBitmap(images.get(imageIndex));
    }

    private void nextImage(){
        if (imageIndex >= arrayAmountIndex){
            imageIndex = 0;
        } else {
            imageIndex++;
        }

        setImage();
    }

    private void previousImage(){
        if (imageIndex <= 0){
            imageIndex = arrayAmountIndex;
        } else {
            imageIndex--;
        }

        setImage();
    }
}
