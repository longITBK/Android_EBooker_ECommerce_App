package com.example.ebooker.view.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ebooker.API.RetrofitClient;
import com.example.ebooker.API.service.User_API;
import com.example.ebooker.MainActivity;
import com.example.ebooker.R;
import com.example.ebooker.model.User;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    Button login_but;
    TextView wrong_notification;
    TextView username;
    TextView password;
    User user;

    CookieManager cookieManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login_but = view.findViewById(R.id.login_button);
        wrong_notification = view.findViewById(R.id.wrong_password_user);
        username = view.findViewById(R.id.phonenum_email_input);
        password = view.findViewById(R.id.password_input);
        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cookieManager = new CookieManager();
                cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
                CookieHandler.setDefault(cookieManager);
                RetrofitClient.getInstance().getMyAPI().create(User_API.class).getUserInformation(username.getText().toString(), password.getText().toString()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){
                            // Get the cookies from the response headers
                            List<String> cookies = response.headers().values("Set-Cookie");

                            // Loop through the cookies and extract the access token
                            for (String cookie : cookies) {
                                if (cookie.contains("accessToken")) {
                                    String accessToken = "Bearer " + cookie.split("=")[1].split(";")[0];
                                    Log.e("calling_API", "onResponse getUser + cookie: " + cookie);
                                    Log.e("calling_API", "onResponse getUser + accessToken: " + accessToken);
                                    // Save the access token to SharedPreferences
                                    SharedPreferences preferences = getContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("accessToken", accessToken);
                                    editor.putString("cookie", cookie);
                                    editor.apply();


                                    break;
                                }
                            }

                            String message = "Request Successfully ...";
                            user = response.body();
                            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                            Log.e("calling_API", "onResponse getUser: " + message);
                            Log.e("calling_API", "onResponse getUser + id: " + user.getId());
                            Log.e("calling_API", "onResponse getUser + username: " + user.getUsername());
                            Log.e("calling_API", "onResponse getUser + email: " + user.getEmail());

                            startMainActivity();
                        }
                        else {
                            // handle error
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        String message = "Request fail ...";
                        Log.e("getUser", "onResponse: " + message);
                    }
                });
            }
        });
    }

    public void startMainActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    public Boolean checkLoginCondition(String username, String password) {
        if (username.trim().equals("long71") && password.trim().equals("123456")) {
            return true;
        }
        return false;
    }
}
