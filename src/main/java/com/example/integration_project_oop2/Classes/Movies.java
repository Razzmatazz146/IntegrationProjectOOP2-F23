package com.example.integration_project_oop2.Classes;

import com.example.integration_project_oop2.Interfaces.MovieManager;

import java.util.List;

public class Movies implements MovieManager {
    String movieTitle;
    String movieGenre;
    int movieDuration;
    int moviePrice;

    public Movies(String movieTitle, String movieGenre, int movieDuration, int moviePrice){
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieDuration = movieDuration;
        this.moviePrice = moviePrice;
    }
    public void setMovieTitle(String movieTitle){ this.movieTitle = movieTitle;}
    public String getMovieTitle(){ return movieTitle; }
    public void setMovieGenre(String movieGenre){ this.movieGenre = movieGenre; }
    public String getMovieGenre(){ return movieGenre; }
    public void setMovieDuration(int movieDuration){ this.movieDuration = movieDuration; }
    public int getMovieDuration(){ return movieDuration; }
    public void setMoviePrice(int moviePrice){ this.moviePrice = moviePrice; }
    public int getMoviePrice(){ return moviePrice; }

    @Override
    public void addMovie(Movies movie) {

    }

    @Override
    public void removeMovie(Movies movie) {

    }

    @Override
    public List<Movies> getAllMovies() {
        return null;
    }
}
