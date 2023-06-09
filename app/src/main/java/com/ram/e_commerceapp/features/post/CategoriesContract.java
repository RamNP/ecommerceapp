package com.ram.e_commerceapp.features.post;

import androidx.annotation.NonNull;

import com.ram.e_commerceapp.features.post.helper.CategoriesPojo;
import com.ram.e_commerceapp.features.post.helper.Result;
import com.ram.e_commerceapp.features.post.helper.ResultList;


import java.util.List;

import retrofit2.Call;

public interface CategoriesContract {

    interface View{
        void setPost(@NonNull CategoriesPojo body);

        void showSuccessfulMessage(boolean show);
         void setPosts(CategoriesPojo body);
        void showErrorMessage(String error);

    }
    interface Presenter {

        void onCreate();

        void setPostsFromAPI(String sellerId);
    }

    interface Model{

        Call<CategoriesPojo> getPostsFromAPI(String sellerId);
    }

}
