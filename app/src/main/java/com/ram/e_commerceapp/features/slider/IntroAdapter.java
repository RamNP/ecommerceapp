package com.ram.e_commerceapp.features.slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.e_commerceapp.R;

public class IntroAdapter extends PagerAdapter {

    Context context;



    int [] images={
             R.drawable.men,
            R.drawable.intro,
            R.drawable.intro2,

    };
    int []  Tittle={
            R.string.tv_welcome,
            R.string.tv_welcome,
            R.string.tv_welcome,

    };
    int[] desc={

            R.string.tv_desc_first,
            R.string.tv_desc_second,
            R.string.tv_desc_third
    };
    public IntroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View view = LayoutInflater.from(context).inflate(R.layout.intro_layout, container, false);
           ImageView introImage =  view.findViewById(R.id.ivMean);
          TextView tvTittle = view.findViewById(R.id.tvTittle);
          TextView tvDescription = view.findViewById(R.id.tvDesc);


        // set the image and text for next slider page
        introImage.setImageResource(images[position]);
        tvDescription.setText(desc[position]);
        tvTittle.setText(Tittle[position]);
        container.addView(view);
        return view;
    }

    // this methods can destroy item when complete the items
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){
        container.removeView((LinearLayout) object);
    }
}
