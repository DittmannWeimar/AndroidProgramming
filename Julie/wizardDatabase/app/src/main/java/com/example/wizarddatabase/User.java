package com.example.wizarddatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    public int userId;

    public String name;
    public String address;
    public String dateOfBirth;
}
