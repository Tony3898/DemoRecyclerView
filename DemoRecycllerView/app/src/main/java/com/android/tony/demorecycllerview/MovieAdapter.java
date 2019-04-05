package com.android.tony.demorecycllerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private  List<Movie> movielist;


    public  MovieAdapter(List<Movie> movielist)
    {
        this.movielist = movielist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title,genre,year;
        MyViewHolder(View v)
        {
            super(v);
            title = v.findViewById(R.id.titletextview);
            genre = v.findViewById(R.id.genretextview);
            year = v.findViewById(R.id.yeartextview);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movielist,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Movie movie = movielist.get(i);
        myViewHolder.title.setText(movie.getTitle());
        myViewHolder.genre.setText(movie.getGenre());
        myViewHolder.year.setText(movie.year);
    }


    @Override
    public int getItemCount() {
        return movielist.size();
    }
}