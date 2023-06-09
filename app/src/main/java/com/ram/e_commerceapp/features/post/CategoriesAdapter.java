package com.ram.e_commerceapp.features.post;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ram.e_commerceapp.R;
import com.ram.e_commerceapp.features.post.helper.CategoryListItem;
import com.ram.e_commerceapp.features.post.helper.ImagePojo;
import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context context;
    List<CategoryListItem> resultLists;
    List<ImagePojo> imagePojosList;
    public CategoriesAdapter(Context context, List<CategoryListItem> resultLists, List<ImagePojo> imagePojosList) {
        this.context = context;
        this.resultLists = resultLists;
        this.imagePojosList = imagePojosList;
        Log.d("adapterBug", "constructor call ");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("adapterBug", "onCreateViewHolder call ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        CategoryListItem post = resultLists.get(position);
        holder.ivImage.setImageResource(imagePojosList.get(position).getImage());
        holder.tvName.setText(post.getName());
        holder.tvId.setText(post.getId() + "");
//        Glide.with(holder.itemView.getContext()).load("Image: "+image.getImage()).into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return resultLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvId;
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}