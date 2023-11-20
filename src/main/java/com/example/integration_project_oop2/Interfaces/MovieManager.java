package com.example.integration_project_oop2.Interfaces;

import com.example.integration_project_oop2.Classes.Movies;

import java.util.List;

public interface MovieManager {
    void addMovie(Movies movie);
    void removeMovie(Movies movie);
    List<Movies> getAllMovies();
}
