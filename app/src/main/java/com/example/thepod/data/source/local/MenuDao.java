package com.example.thepod.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MenuDao {

    @Insert
    void insert(Menu foodItem);

    @Update
    void update(Menu foodItem);

    @Delete
    void delete(Menu foodItem);

    @Query("SELECT * FROM menu_table ")
    LiveData<List<Menu>> getAllFoodItems();

}