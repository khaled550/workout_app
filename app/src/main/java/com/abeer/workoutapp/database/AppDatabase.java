package com.abeer.workoutapp.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abeer.workoutapp.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    //private Context context;

    public static AppDatabase createDatabase(Context context){
        //this.context = context;
        Log.d(AppDatabase.class.getSimpleName(), "Creating new database instance");
        return Room.databaseBuilder(context,
                AppDatabase.class, "AppDB").allowMainThreadQueries().build();
    }

    public static UserDao dbUtils(Context context){
        return createDatabase(context).userDao();
    }
}
