package com.example.project2;

// Movie class for instantiating Movie objects
public class Movie {
    // Attributes of Movie Object
    private int movieImageSrc;
    private String videoLink;
    private String title;
    private String directorName;
    private String movieWikiLink;
    private String directorWikiLink;

    // Defining a constructor
    public Movie(String title, String directorName, String videoLink, String movieWikiLink, String directorWikiLink, int movieImageSrc) {
        this.title = title;
        this.directorName = directorName;
        this.videoLink = videoLink;
        this.movieWikiLink = movieWikiLink;
        this.directorWikiLink = directorWikiLink;
        this.movieImageSrc = movieImageSrc;
    }

    // this method returns title of the movie
    public String getMovieTitle() {
        return this.title;
    }

    // this method returns video clip associated with the movie
    public String getVideoLink() {
        return this.videoLink;
    }

    // this method returns the name of the director
    public String getDirectorName() {
        return this.directorName;
    }

    // this method returns Link of the movie' Wikipedia page
    public String getMovieWikiLink() {
        return this.movieWikiLink;
    }

    // this method returns Link of the movie director's Wikipedia page
    public String getDirectorWikiLink() {
        return this.directorWikiLink;
    }

    // this method returns the image reference associated with the movie
    public int getImageReference() {
        return this.movieImageSrc;
    }

}
