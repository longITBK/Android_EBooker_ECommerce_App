package com.example.ebooker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.ebooker.view.fragment.AccountFragment;
import com.example.ebooker.view.fragment.HomeFragment;
import com.example.ebooker.view.fragment.MainFragment;
import com.example.ebooker.view.fragment.NotificationFragment;
import com.example.ebooker.view.fragment.ShieldFragment;
import com.example.ebooker.view.fragment.ShoppingCartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment = new MainFragment();
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

        bottomNavigationView = findViewById(R.id.menu);
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        shoppingCartFragment = new ShoppingCartFragment();
        shieldFragment = new ShieldFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();
    }
}