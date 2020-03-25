package com.example.threading1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextSwitcher;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    Thread workingThread;

    volatile boolean running = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = findViewById(R.id.joke_holder);

        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        workingThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (running) {
                    final String randomString = random();

                    textSwitcher.post(new Runnable() {
                        @Override
                        public void run() {
                            textSwitcher.setText(randomString);
                        }
                    });


                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        workingThread.start();
    }

    @Override
    protected void onDestroy(){
        running = false;
        super.onDestroy();
        try {
            workingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String random(){
        Random generator = new Random();
        StringBuilder randomString = new StringBuilder();
        int randomLength = generator.nextInt(100);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomString.append(tempChar);
        }
        return randomString.toString();
    }
}
