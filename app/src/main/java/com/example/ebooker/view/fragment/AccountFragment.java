package com.example.ebooker.view.fragment;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.ebooker.R;
import com.example.ebooker.model.User;

public class AccountFragment extends Fragment {
    TextView username;
    TextView email;
    TextView firstname;
    TextView lastname;
    TextView age;
    TextView address;
    TextView phone_num;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account, container, false);

        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        firstname = view.findViewById(R.id.firstname);
        lastname = view.findViewById(R.id.lastname);
        age = view.findViewById(R.id.age);
        address = view.findViewById(R.id.address);
        phone_num = view.findViewById(R.id.phone_num);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = NavHostFragment.findNavController(this);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            User user = (User) extras.getSerializable("user", User.class);
            setAccountInf(user);
        }
    }

    public void setAccountInf(User user) {
        username.setText(user.getUsername());
        email.setText(user.getEmail());
        firstname.setText(user.getFirstName());
        lastname.setText(user.getLastName());
        age.setText(user.getAge().toString());
        address.setText(user.getAddress());
//        phone_num.setText(user.get());
    }
}