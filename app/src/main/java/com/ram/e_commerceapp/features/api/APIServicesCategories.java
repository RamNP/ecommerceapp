package com.ram.e_commerceapp.features.api;

import com.ram.e_commerceapp.features.post.helper.ResultList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIServicesCategories {
    @Headers({"X-RapidAPI-Key: 34290b7c8bmsh7dcadb5449db85bp1ac735jsn5a27f4be4a35",
            "X-RapidAPI-Host: aliexpress-datahub.p.rapidapi.com"})
    @GET("store_categories")
    Call<ResultList> getPost(@Query("sellerId") String sellerId);

}

