package com.ram.e_commerceapp.features.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class,exportSchema = false , version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final  String DB_Name = "AppDatabase";

    private static  DatabaseHelper instance;

    public  static synchronized  DatabaseHelper getInstance(Context context){
        if(instance == null){
           instance = Room.databaseBuilder(context ,DatabaseHelper.class,DB_Name)
                   .fallbackToDestructiveMigration()
                   .allowMainThreadQueries()
                   .build();
        }

        return  instance;
    }
     public  abstract UserDao userDao();
}
