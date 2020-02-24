package com.example.wizard1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        ((Button) findViewById(R.id.NextB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterAddress();
            }
        });

        ((Button) findViewById(R.id.BackB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    private void enterAddress(){

        EditText addressText = (EditText) findViewById(R.id.addressId);

        if (!TextUtils.isEmpty(addressText.getText())){
            Intent intent = new Intent(this, DateOfBirthActivity.class);
            String address = addressText.getText().toString();
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            startActivity(intent);
        }


    }

    public void finishActivity(){
        finish();
    }
}
