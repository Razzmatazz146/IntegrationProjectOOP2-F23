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
            ExceptionAlert.alertIllegalArgumentException("Movie must have a title.");
        this.aMovieTitle = pMovieTitle;
    }

    /**
     * Sets the duration of the movie.
     *
     * @param pMovieDuration The new movie duration.
     */
    public void setMovieDuration(int pMovieDuration) {
        if (pMovieDuration <= 0)
            ExceptionAlert.alertIllegalArgumentException("Movie duration must be longer than 0.");
        this.aMovieDuration = pMovieDuration;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param pMovieGenre The new movie genre.
     */
    public void setMovieGenre(String pMovieGenre) {
        if (pMovieGenre == null)
            ExceptionAlert.alertIllegalArgumentException("Movie must have a genre.");
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

    /**
     * Gets the age rating of the movie.
     * @return age rating
     */
    public String getAgeRating() {
        return aAgeRating;
    }

    /**
     * Set age rating of the movie.
     * @param pAgeRating
     */
    public void setAgeRating(String pAgeRating) {
        if (pAgeRating == null)
            ExceptionAlert.alertIllegalArgumentException("Movie must have an age rating.");
        this.aAgeRating = pAgeRating;
    }

    /**
     * Get the release year of the movie.
     * @return release year.
     */
    public int getReleaseYear() {
        return aReleaseYear;
    }

    /**
     * Set release year of the movie.
     * @param pReleaseYear
     */
    public void setReleaseYear(int pReleaseYear) {
        if (pReleaseYear == 0)
            ExceptionAlert.alertIllegalArgumentException("Movie must have a release year.");
        this.aReleaseYear = pReleaseYear;
    }
}