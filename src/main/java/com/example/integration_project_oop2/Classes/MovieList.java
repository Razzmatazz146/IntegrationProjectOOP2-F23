package com.example.integration_project_oop2.Classes;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movies> aMovieList;

    public MovieList() { this.aMovieList = new ArrayList<>(); }

    public void addMovie(Movies movie) { this.aMovieList.add(movie); }

    public void removeMovie(Movies movie) { this.aMovieList.remove(movie); }

    public void editMovie(Movies oldMovie, Movies newMovie) {
        if (aMovieList.contains(oldMovie)) {
            int index = aMovieList.indexOf(oldMovie);
            aMovieList.set(index, newMovie);
        }
    }

    public List<Movies> getAllMovies() { return new ArrayList<>(aMovieList); }
}
