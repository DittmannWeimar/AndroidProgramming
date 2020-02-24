package com.example.wizard1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.NextB)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               enterName();
            }
        });

    }

    public void enterName(){

        EditText nameText = (EditText) findViewById(R.id.nameId);
        if (!TextUtils.isEmpty(nameText.getText())){
            Intent intent = new Intent(this, AddressActivity.class);
            String name = nameText.getText().toString();
            intent.putExtra("name", name);
            startActivity(intent);
        }

    }
    
}
