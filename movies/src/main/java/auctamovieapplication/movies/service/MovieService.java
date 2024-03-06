package auctamovieapplication.movies.service;

import auctamovieapplication.movies.model.Movie;
import auctamovieapplication.movies.repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> getAllMoviesByYear(int year) {
        return movieRepository.findByYear(year);
    }
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
