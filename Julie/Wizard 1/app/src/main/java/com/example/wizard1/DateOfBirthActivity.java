package com.example.wizard1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateOfBirthActivity extends AppCompatActivity {

    private String name;
    private String address;
    private String date = "hgbjbg";
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_of_birth);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");

        calendar = (CalendarView) findViewById(R.id.calendarId);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "." + (month+1) + "." + year;
            }
        });

        ((Button) findViewById(R.id.NextB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDateOfBirth();
            }
        });


        ((Button) findViewById(R.id.BackB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    public void enterDateOfBirth(){
        Intent intent = new Intent(this, SummaryActivity.class);



        intent.putExtra("name", name);
        intent.putExtra("address", address);
        intent.putExtra("date", date);

        startActivity(intent);

    }

    public void finishActivity(){
        finish();
    }
}
