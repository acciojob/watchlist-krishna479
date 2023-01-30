package com.driver;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import javafx.util.Pair;
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

           ArrayList temp =  pair.getOrDefault(name,new ArrayList<>());
           temp.add(dirname);
           pair.put(name, temp);

       return"SUCCESS";
    }

    public Movie getMovieByName(String name) {

            return db.get(name);

    }

    public Director getDirectorByName(String name) {
        return dbb.get(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String  name) {
       return pair.get(name);

    }

    public ArrayList<String> findAllMovies() {
        ArrayList<String > hm = new ArrayList<>();
        for(String s: db.keySet()){
            hm.add(s);
        }
        return hm;
    }
}
