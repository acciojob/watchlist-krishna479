package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieservice.addMovie(movie);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }
    //2) Adding director
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){

String response = movieservice.addDirector(director);
return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

//3) adding pair
    @PutMapping ("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam ("moviename") String name, @RequestParam ("dirname") String dirname){

       String response=   movieservice.addMovieDirectorPair(name,dirname);
       return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    //4) getMovieby movie name
    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
    Movie response = movieservice.getMovieByName(name);
    return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }
    //5) Get director by directornmae
    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity  getDirectorByName(@PathVariable("name")  String dirname){
    Director response =  movieservice.getDirectorByName(dirname);
    return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

//6) get movies by name of director
@GetMapping("/get-movies-by-director-name/{director}")
public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
    List<String> response =movieservice.getMoviesByDirectorName(director);
    return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

}

    //7) get all movies by default no argument
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> response =movieservice.findAllMovies();
    return new ResponseEntity(response,HttpStatus.ACCEPTED);


    }
    //8) delete a director and its movies from record
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam ("dirname") String dirname){
        String response = movieservice.deleteDirectorByName(dirname);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);

    }

    // 9) delete all movie
    @DeleteMapping("/delete-all-directors")
      public ResponseEntity deleteAllDirectors(){
    String response =  movieservice.deleteAllDirectors();
    return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }





}
