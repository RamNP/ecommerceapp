package com.ram.e_commerceapp.features.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<User> users);

    @Query("SELECT EXISTS(SELECT * FROM user where username LIKE :userName AND password LIKE :Password)")
    boolean getUserByName(String userName, String Password);

}
