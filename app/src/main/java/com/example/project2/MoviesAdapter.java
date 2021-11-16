package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Custom MovieAdapter extended adapter of RecyclerView
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    // This variable will hold the ArrayList full of movies data
    private ArrayList<Movie> moviesList;
    // This variable is of type MovieItemClickListener
    private MovieItemClickListener clickListener;

    // Defining a constructor
    public MoviesAdapter(ArrayList<Movie> moviesList, MovieItemClickListener clickListener) {
        this.moviesList = moviesList;
        this.clickListener = clickListener;
    }

    // onCreateViewHolder - returns a ViewHolder object
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.movie_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(movieView, this.clickListener);
        return viewHolder;
    }

    // bind movies data to ViewHolder Object for that particular movie
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.movieTitle.setText(this.moviesList.get(position).getMovieTitle());
        holder.movieDirectorName.setText(this.moviesList.get(position).getDirectorName());
        holder.videoUrl = this.moviesList.get(position).getVideoLink();
        holder.movieWikiLink = this.moviesList.get(position).getMovieWikiLink();
        holder.directorWikiLink = this.moviesList.get(position).getDirectorWikiLink();
        holder.movieImage.setImageResource(this.moviesList.get(position).getImageReference());

    }

    // this method returns the size of movies list
    @Override
    public int getItemCount() {
        return this.moviesList.size();
    }


    // ViewHolder class extended from RecyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {

        public TextView movieTitle;
        public ImageView movieImage;
        public String videoUrl;
        public String movieWikiLink;
        public String directorWikiLink;
        public TextView movieDirectorName;
        private MovieItemClickListener clickListener;

        // defining constructor - binds the public, private variables to the data and listeners with which it is getting instantiating with
        public ViewHolder(@NonNull View itemView, MovieItemClickListener clickListener) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            movieDirectorName = (TextView) itemView.findViewById(R.id.directorName);
            movieImage = (ImageView) itemView.findViewById(R.id.movieImage);
            itemView.setOnCreateContextMenuListener(this);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);

        }

        // Defining onClick listener for ViewHolder
        @Override
        public void onClick(View v) {
            clickListener.onClick(videoUrl);
        }

        // Creates context menu (gets displayed on longClick)
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.inflate(R.menu.context_menu, menu);

            // Only 3 items in context menu, setting onMenuItemClickListener on each
            menu.getItem(0).setOnMenuItemClickListener(onMenu);
            menu.getItem(1).setOnMenuItemClickListener(onMenu);
            menu.getItem(2).setOnMenuItemClickListener(onMenu);
        }

        // defining onMenu listener
        public final MenuItem.OnMenuItemClickListener onMenu = new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){
                // Check which item on context menu is clicked
                switch(item.getItemId()) {
                    case R.id.videoLink:
                        clickListener.onClick(videoUrl);
                        return true;
                    case R.id.movieWikiLink:
                        clickListener.onClick(movieWikiLink);
                        return true;
                    case R.id.directorWikiLink:
                        clickListener.onClick(directorWikiLink);
                        return true;
                    default:
                        return true;
                }
            }
        };

    }
}
