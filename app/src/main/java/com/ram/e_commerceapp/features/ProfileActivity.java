package com.ram.e_commerceapp.features;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_commerceapp.R;
import com.ram.e_commerceapp.features.Login.LoginActivity;
import com.ram.e_commerceapp.features.Login.SignupActivity;
import com.ram.e_commerceapp.features.post.CategoriesActivity;

public class ProfileActivity extends AppCompatActivity {

    private Button  btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button button = findViewById(R.id.btnGo);
        btnInfo = findViewById(R.id.btnInfo);
         btnInfo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Dialog cust_message = new Dialog(ProfileActivity.this);
                 cust_message.setContentView(R.layout.custom_personalinfo_layout);
                 cust_message.setCancelable(true);
                 cust_message.show();

             }
         });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
    }
}