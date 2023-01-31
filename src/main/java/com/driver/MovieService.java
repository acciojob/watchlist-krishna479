package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
   @Autowired
   MovieRepository movierepository;
//1)Adding movie
    public String addMovie(Movie movie) {
        return movierepository.addMovie(movie);
    }

    //2)Adding director
    public String addDirector(Director director) {
        return movierepository.addDirector(director);
    }
   // 3) Adding pair
     public String addMovieDirectorPair(String name, String dirname) {
            return movierepository.addMovieDirectorPair(name,dirname);
        }
//4)getmovie by movie name
public Movie getMovieByName(String name) {
    return movierepository.getMovieByName(name);
}

//5) getdirector by director name
 public  Director getDirectorByName(String dirname) {
        return movierepository.getDirectorByName(dirname);
    }
    // 6) get movies by name of director
    public List getMoviesByDirectorName(String directorName){
        return movierepository.getMoviesByDirectorName(directorName);
    }
//7) get all movies
    public List<String> findAllMovies() {
        return movierepository.findAllMovies();
    }

//8)  delete a director and its movies from record
    public String deleteDirectorByName(String dirname) {
        return movierepository.deleteDirectorByName(dirname);
    }

    public String deleteAllDirectors() {
        return movierepository.deleteAllDirectors();
    }
}
