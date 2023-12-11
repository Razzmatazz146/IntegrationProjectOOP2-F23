package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.ExceptionAlert;
import com.example.integration_project_oop2.Classes.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of movies in the Movie Theater application.
 * This list allows adding, removing, editing, and retrieving movies.
 */
public class MovieList implements Serializable, Iterable<Movie>{
    private List<Movie> aMovieList;

    public MovieList() { this.aMovieList = new ArrayList<>(); }

    /**
     * Adds a movie to the list, ensuring that no movie with the same title already exists.
     *
     * @param pMovie The movie to add.
     * @throws IllegalArgumentException If a movie with the same title already exists in the list.
     */
    public void addMovie(Movie pMovie) {
        for (Movie aMovie : aMovieList)
            if (aMovie.getMovieTitle().equals(pMovie.getMovieTitle()))
                ExceptionAlert.alertIllegalArgumentException("This movie already exists.");
        this.aMovieList.add(pMovie);
    }

    /**
     * Removes a movie from the list.
     *
     * @param pMovie The movie to remove.
     */
    public void removeMovie(Movie pMovie) { this.aMovieList.remove(pMovie); }

    /**
     * Edits an existing movie in the list.
     *
     * @param pMovie The movie to be edited.
     * @param aMovie The new movie details.
     */
    public void editMovie(Movie pMovie, Movie aMovie) {
        if (aMovieList.contains(pMovie)) {
            int index = aMovieList.indexOf(pMovie);
            aMovieList.set(index, aMovie);
        }
    }

    /**
     * Retrieves a list of movie titles.
     *
     * @return A list of movie titles.
     */
    public List<String> getMovieTitleList(){
        List<String> movieTitles = new ArrayList<>();
        for (Movie movie : aMovieList){
            movieTitles.add(movie.getMovieTitle());
        }
        return movieTitles;
    }

    /**
     * Retrieves a movie from the list by its index.
     *
     * @param index The index of the movie to retrieve.
     * @return The movie at the specified index, or null if the index is out of bounds.
     */
    public Movie getMovieByIndex(int index) {
        if (index >= 0 && index < aMovieList.size()) {
            return aMovieList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    /**
     * Returns an iterator over the movies in the list.
     *
     * @return An iterator over the movies.
     */
    @Override
    public Iterator<Movie> iterator() {
        return aMovieList.iterator();
    }
}
