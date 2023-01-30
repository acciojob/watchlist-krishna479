package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

@Autowired
MovieService movieservice;
@PostMapping("/add-movie")
public String addMovie(@RequestBody Movie movie){
        return movieservice.addMovie(movie);

    }
    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
return movieservice.addDirector(director);
    }


    @PutMapping ("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam ("moviename") String name, @RequestParam ("dirname") String dirname){
    return movieservice.addMovieDirectorPair(name,dirname);
    }
    @GetMapping("get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name){
    return movieservice.getMovieByName(name);

    }
    @GetMapping("get-director-by-name/{name}")
    public Director  getDirectorByName(@PathVariable("name")  String dirname){
    return movieservice.getDirectorByName(dirname);
    }


//    public List<String> getMoviesByDirectorName( String director){
//        return pairMap.get(director);
//    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathVariable("dirname") String dirname){
    return movieservice.getMoviesByDirectorName(dirname);
    }
    @GetMapping("/get-all-movies")
    public List<String> findAllMovies(){
    return movieservice.findAllMovies();

    }




}
