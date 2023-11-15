package com.example.ebooker.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ebooker.R;
import com.example.ebooker.model.Book;

public class BookDetailFragment extends Fragment {
//    private Book book;
//
//    public BookDetailFragment(Book book) {
//        this.book = book;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_details, container, false);

        return view;
    }
}
