package com.example.thepod.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.thepod.data.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addRun(User run);

    @Query("SELECT * FROM users")
    List<User> getAll();
}
