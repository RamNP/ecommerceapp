package com.ram.e_commerceapp.features.post;


import android.util.Log;

import androidx.annotation.NonNull;

import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesPresenter implements CategoriesContract.Presenter {
    private final CategoriesContract.View view;
    private final CategoriesModel categoriesModel = new CategoriesModel();

    public CategoriesPresenter(CategoriesContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

        view.showSuccessfulMessage(true);

        setPostsFromAPI("40000002582537");
        Log.d("api", "onCreate: set post success");
    }

    @Override
    public void setPostsFromAPI(String sellerId) {
        categoriesModel.getPostsFromAPI(sellerId).enqueue(new Callback<ResultList>() {
            @Override
            public void onResponse(@NonNull Call<ResultList> call, @NonNull Response<ResultList> response) {
//                view.showSuccessfulMessage(false);
                if (response.isSuccessful()) {
                    view.setPosts(response.body());
                    Log.d("api", "onResponse: " + response.code());
                } else {
                    view.showErrorMessage("invalid message" + response.code());

                }


            }

            @Override
            public void onFailure(@NonNull Call<ResultList> call, Throwable t) {
                view.showSuccessfulMessage(false);
                view.showErrorMessage(t.getMessage());

            }
        });


    }
}
