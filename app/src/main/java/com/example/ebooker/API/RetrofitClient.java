package com.example.ebooker.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static RetrofitClient instance = null;
    Retrofit retrofit;
    String BASE_URL = "https://www.harumi.store/api/";
    public RetrofitClient() {
        // create a retrofit builder
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Retrofit getMyAPI() {
        return retrofit;
    }
}
