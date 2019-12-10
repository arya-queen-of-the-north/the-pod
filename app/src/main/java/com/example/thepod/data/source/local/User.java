package com.example.thepod.data.source.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String firstName;

    @ColumnInfo
    public String lastName;

    @ColumnInfo()
    public String email;
    
    @ColumnInfo()
    public String password;

    @ColumnInfo()
    public String confirmPassword;
}
