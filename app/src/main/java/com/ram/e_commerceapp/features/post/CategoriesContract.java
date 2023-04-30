package com.ram.e_commerceapp.features.post;

import com.ram.e_commerceapp.features.post.helper.ResultList;


import java.util.List;

import retrofit2.Call;

public interface CategoriesContract {

    interface View{
        void showSuccessfulMessage(boolean show);
         void setPosts(ResultList body);
        void showErrorMessage(String error);

    }
    interface Presenter {

        void onCreate();

        void setPostsFromAPI(String sellerId);
    }

    interface Model{

        Call<ResultList> getPostsFromAPI(String sellerId);
    }

}
