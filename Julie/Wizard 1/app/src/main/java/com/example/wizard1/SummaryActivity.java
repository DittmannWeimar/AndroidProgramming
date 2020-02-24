package com.example.wizard1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

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
}
