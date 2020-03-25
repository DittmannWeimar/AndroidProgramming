package com.example.wizarddatabase;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    protected  AppDatabase db;
    protected User currentUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getDatabase(this);
        if(db.userDao().countUsers() == 0){
            currentUser = new User();
            currentUser.userId = 1;
            currentUser.address = "";
            currentUser.dateOfBirth = "";
            currentUser.name = "";
            db.userDao().insert(currentUser);
        }
        else{
            currentUser = db.userDao().getUser();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
