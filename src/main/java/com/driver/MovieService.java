package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        Map<String,Movie> movieDB=movieRepository.getMovieDB();
        String primaryKey=movie.getName();
        movieDB.put(primaryKey,movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director)
    {
        Map<String,Director> directorDB=movieRepository.getDirectorDB();
        String primaryKey=director.getName();
        directorDB.put(primaryKey,director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName)
    {
      return addMovieDirectorPair(movieName,directorName);
    }

    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        Map<String,List<Movie>> movieList=movieRepository.getPairDB();
        List<String> movieName=new ArrayList<>();
        List<Movie> Film=movieList.get(directorName);
        for(Movie movie:Film)
        {
            movieName.add(movie.getName());
        }
        return movieName;
    }

    public List<Movie> findAllMovies() {
        Map<String,Movie> movieDB=movieRepository.getMovieDB();
        List<Movie> list = new ArrayList<>();
        for(String key : movieDB.keySet())
        {
            list.add(movieDB.get(key));
        }
        return list;
    }

    public String deleteDirectorByName(String directorName) {
        Map<String,List<Movie>> pairDB=movieRepository.getPairDB();
        pairDB.remove(directorName);
        return "Director and it's movies deleted successfully";
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }
}
