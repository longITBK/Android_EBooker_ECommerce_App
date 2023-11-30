package com.example.ebooker.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ebooker.API.RetrofitClient;
import com.example.ebooker.API.service.Book_API;
import com.example.ebooker.R;
import com.example.ebooker.model.CartItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingCartFragment extends Fragment {
    List<CartItem> cartItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_cart, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String accessToken = sharedPreferences.getString("accessToken", "");
        String cookie = sharedPreferences.getString("cookie", "");

        getData(accessToken, cookie);
        return view;
    }

    public void getData(String accessToken, String cookie) {
        RetrofitClient.getInstance().getMyAPI().create(Book_API.class).getCartItemByCustomer(accessToken, cookie).enqueue(new Callback<List<CartItem>>() {
            @Override
            public void onResponse(Call<List<CartItem>> call, Response<List<CartItem>> response) {
                if (response.isSuccessful()) {
                    String message = "Request Successfully ...";
                    cartItems = response.body();
                    Log.e("calling_API", "onResponse: " + message);
//                    if ((cartItems != null)) {
//                        Log.e("calling_API", "onResponse + getCartItem: " + cartItems.get(0).getBookId().toString());
//                    }
                } else {
                    String message = "Request fail ...";
                    cartItems = response.body();
                    Log.e("calling_API", "onResponse: " + message);
//                    Log.e("getCartItem", "onResponse: " + cartItems.get(0).getBookId().toString());
                }
            }

            @Override
            public void onFailure(Call<List<CartItem>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Log.e("calling_API", "onResponse: " + message);
            }
        });
    }
}