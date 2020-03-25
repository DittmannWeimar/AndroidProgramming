package com.example.wizarddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateOfBirthActivity extends BaseActivity {

    private String name;
    private String address;
    private String date = "hgbjbg";
    CalendarView calendarView;
    private String activity = "Date_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_of_birth);
        Log.i("onCreate", activity);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        address = intent.getStringExtra("address");

        calendarView = (CalendarView) findViewById(R.id.calendarId);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month+1) + "/" + year;
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

        if (!currentUser.dateOfBirth.equalsIgnoreCase("")){
            String birthDate = currentUser.dateOfBirth;
            String parts[] = birthDate.split("/");

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month-1);
            calendar.set(Calendar.DAY_OF_MONTH, day);

            long milliTime = calendar.getTimeInMillis();
            calendarView.setDate(milliTime, true, true);
            date = currentUser.dateOfBirth;
        }
    }

    public void enterDateOfBirth(){
        Intent intent = new Intent(this, SummaryActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("address", address);
        intent.putExtra("date", date);
        currentUser.dateOfBirth = date;
        db.userDao().update(currentUser);
        startActivity(intent);

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