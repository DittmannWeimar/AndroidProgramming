package sdu.androidprogrammering.wizardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressInput extends AppCompatActivity {

    private String nameOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_input);

        Intent intent = getIntent();
        nameOfUser = intent.getStringExtra("userName");

        ((Button) findViewById(R.id.nextButtonAddress)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAddressAndName();
            }
        });
    }

    private void sendAddressAndName(){
        Intent intent = new Intent(this, DateOfBirth.class);
        EditText addressInput = (EditText) findViewById(R.id.addressInput);
        String address = addressInput.getText().toString();
        intent.putExtra("userName", nameOfUser);
        intent.putExtra("addressOfUser", address);
        startActivity(intent);
    }
}
