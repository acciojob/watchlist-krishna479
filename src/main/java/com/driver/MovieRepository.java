package com.driver;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieRepository {
    HashMap<String,Movie> db = new HashMap<>();
    HashMap<String,Director> dbb = new HashMap<>();
    HashMap<String, ArrayList<String>>pair = new HashMap<>();


    public String addMovie(Movie movie) {
        String name= movie.getName();
        db.put(name,movie);
        return "SUCCESS";
    }

    public String addDirector(Director director) {
        String name = director.getName();
        dbb.put(name,director);
        return "SUCCESS";
    }


    public String addMovieDirectorPair(String name, String dirname) {

           ArrayList temp =  pair.getOrDefault(dirname,new ArrayList<>());
           temp.add(name);
           pair.put(dirname, temp);

       return"SUCCESS";
    }

    public Movie getMovieByName(String name) {

            return db.get(name);

    }

    public Director getDirectorByName(String dirname) {
        return dbb.get(dirname);
    }
    public List<String> getMoviesByDirectorName( String dirname){
        return pair.get(dirname);
    }

//    public List<String> getMoviesByDirectorName(String  dirname) {
//
//       return pair.get(dirname);
//
//    }

    public List<String> findAllMovies() {
        //ArrayList<String> hm = new ArrayList<>();

        return new ArrayList<>(db.keySet());
    }
}
