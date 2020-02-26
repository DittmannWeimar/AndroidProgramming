package sdu.androidprogrammering.wizardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAllInformation extends AppCompatActivity {

    private String name;
    private String address;
    private String birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_information);

        Intent intent = getIntent();
        name = "Name: \t \t" + intent.getStringExtra("userName");
        address = "Address: \t \t" + intent.getStringExtra("addressOfUser");
        birthday = "Day of birth: \t \t" + intent.getStringExtra("dateOfBirth");
        TextView nameDisplay = findViewById(R.id.displayName);
        nameDisplay.setText(name);
        TextView addressDisplay = findViewById(R.id.displayAddress);
        addressDisplay.setText(address);
        TextView dayOfBirthDisplay = findViewById(R.id.displayDayOfBirth);
        dayOfBirthDisplay.setText(birthday);
    }
}
