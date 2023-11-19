package com.example.ebooker.API.service;

import com.example.ebooker.model.Book;
import com.example.ebooker.model.CartItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Book_API {
    @GET("book")
    Call<List<Book>> getBooks();

    @GET("cart")
    Call<List<CartItem>> getCartItemByCustomer(@Header("Authorization") String authToken, @Header("Cookie") String cookie);
}
