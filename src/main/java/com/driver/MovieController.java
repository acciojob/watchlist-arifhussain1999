package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

@Autowired
  MovieService movieService;

@PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
    return movieService.addMovie(movie);
}

@PostMapping("/add-director")
    public String addDirector(@RequestBody Director director) {
    return movieService.addDirector(director);
}

@PutMapping("/add-movie-director-pair")
public String addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
    return movieService.addMovieDirectorPair(movieName,directorName);
}

@GetMapping("/get-movie-by-name/{name}")
public Movie getMovieByName(@PathParam("name") String movieName){

    return movieService.getMovieByName(movieName);
}

@GetMapping("/get-movies-by-director-name/{director}")
    public Director getDirectorByName(@PathParam("director") String directorName){
    return movieService.getDirectorByName(directorName);
}

@GetMapping("/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathParam("director") String directorName){
    return movieService.getMoviesByDirectorName(directorName);
}

@GetMapping("/get-all-movies")
    public List<Movie> findAllMovies(){
    return movieService.findAllMovies();
}

@DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam String directorName){
    return movieService.deleteDirectorByName(directorName);
}

@DeleteMapping("/delete-all-directors")
public String deleteAllDirectors(){
    return movieService.deleteAllDirectors();
}
}
