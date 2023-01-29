package com.abeer.workoutapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.abeer.workoutapp.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid = (:userId)")
    User loadAllByIds(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(User... users);

    @Delete
    void delete(User user);
}

