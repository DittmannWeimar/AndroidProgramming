package com.example.wizarddatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE userId = 1")
    User getUser();

    @Update
    int update(User user);

    @Insert
    void insert(User user);

    @Query("SELECT COUNT(*) from user")
    int countUsers();
}
