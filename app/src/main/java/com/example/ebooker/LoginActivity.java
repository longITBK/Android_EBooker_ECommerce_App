package com.example.ebooker;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ebooker.view.adapter.VPLoginRegister;
import com.example.ebooker.view.fragment.LoginFragment;
import com.example.ebooker.view.fragment.RegisterFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    String[] list = {"login", "register"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginner);

        setVP();


    }

    protected void setVP() {
        ViewPager2 viewPager = findViewById(R.id.vp_login_register);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());

        VPLoginRegister adapter = new VPLoginRegister(this, fragments);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(list[position])
        ).attach();
    }
}
