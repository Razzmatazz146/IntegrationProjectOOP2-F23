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

    public void addMovie(Movie pMovie) {
        for (Movie aMovie : aMovieList)
            if (aMovie.getMovieTitle().equals(pMovie.getMovieTitle()))
                throw new IllegalArgumentException("This movie already exists.");
        this.aMovieList.add(pMovie);
    }

    public void removeMovie(Movie pMovie) { this.aMovieList.remove(pMovie); }

    public void editMovie(Movie pMovie, Movie aMovie) {
        if (aMovieList.contains(pMovie)) {
            int index = aMovieList.indexOf(pMovie);
            aMovieList.set(index, aMovie);
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
