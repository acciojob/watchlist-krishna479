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
//1) Adding movies;
@PostMapping("/add-movie")
public String addMovie(@RequestBody Movie movie){
        return movieservice.addMovie(movie);

    }
    //2) Adding director
    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
return movieservice.addDirector(director);
    }

//3) adding pair
    @PutMapping ("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam ("moviename") String name, @RequestParam ("dirname") String dirname){
    return movieservice.addMovieDirectorPair(name,dirname);
    }
    //4) getMovieby movie name
    @GetMapping("get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name){
    return movieservice.getMovieByName(name);

    }
    //5) Get director by directornmae
    @GetMapping("get-director-by-name/{name}")
    public Director  getDirectorByName(@PathVariable("name")  String dirname){
    return movieservice.getDirectorByName(dirname);
    }

//6) get movies by name of director
@GetMapping("/get-movies-by-director-name/{director}")
public List getMoviesByDirectorName(@PathVariable String director){
    List<String> ans =movieservice.getMoviesByDirectorName(director);
    return ans;

}

    //7) get all movies by default no argument
    @GetMapping("/get-all-movies")
    public List<String> findAllMovies(){
    return movieservice.findAllMovies();

    }




}
