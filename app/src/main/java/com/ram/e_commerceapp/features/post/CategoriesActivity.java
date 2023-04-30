package com.ram.e_commerceapp.features.post;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerceapp.R;
import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;


public class CategoriesActivity extends AppCompatActivity implements CategoriesContract.View {
   RecyclerView rvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rvCategories = findViewById(R.id.rvCategories);

        CategoriesPresenter categoriesPresenter = new CategoriesPresenter(this);
        categoriesPresenter.onCreate();
        Log.d("api", "onCreate: success in activity");

//        Intent intent = new Intent(PostActivity.this, LoginActivity.class);
//        startActivity(intent);
//        setPosts();

    }


    @Override
    public void setPosts(@NonNull ResultList body) {
//            RecyclerView rvCategories = findViewById(R.id.rvCategories);
            CategoriesAdapter adapter = new CategoriesAdapter(this, body.getCategoryList());
            rvCategories.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager = ( new LinearLayoutManager(this));
            rvCategories.setLayoutManager(linearLayoutManager);

    }
    @Override
    public void showSuccessfulMessage(boolean show) {

    }

    @Override
    public void showErrorMessage(String error) {

    }
}
//        postPresenter.onCreate();
////        Intent intent = new Intent(PostActivity.this, LoginActivity.class);
////        startActivity(intent);
//    }
//
//    @Override
//    public void showSuccessfulMessage(boolean show) {
//        if(show){
//            if(progressDialog!= null && !progressDialog.isShowing()){
//                progressDialog = new ProgressDialog(this);
//                progressDialog.setMessage("Loading..");
//                progressDialog.show();
//            }
//        }else {
//            if(progressDialog!=null){
//                progressDialog.dismiss();
//                progressDialog  = null;
//            }
//        }
//
//
//    }
//
//
//
//    @Override
//    public void setPosts(List<PostPojoItem> posts) {
//
//
//        RecyclerView recyclerView = findViewById(R.id.rvPosts);
//        PostAdapter adapter = new PostAdapter(posts);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//    }
//
//    @Override
//    public void showErrorMessage(String error) {
//        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
//    }
//}