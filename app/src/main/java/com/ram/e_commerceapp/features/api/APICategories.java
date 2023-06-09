package com.ram.e_commerceapp.features.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICategories {


    private static Retrofit retrofit;
//    private static  final   String BASE_URL = "https://aliexpress-datahub.p.rapidapi.com/";
    private static final String BASE_URL = "http://10.0.2.2/Ram/";
    /**
     * Returns a Retrofit instance with a logging interceptor and Gson converter factory.
     * If an instance already exists, returns the existing instance.
     * @return Retrofit instance
     */
    public  static  Retrofit getRetrofitInstance (){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        if (retrofit== null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }




}
