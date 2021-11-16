package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // ArrayList to hold movies data
    ArrayList<Movie> moviesList;
    // Layout Type
    String layoutType = "grid";
    RecyclerView moviesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // restore the data
        if (savedInstanceState != null) {
            layoutType = savedInstanceState.getString("layoutType");
        }

        // set the view for the activity
        setContentView(R.layout.activity_main);

        // Recycler View - assigning the value
        moviesView = (RecyclerView) findViewById(R.id.moviesView);

        // Returns list of Movie objects
        List<Movie> movies = this.getMovies();

        moviesList = new ArrayList<Movie>();
        moviesList.addAll(movies);

        // on click listener for movie item or context menu items
        MovieItemClickListener clickListener = (videoUrl) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
            startActivity(intent);
        };

        // Instantiating a custom adapter
        MoviesAdapter adapter = new MoviesAdapter(moviesList, clickListener);
        moviesView.setAdapter(adapter);

        // set layout with layout manager according to the current layout type
        if(layoutType == "grid") {
            moviesView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            moviesView.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    // onCreateOptionsMenu method of options menu - inflates the menu with xml file
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.global_menu, menu);
        return true;
    }

    // this method is invoked when an item in options menu is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.listView:
                switchToListView();
                return true;
            case R.id.gridView:
                switchToGridView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // This method saves data if OS destroys and restarts the activity (like on orientation change)
    @Override
    protected void onSaveInstanceState(Bundle outputState) {

        // needs to be called
        super.onSaveInstanceState(outputState);

        // save the value entered in edit field
        outputState.putString("layoutType", layoutType);
    }

    // This method is to switch to list view if current view is grid
    public void switchToListView() {
        if(layoutType == "grid") {
            layoutType = "list";
            moviesView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    // This method is to switch to grid view if current view is list
    public void switchToGridView() {
        if(layoutType == "list") {
            layoutType = "grid";
            moviesView.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }

    // This method returns the a list of Movie objects
    protected List<Movie> getMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie(
                        getString(R.string.m1_title),
                        getString(R.string.m1_director_name),
                        getString(R.string.m1_video_link),
                        getString(R.string.m1_wiki_link),
                        getString(R.string.m1_d_wiki_link),
                        R.drawable.gone_girl_image
                ),
                new Movie(
                        getString(R.string.m2_title),
                        getString(R.string.m2_director_name),
                        getString(R.string.m2_video_link),
                        getString(R.string.m2_wiki_link),
                        getString(R.string.m2_d_wiki_link),
                        R.drawable.prisoners_image
                ),
                new Movie(
                        getString(R.string.m3_title),
                        getString(R.string.m3_director_name),
                        getString(R.string.m3_video_link),
                        getString(R.string.m3_wiki_link),
                        getString(R.string.m3_d_wiki_link),
                        R.drawable.insomnia_image
                ),
                new Movie(
                        getString(R.string.m4_title),
                        getString(R.string.m4_director_name),
                        getString(R.string.m4_video_link),
                        getString(R.string.m4_wiki_link),
                        getString(R.string.m4_d_wiki_link),
                        R.drawable.into_the_wild_image
                ),
                new Movie(
                        getString(R.string.m5_title),
                        getString(R.string.m5_director_name),
                        getString(R.string.m5_video_link),
                        getString(R.string.m5_wiki_link),
                        getString(R.string.m5_d_wiki_link),
                        R.drawable.schindlers_list_image
                ),
                new Movie(
                        getString(R.string.m6_title),
                        getString(R.string.m6_director_name),
                        getString(R.string.m6_video_link),
                        getString(R.string.m6_wiki_link),
                        getString(R.string.m6_d_wiki_link),
                        R.drawable.the_shawshank_redemption_image
                ),
                new Movie(
                        getString(R.string.m7_title),
                        getString(R.string.m7_director_name),
                        getString(R.string.m7_video_link),
                        getString(R.string.m7_wiki_link),
                        getString(R.string.m7_d_wiki_link),
                        R.drawable.the_revenant_image
                ),
                new Movie(
                        getString(R.string.m8_title),
                        getString(R.string.m8_director_name),
                        getString(R.string.m8_video_link),
                        getString(R.string.m8_wiki_link),
                        getString(R.string.m8_d_wiki_link),
                        R.drawable.seven_image
                ),
                new Movie(
                        getString(R.string.m9_title),
                        getString(R.string.m9_director_name),
                        getString(R.string.m9_video_link),
                        getString(R.string.m9_wiki_link),
                        getString(R.string.m9_d_wiki_link),
                        R.drawable.moonlight_image
                ),
                new Movie(
                        getString(R.string.m10_title),
                        getString(R.string.m10_director_name),
                        getString(R.string.m10_video_link),
                        getString(R.string.m10_wiki_link),
                        getString(R.string.m10_d_wiki_link),
                        R.drawable.forrest_gump_image
                )
        );

        return movies;
    }
}