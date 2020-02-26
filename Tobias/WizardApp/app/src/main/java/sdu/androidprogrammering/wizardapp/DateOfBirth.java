package sdu.androidprogrammering.wizardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class DateOfBirth extends AppCompatActivity {

    CalendarView calendar;
    private String fullBirthDay;
    private String nameOfUser;
    private String addressOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_of_birth);

        Intent intent = getIntent();
        nameOfUser = intent.getStringExtra("userName");
        addressOfUser = intent.getStringExtra("addressOfUser");

        calendar = (CalendarView)findViewById(R.id.calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                fullBirthDay = dayOfMonth + "." + (month+1) + "." + year;
                Log.i("DateOfBirth", fullBirthDay);
            }
        });

        ((Button) findViewById(R.id.nextDateButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAllInformation();
            }
        });
    }

    private void sendAllInformation(){
        Intent intent = new Intent(this, DisplayAllInformation.class);
        intent.putExtra("userName", nameOfUser);
        intent.putExtra("addressOfUser", addressOfUser);
        Log.i("sendAllInformation", fullBirthDay);
        intent.putExtra("dateOfBirth", fullBirthDay);
        startActivity(intent);
    }
}
