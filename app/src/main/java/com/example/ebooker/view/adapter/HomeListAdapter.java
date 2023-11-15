package com.example.ebooker.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebooker.R;
import com.example.ebooker.model.Book;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.DataViewHolder> {
    Context context;
    List<Book> books;
    FragmentManager fragmentManager;

    public HomeListAdapter(Context context, List<Book> books, FragmentManager fragmentManager) {
        this.context = context;
        this.books = books;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public HomeListAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListAdapter.DataViewHolder holder, int position) {
        holder.book_name.setText(books.get(position).getName());
        holder.book_price.setText(books.get(position).getPrice().toString());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = books.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("book", book);
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_bookDetailFragment2, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView book_name;
        private TextView book_price;
        private CardView cardView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}