package com.ram.e_commerceapp.features.post;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerceapp.R;
import com.ram.e_commerceapp.features.post.helper.CategoryListItem;
import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context context;
    List<CategoryListItem> resultLists;

    public CategoriesAdapter(Context context, List<CategoryListItem> resultLists) {
        this.context = context;
        this.resultLists = resultLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        CategoryListItem post = resultLists.get(position);
        holder.tvName.setText(post.getName());
        holder.tvId.setText(post.getId() + "");
        Glide.with(holder.itemView.getContext()).load(post.getImage()).into(holder.ivImage);
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
