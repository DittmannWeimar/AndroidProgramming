package com.example.wizarddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private String activity = "Name_Activity";
    private EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate", activity);

        nameText = findViewById(R.id.nameId);

        ((Button) findViewById(R.id.NextB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterName();
            }
        });

        if(!TextUtils.isEmpty(currentUser.name)){
            nameText.setText(currentUser.name);
        }

    }

    public void enterName(){

        if (!TextUtils.isEmpty(nameText.getText())){
            Intent intent = new Intent(this, AddressActivity.class);
            String name = nameText.getText().toString();
            intent.putExtra("name", name);
            Log.i("name", name);
            currentUser.name = name;
            db.userDao().update(currentUser);
            startActivity(intent);
        }

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