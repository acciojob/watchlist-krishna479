package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

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
    public Director  getDirectorByName(String name){
    return movieservice.getDirectorByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ArrayList<String> getMoviesByDirectorName(@PathVariable("name") String name){
    return movieservice.getMoviesByDirectorName(name);
    }
    @GetMapping("/get-all-movies")
    public ArrayList<String> findAllMovies(){
    return movieservice.findAllMovies();

    }




}
