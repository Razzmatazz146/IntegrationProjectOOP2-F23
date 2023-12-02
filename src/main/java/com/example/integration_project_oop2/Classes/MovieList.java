package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieList implements Serializable {
    private List<Movie> aMovieList;

    public MovieList() { this.aMovieList = new ArrayList<>(); }

    public void addMovie(Movie movie) { this.aMovieList.add(movie); }

    public void removeMovie(Movie movie) { this.aMovieList.remove(movie); }

    public void editMovie(Movie oldMovie, Movie newMovie) {
        if (aMovieList.contains(oldMovie)) {
            int index = aMovieList.indexOf(oldMovie);
            aMovieList.set(index, newMovie);
        }
    }

    public List<Movie> getAllMovies() { return new ArrayList<>(aMovieList); }
}
