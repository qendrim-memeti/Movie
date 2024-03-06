package auctamovieapplication.movies.service;

import auctamovieapplication.movies.model.Review;
import auctamovieapplication.movies.repo.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review createReview(Review review){
        return repository.save(review);
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return repository.findByMovieId(movieId);
    }
}
