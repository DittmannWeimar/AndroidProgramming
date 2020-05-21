package com.example.jokeservice1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    TextView jokeCounttv;

    protected JokeAndroidService jokeAndroidService;
    protected boolean mBound;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, JokeAndroidService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    protected void initViews() {
        textSwitcher = findViewById(R.id.joke_holder);
        jokeCounttv = findViewById(R.id.jokeCounter);
        textSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        textSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        findViewById(R.id.UpdateCounterB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    jokeCounttv.setText(String.valueOf(jokeAndroidService.getJokeCounter()));
                }
            }
        });
        findViewById(R.id.UpdateJokeB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBound) {
                    textSwitcher.setText(jokeAndroidService.getNewJoke());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.i("service_exrecise",  "ServiceConnection onServiceConnected- Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());

            // We've bound to LocalService, cast the IBinder and get LocalService instance
            JokeAndroidService.JokeAndroidServiceBinder binder = (JokeAndroidService.JokeAndroidServiceBinder) service;
            jokeAndroidService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };


   public void updateJokeCounter(){
       if (mBound){
           textSwitcher.setText(String.valueOf(jokeAndroidService.getJokeCounter()));
       }
   }

    public void updateJokeClicked(){
        if(mBound){
            textSwitcher.setText(jokeAndroidService.getNewJoke());
        }
    }
}
