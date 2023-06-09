package com.ram.e_commerceapp.features.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ram.e_commerceapp.HomeFragment;
import com.ram.e_commerceapp.R;

import java.util.ArrayList;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    // create the global variable;
    HomeFragment gameContext;
    ArrayList<ProductsPojo> arrayList;

    public ProductsAdapter(HomeFragment gameContext, ArrayList<ProductsPojo> arrayList) {
        this.gameContext = gameContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_home, parent, false);
        return new ViewHolder(view); // return the viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        holder.imageName.setImageResource(arrayList.get(position).Images);
        holder.productName.setText(arrayList.get(position).productName);
        holder.price.setText(arrayList.get(position).ProductPrice);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  static class  ViewHolder  extends RecyclerView.ViewHolder{
        ImageView imageName;
        TextView productName, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialize the  variable where images, name and location
            imageName = itemView.findViewById(R.id.imgContent);
            productName = itemView.findViewById(R.id.tvAppName);
            price = itemView.findViewById(R.id.tvAppStorage);
        }
        }
    }

