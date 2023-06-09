package com.ram.e_commerceapp.features.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ram.e_commerceapp.R;
import com.ram.e_commerceapp.features.slider.IntroActivity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;

import android.view.Window;

import android.view.WindowManager;


public class SplashActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        Window window = getWindow() ;


        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);




        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(3000);

                    startActivity(new Intent(getApplicationContext(), IntroActivity.class));

                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }


                super.run();

            }

        };


        splashTread.start();





    }


}