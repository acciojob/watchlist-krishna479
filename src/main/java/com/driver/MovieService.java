package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
   @Autowired
   MovieRepository movierepository;

    public List<String> findAllMovies() {
        return movierepository.findAllMovies();
    }

    public  Director getDirectorByName(String dirname) {
        return movierepository.getDirectorByName(dirname);
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
    public List<String> getMoviesByDirectorName( String dirname){
        return movierepository.getMoviesByDirectorName(dirname);
    }

//    public List<String> getMoviesByDirectorName(String dirname ) {
//        return movierepository.getMoviesByDirectorName(dirname);
//    }
}
