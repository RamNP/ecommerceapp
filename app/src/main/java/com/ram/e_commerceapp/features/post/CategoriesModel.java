package com.ram.e_commerceapp.features.post;

import com.ram.e_commerceapp.features.api.APICategories;
import com.ram.e_commerceapp.features.api.APIServicesCategories;
import com.ram.e_commerceapp.features.post.helper.CategoriesPojo;
import com.ram.e_commerceapp.features.post.helper.Result;
import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;

import retrofit2.Call;

public class CategoriesModel implements CategoriesContract.Model {
    @Override
    public Call<CategoriesPojo> getPostsFromAPI(String sellerId) {
          APIServicesCategories apiServicesCategories = APICategories.getRetrofitInstance().create(APIServicesCategories.class);
           return apiServicesCategories.getPost(sellerId);
    }
}
