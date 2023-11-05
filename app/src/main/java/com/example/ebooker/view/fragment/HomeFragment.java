package com.example.ebooker.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebooker.R;
import com.example.ebooker.model.Book;
import com.example.ebooker.view.adapter.HomeListAdapter;
import com.example.ebooker.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView listBook;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        listBook = view.findViewById(R.id.list_book);

        initListBook(view);

        return view;

    }

    private void initListBook(View view) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Les Miserable","Long"));
        books.add(new Book("h Miserfgfdgable","Long"));
        books.add(new Book("Les hfghg","Long"));
        books.add(new Book("Les Mihhgfhhherable","Long"));
        books.add(new Book("Les Mgfhfgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Miserable","Long"));
        books.add(new Book("h Miserfgfdgable","Long"));
        books.add(new Book("Les hfghg","Long"));
        books.add(new Book("Les Mihhgfhhherable","Long"));
        books.add(new Book("Les Mgfhfgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));
        books.add(new Book("Les Mhhghgfgfhgiserable","Long"));

        SpacingItemDecoration itemDecoration = new SpacingItemDecoration(10, 10);
        HomeListAdapter bookListAdapter = new HomeListAdapter(books, view.getContext(), getParentFragmentManager());

        listBook.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        listBook.addItemDecoration(itemDecoration);
//        listBook.setHasFixedSize(true);
        listBook.setAdapter(bookListAdapter);
    }
}