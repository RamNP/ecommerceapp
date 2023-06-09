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


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    // create the global variable;
    HomeFragment gameContext;
    ArrayList<ProductPojo> arrAppContacts;

    public ProductAdapter(HomeFragment gameContext, ArrayList<ProductPojo> arrAppContacts) {
        this.gameContext = gameContext;
        this.arrAppContacts = arrAppContacts;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_home, parent, false);
        return new ViewHolder(view); // return the viewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrAppContacts.get(position).images);
        holder.tvAppName.setText(arrAppContacts.get(position).productName);
        holder.tvAppStorage.setText(arrAppContacts.get(position).productAmount);

    }

    @Override
    public int getItemCount() {
        return arrAppContacts.size();
    }

    public  static class  ViewHolder  extends RecyclerView.ViewHolder{
        ImageView imgContact;
        TextView tvAppName, tvAppStorage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initialize the  variable where images, name and location
            imgContact = itemView.findViewById(R.id.imgContent);
            tvAppName = itemView.findViewById(R.id.tvAppName);
            tvAppStorage = itemView.findViewById(R.id.tvAppStorage);
        }
        }
    }

