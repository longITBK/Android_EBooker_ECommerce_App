package com.example.ebooker.API.service;

import com.example.ebooker.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface User_API {
    @FormUrlEncoded
    @POST("auth/login/")
    Call<User> getUserInformation(@Field("username") String username, @Field("password") String password);
}
