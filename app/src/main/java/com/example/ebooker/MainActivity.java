package com.example.ebooker;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ebooker.model.Book;
import com.example.ebooker.view.fragment.AccountFragment;
import com.example.ebooker.view.fragment.HomeFragment;
import com.example.ebooker.view.fragment.NotificationFragment;
import com.example.ebooker.view.fragment.ShieldFragment;
import com.example.ebooker.view.fragment.ShoppingCartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    ShoppingCartFragment shoppingCartFragment;
    ShieldFragment shieldFragment;
    NotificationFragment notificationFragment;
    AccountFragment accountFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        replaceFragment(homeFragment);
        bottomNavigationView = findViewById(R.id.menu);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    replaceFragment(homeFragment);
                } else if (item.getItemId() == R.id.cart) {
                    replaceFragment(shoppingCartFragment);
                } else if (item.getItemId() == R.id.shield) {
                    replaceFragment(shieldFragment);
                } else if (item.getItemId() == R.id.notification) {
                    replaceFragment(notificationFragment);
                } else if (item.getItemId() == R.id.account) {
                    replaceFragment(accountFragment);
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container, fragment);
        fragmentTransaction.commit();
//        fragmentTransaction.addToBackStack(null);
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        shoppingCartFragment = new ShoppingCartFragment();
        shieldFragment = new ShieldFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();
    }
}