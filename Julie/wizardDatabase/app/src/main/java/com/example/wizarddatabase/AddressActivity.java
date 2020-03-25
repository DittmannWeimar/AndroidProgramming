package com.example.wizarddatabase;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends BaseActivity {

    private String name;
    private String activity = "Address_Activity";
    EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Log.i("onCreate", activity);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        addressText = (EditText) findViewById(R.id.addressId);

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

        if(!TextUtils.isEmpty(currentUser.address)){
            addressText.setText(currentUser.address);
        }
    }

    private void enterAddress(){

        if (!TextUtils.isEmpty(addressText.getText())){
            Intent intent = new Intent(this, DateOfBirthActivity.class);
            String address = addressText.getText().toString();
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            currentUser.address = address;
            db.userDao().update(currentUser);
            startActivity(intent);
        }


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