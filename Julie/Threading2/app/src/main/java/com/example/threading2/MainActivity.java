package com.example.threading2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;

    Thread workingThread;
    volatile boolean running = true;

    final String url = "http://api.icndb.com/";

    Retrofit retrofit;

    JokeService jokeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher = findViewById(R.id.joke_holder);
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);


        retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jokeService = retrofit.create(JokeService.class);

        //Create a thread
        workingThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (running) {

                    Call<Joke> joke = jokeService.randomJoke();
                    try {

                        final Joke current_joke = joke.execute().body();
                        final String joke_txt = Html.fromHtml(current_joke.getValue().getJoke()).toString();


                        textSwitcher.post(new Runnable() {
                            @Override
                            public void run() {
                                textSwitcher.setText(joke_txt);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //start the thread
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

}
