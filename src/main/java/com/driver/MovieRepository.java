package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class MovieRepository {

Map<String,Movie> movieDB = new HashMap<>();
Map<String,Director> directorDB = new HashMap<>();
Map<String,List<Movie>> pairDB=new HashMap<>();

    public Map<String, Director> getDirectorDB() {
        return directorDB;
    }

    public Map<String, List<Movie>> getPairDB() {
        return pairDB;
    }






    public Map<String, Movie> getMovieDB() {
        return movieDB;
    }


    public String addMovieDirectorPair(String movieName, String directorName)
    {
       Movie movieObj=movieDB.get(movieName);
       List<Movie> listMovie=pairDB.getOrDefault(directorName,new ArrayList<>());
       listMovie.add(movieObj);
       pairDB.put(directorName,listMovie);
      return "Pair added successfully";
    }

    public Movie getMovieByName(String movieName) {
        return movieDB.get(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return  directorDB.get(directorName);
    }

    public String deleteAllDirectors() {
        movieDB.clear();
        directorDB.clear();
        return "All movies and directors deleted successfully";
    }
}
