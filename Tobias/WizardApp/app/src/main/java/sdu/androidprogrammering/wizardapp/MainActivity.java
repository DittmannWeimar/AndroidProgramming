package sdu.androidprogrammering.wizardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendName(View view){
        Intent intent = new Intent(this, AddressInput.class);
        EditText editText = (EditText) findViewById(R.id.nameInput);
        String userName = editText.getText().toString();
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}
