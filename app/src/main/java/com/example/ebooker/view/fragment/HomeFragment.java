package com.example.ebooker.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebooker.API.RetrofitClient;
import com.example.ebooker.API.service.Book_API;
import com.example.ebooker.R;
import com.example.ebooker.model.Book;
import com.example.ebooker.view.adapter.HomeListAdapter;
import com.example.ebooker.utils.SpacingItemDecoration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView listBook;
    List<Book> books;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        listBook = view.findViewById(R.id.list_book);
        initListBook(view);
        if (books == null) {
            getData(view);
        }
        else {setAdapter(books);}
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void getData(View view) {
        RetrofitClient.getInstance().getMyAPI().create(Book_API.class).getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    String message = "Request Successfully ...";
                    books = response.body();
                    setAdapter(books);
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                    Log.e("calling_API", "onResponse getBook: " + message);
                } else {
                    String message = "Request fail ...";
                    books = response.body();
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                    Log.e("calling_API", "onResponse getBook: " + message);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
                Log.e("calling_API", "onResponse getBook: " + message);
            }
        });
}
    private void initListBook(View view) {
        SpacingItemDecoration itemDecoration = new SpacingItemDecoration(10, 10);

        listBook.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        listBook.addItemDecoration(itemDecoration);
    }

    private void setAdapter(List<Book> books) {
        HomeListAdapter bookListAdapter = new HomeListAdapter(getContext(), books, getParentFragmentManager());
        bookListAdapter.setHasStableIds(true);
        listBook.setAdapter(bookListAdapter);
        listBook.setHasFixedSize(true);


    }
}