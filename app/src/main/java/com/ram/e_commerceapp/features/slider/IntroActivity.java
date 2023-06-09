package com.ram.e_commerceapp.features.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ram.e_commerceapp.R;
import com.ram.e_commerceapp.features.Login.LoginActivity;

public class IntroActivity extends AppCompatActivity {
     ViewPager viewPager;
     LinearLayout linearLayout;
     Button btnBack , btnNext ;
      IntroAdapter introAdapter;
    TextView[] dots;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        btnBack.setVisibility(View.INVISIBLE);

    SharedPreferences sharedPreferences = getSharedPreferences("SelfPrefs", MODE_PRIVATE);
    boolean hasViewedSlider = sharedPreferences.getBoolean("has_viewed_slider", false);
        if (hasViewedSlider) {
        startActivity(new Intent(IntroActivity.this, LoginActivity.class));
        finish();
    } else {
        // Show the slider screen
        // skip button


        // back button
        btnBack.setOnClickListener(v -> {
            if (getItem(0)>0){
                viewPager.setCurrentItem(getItem(-1), true);
            }
        });

        // next button
        btnNext.setOnClickListener(v -> {
            if (getItem(0)<2){
                viewPager.setCurrentItem(getItem(1), true);
            } else {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
                finish();
            }
        });

        // initialize the mSliderViewPager and mDotLayout
            viewPager = findViewById(R.id.rvIntro);
//            linearLayout = findViewById(R.id.indicator_layout);
        // create an object of sliderAdapter and call the setAdapter methods
            introAdapter = new IntroAdapter(this);
            viewPager.setAdapter(introAdapter);



        // Save the preference to indicate that the user has viewed the slider screen
        editor = sharedPreferences.edit();
        editor.putBoolean("has_viewed_slider", true);
        editor.apply();
    }
}

//    public void setUpIndicator(int position){
//        dots = new TextView[3];
//        linearLayout.removeAllViews();
//
//        // using the for loop
//        for (int i=0; i<dots.length; i++){
//            dots[i] = new TextView(this);
//            dots[i].setText("\u2022");
//            dots[i].setTextSize(35);
//            dots[i].setTextColor(getResources().getColor(R.color.black, getApplicationContext().getTheme()));
//            linearLayout.addView(dots[i]);
//        }
//        // setTextColor for slider position
//        dots[position].setTextColor(getResources().getColor(R.color.white, getApplicationContext().getTheme()));
//    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // Do something while the user is scrolling through the ViewPager
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onPageSelected(int position) {
//            setUpIndicator(position);
            if(position>0){
                btnBack.setVisibility(View.VISIBLE);
            } else {
                btnBack.setVisibility(View.INVISIBLE);
            }
            if(position==2) {
                btnNext.setText("Start");
            } else {
                btnNext.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private  int getItem(int item){
        return viewPager.getCurrentItem()+item;
    }
}