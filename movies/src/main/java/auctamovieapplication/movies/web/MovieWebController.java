package auctamovieapplication.movies.web;

import auctamovieapplication.movies.model.Movie;
import auctamovieapplication.movies.model.Review;
import auctamovieapplication.movies.service.MovieService;
import auctamovieapplication.movies.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieWebController {

    private final MovieService movieService;
    private final ReviewService reviewService;

    public MovieWebController(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
    }
    @GetMapping("/byYear/{year}")
    public List<Movie> getMoviesByYear(@PathVariable int year) {
        return movieService.getAllMoviesByYear(year);
    }

    @GetMapping("/movies")
    public String listMovies(Model model){
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies/list";
    }

    @GetMapping("/{id}")
    public String getMovieDetails(@PathVariable Long id, Model model){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            List<Review> reviews = reviewService.getReviewsByMovieId(id);
            model.addAttribute("movie", movie.get());
            model.addAttribute("reviews", reviews);
            return "movies/details";
        }else{
            return "redirect:/movies";
        }
    }

    @GetMapping("/create")
    public String showCreateMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }

    @PostMapping("/create")
    public String createMovie(@ModelAttribute Movie movie){
        movieService.createMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/reviews/create")
    public String showCreateReview(@PathVariable Long id, Model model){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            Review review = new Review();
            review.setMovie(movie.get());
            model.addAttribute("review", review);
            return "reviews/create";
        }else{
            return "redirect:/movies";
        }
    }

    @PostMapping("/{id}/reviews/create")
    public String createReview(@ModelAttribute Review review){
        reviewService.createReview(review);
        return "redirect:/movies/"+ review.getMovie().getId();
    }
}
