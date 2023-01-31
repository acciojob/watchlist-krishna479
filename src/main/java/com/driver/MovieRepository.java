package com.driver;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieRepository {
    HashMap<String,Movie> db = new HashMap<>();
    HashMap<String,Director> dbb = new HashMap<>();
    HashMap<String, ArrayList<String>> directorMoviePairing = new HashMap<>();
//1)Adding movies

    public String addMovie(Movie movie) {
        String name= movie.getName();
        db.put(name,movie);
        return "SUCCESS";
    }
//2)Adding director
    public String addDirector(Director director) {
        String name = director.getName();
        dbb.put(name,director);
        return "SUCCESS";
    }

//3) adding pair
    public String addMovieDirectorPair(String name, String dirname) {

           ArrayList temp =  directorMoviePairing.getOrDefault(dirname,new ArrayList<>());
           temp.add(name);
        directorMoviePairing.put(dirname, temp);

       return"SUCCESS";
    }
    //4) get movie by moviename

    public Movie getMovieByName(String name) {

            return db.get(name);

    }
//5) get director by directorname
    public Director getDirectorByName(String dirname) {
        return dbb.get(dirname);
    }

 //6) get movies by name of director

    public List getMoviesByDirectorName(String directorName){
        List<String> result=new ArrayList<>();

        if(directorMoviePairing.containsKey(directorName)){
            result=directorMoviePairing.get(directorName);
        }

        return result;
    }


//7) get all movies by default

    public List<String> findAllMovies() {
       ArrayList<String> hm = new ArrayList<>();
       for(String s: db.keySet()){
           hm.add(s);
       }

       return hm;
    }
// 8 delete a director and its movies from record
    public String deleteDirectorByName(String dirname) {
        if(directorMoviePairing.containsKey(dirname)){
            ArrayList<String> result = directorMoviePairing.get(dirname);
            for(String s: result){
                    db.remove(s);
            }
            dbb.remove(dirname);
            directorMoviePairing.remove(dirname);
        }
        return "Success";
    }

    public String deleteAllDirectors() {
        dbb.clear();
        for(List<String>ans :directorMoviePairing.values()) {
            for (String s:ans){
                db.remove(s);
            }

        }
        directorMoviePairing.clear();
        return "Success";
    }
}
