package com.example.ebooker.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebooker.MainActivity;
import com.example.ebooker.R;
import com.example.ebooker.model.Book;
import com.example.ebooker.view.fragment.BookDetailFragment;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.DataViewHolder> {

    private List<Book> books;
    private Context context;
    FragmentManager fragmentManager;

    public HomeListAdapter(List<Book> books, Context context, FragmentManager fragmentManager) {
        this.books = books;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeListAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListAdapter.DataViewHolder  holder, int position) {
        holder.book_name.setText(books.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookDetailFragment bookDetailFragment = new BookDetailFragment(books.get(position));

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_activity, bookDetailFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }



    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView book_name;
        private CardView cardView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            book_name = (TextView) itemView.findViewById(R.id.book_name);
            cardView = (CardView) itemView.findViewById(R.id.book_container);
        }
    }
}