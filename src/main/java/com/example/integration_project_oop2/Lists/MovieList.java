package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Manager;
import com.example.integration_project_oop2.Classes.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieList implements Serializable, Iterable<Movie>{
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

    public List<String> getMovieTitleList(){
        List<String> movieTitles = new ArrayList<>();
        for (Movie movie : aMovieList){
            movieTitles.add(movie.getMovieTitle());
        }
        return movieTitles;
    }

    public Movie getMovieByIndex(int index) {
        if (index >= 0 && index < aMovieList.size()) {
            return aMovieList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    @Override
    public Iterator<Movie> iterator() {
        return aMovieList.iterator();
    }
}
