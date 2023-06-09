package com.ram.e_commerceapp.features.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;
    @ColumnInfo (name = "username")
    private String username;
    @ColumnInfo( name = "mobileNumber")
    private Long mobileNumber;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String  password;

    public User(String username, Long mobileNumber, String email, String password) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
