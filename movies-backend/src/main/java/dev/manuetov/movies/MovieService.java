package dev.manuetov.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Database access methods
@Service
public class MovieService {
    // conecta con el interface movieRepository
    @Autowired
    private MovieRepository movieRepository;

    // retornará una lista con todas las peliculas
    public List<Movie> allMovies(){
       System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    // retorna una pelicula por su id
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
