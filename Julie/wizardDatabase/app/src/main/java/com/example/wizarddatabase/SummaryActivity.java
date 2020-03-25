package com.example.wizarddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private String activity = "Summary_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Log.i("onCreate", activity);

        Intent intent = getIntent();

        TextView nameField = (TextView) findViewById(R.id.nameField);
        TextView addressField = (TextView) findViewById(R.id.addressField);
        TextView dateField = (TextView) findViewById(R.id.dateField);

        nameField.setText(intent.getStringExtra("name"));
        addressField.setText(intent.getStringExtra("address"));
        dateField.setText(intent.getStringExtra("date"));

        ((Button) findViewById(R.id.BackB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });

    }

    public void finishActivity(){
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", activity);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", activity);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop" , activity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i( "onDestroy", activity);
    }
}