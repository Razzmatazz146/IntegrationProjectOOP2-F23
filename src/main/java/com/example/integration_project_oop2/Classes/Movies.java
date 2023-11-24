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
        this.setMovieTitle(pMovieTitle);
        this.setMovieGenre(pMovieGenre);
        this.setMovieDuration(pMovieDuration);
    }
    /**
     * Sets the title of the movie.
     *
     * @param pMovieTitle The new movie title.
     */
    public void setMovieTitle(String pMovieTitle) {
        this.aMovieTitle = pMovieTitle;
    }

    /**
     * Sets the duration of the movie.
     *
     * @param pMovieDuration The new movie duration.
     */
    public void setMovieDuration(int pMovieDuration) {
        this.aMovieDuration = pMovieDuration;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param pMovieGenre The new movie genre.
     */
    public void setMovieGenre(String pMovieGenre) {
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

}