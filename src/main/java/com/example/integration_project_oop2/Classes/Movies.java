package com.example.integration_project_oop2.Classes;

/**
 * Represents the theater's available Movies' Title, Genre, and Duration.
 *
 * Has methods to get and set Title, Genre and Duration, as well as a @Movies constructor.
 */
public class Movies {
    String aMovieTitle;
    String aMovieGenre;
    int aMovieDuration;

    /**
     * Movies constructor.
     * @param pMovieTitle Movie title.
     * @param pMovieGenre Movie genre.
     * @param pMovieDuration Movie duration.
     */
    public Movies(String pMovieTitle, String pMovieGenre, int pMovieDuration) {
        this.aMovieTitle = pMovieTitle;
        this.aMovieGenre = pMovieGenre;
        this.aMovieDuration = pMovieDuration;
    }

    public void setMovieTitle(String pMovieTitle) {
        this.aMovieTitle = pMovieTitle;
    }
    public void setMovieDuration(int pMovieDuration) {
        this.aMovieDuration = pMovieDuration;
    }
    public void setMovieGenre(String pMovieGenre) {
        this.aMovieGenre = pMovieGenre;
    }

    public String getMovieTitle() {
        return aMovieTitle;
    }
    public int getMovieDuration() {
        return aMovieDuration;
    }
    public String getMovieGenre() {
        return aMovieGenre;
    }
}