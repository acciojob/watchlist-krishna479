package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
   @Autowired
   MovieRepository movierepository;

    public  ArrayList<String> findAllMovies() {
        return movierepository.findAllMovies();
    }

    public  Director getDirectorByName(String name) {
        return movierepository.getDirectorByName(name);
    }

    public String addMovie(Movie movie) {
        return movierepository.addMovie(movie);
    }


    public String addDirector(Director director) {
        return movierepository.addDirector(director);
    }

    public String addMovieDirectorPair(String name, String dirname) {
        return movierepository.addMovieDirectorPair(name,dirname);
    }

    public Movie getMovieByName(String name) {
        return movierepository.getMovieByName(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String name ) {
        return movierepository.getMoviesByDirectorName(name);
    }
}
