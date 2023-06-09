package com.ram.e_commerceapp.features.post;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.ram.e_commerceapp.CategoriesFragment;
import com.ram.e_commerceapp.features.post.helper.CategoriesPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesPresenter implements CategoriesContract.Presenter {
    private final CategoriesContract.View view;
    private final CategoriesModel categoriesModel = new CategoriesModel();
    Context context;

    public CategoriesPresenter(CategoriesContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void onCreate() {

        view.showSuccessfulMessage(true);

        setPostsFromAPI("40000002582537");
        Log.d("api", "onCreate: set post success");
    }

    @Override
    public void setPostsFromAPI(String sellerId) {
        categoriesModel.getPostsFromAPI(sellerId).enqueue(new Callback<CategoriesPojo>() {
            @Override
            public void onResponse(@NonNull Call<CategoriesPojo> call, @NonNull Response<CategoriesPojo> response) {
//                view.showSuccessfulMessage(false);
                if (response.isSuccessful()) {
                    view.setPost(response.body());
                    Log.d("api", "onResponse: " + response.code());
                } else {
                    view.showErrorMessage("invalid message" + response.code());

                }
             }

            @Override
            public void onFailure(@NonNull Call<CategoriesPojo> call, Throwable t) {
                view.showSuccessfulMessage(false);
                view.showErrorMessage(t.getMessage());

            }
        });


    }
}
