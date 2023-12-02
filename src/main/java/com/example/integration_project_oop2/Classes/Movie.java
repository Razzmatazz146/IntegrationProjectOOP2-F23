package com.example.integration_project_oop2.Classes;

import java.io.Serializable;

/**
 * Represents the theater's available Movies' Title, Genre, and Duration.
 *
 * Has methods to get and set Title, Genre and Duration, as well as a @Movies constructor.
 */
public class Movie implements Serializable {
    private String aMovieTitle;
    private String aMovieGenre;
    private int aMovieDuration;
    private String aAgeRating;
    private int aReleaseYear;

    /**
     * Movies constructor.
     * @param pMovieTitle Movie title.
     * @param pMovieGenre Movie genre.
     * @param pMovieDuration Movie duration.
     */
    public Movie(String pMovieTitle, String pMovieGenre, int pMovieDuration, int pReleaseYear, String pAgeRating) {
        this.setMovieTitle(pMovieTitle);
        this.setMovieGenre(pMovieGenre);
        this.setMovieDuration(pMovieDuration);
        this.setReleaseYear(pReleaseYear);
        this.setAgeRating(pAgeRating);
    }
    /**
     * Sets the title of the movie.
     *
     * @param pMovieTitle The new movie title.
     */
    public void setMovieTitle(String pMovieTitle) {
        if (pMovieTitle == null)
            throw new IllegalArgumentException("Movie title cannot be null");
        this.aMovieTitle = pMovieTitle;
    }

    /**
     * Sets the duration of the movie.
     *
     * @param pMovieDuration The new movie duration.
     */
    public void setMovieDuration(int pMovieDuration) {
        if (pMovieDuration < 0)
            throw new IllegalArgumentException("Movie duration cannot be less than 0");
        this.aMovieDuration = pMovieDuration;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param pMovieGenre The new movie genre.
     */
    public void setMovieGenre(String pMovieGenre) {
        if (pMovieGenre == null)
            throw new IllegalArgumentException("Movie genre cannot be null");
        this.aMovieGenre = pMovieGenre;
    }

    /**
     * Gets the title of the movie.
     *
     * @return The movie title.
     */
    public String getMovieTitle() {
        return aMovieTitle;
    }

    /**
     * Gets the duration of the movie.
     *
     * @return The movie duration.
     */
    public int getMovieDuration() {
        return aMovieDuration;
    }

    /**
     * Gets the genre of the movie.
     *
     * @return The movie genre.
     */
    public String getMovieGenre() {
        return aMovieGenre;
    }

    public String getAgeRating() {
        return aAgeRating;
    }

    public void setAgeRating(String pAgeRating) {
        if (pAgeRating == null)
            throw new IllegalArgumentException("Movie must have an age rating.");
        this.aAgeRating = pAgeRating;
    }

    public int getReleaseYear() {
        return aReleaseYear;
    }

    public void setReleaseYear(int pReleaseYear) {
        if (pReleaseYear == 0)
            throw new IllegalArgumentException("Movie must have a release year.");
        this.aReleaseYear = pReleaseYear;
    }
}