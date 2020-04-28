package com.example.jokeservice1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Html;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeAndroidService extends Service {

    private final JokeAndroidServiceBinder binder = new JokeAndroidServiceBinder();
    private Thread workingThread;
    private volatile boolean running;
    private JokeWebService jokeWebService;
    private int jokeCounter;
    private String newJoke;
    private final String url = "http://api.icndb.com/";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("service_exrecise", "JokeAndroidService onBind- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        return binder;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("service_exrecise", "JokeAndroidService onCreate- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jokeCounter = 0;
        running = true;
        jokeWebService = retrofit.create(JokeWebService.class);

        //Create a thread
        workingThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (running) {

                    Call<Joke> joke = jokeWebService.randomJoke();
                    try {

                        Joke current_joke = joke.execute().body();
                        newJoke = Html.fromHtml(current_joke.getValue().getJoke()).toString();
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

    public void onDestroy(){

        Log.i("service_exrecise", "JokeAndroidService onDestroy- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        running = false;

        try {
            workingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.onDestroy();
    }

    public class JokeAndroidServiceBinder extends Binder {

        JokeAndroidService getService(){
            return JokeAndroidService.this;
        }

    }

    public int getJokeCounter() {
        return jokeCounter;
    }

    public String getNewJoke() {
        return newJoke;
    }
}
