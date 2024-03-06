package auctamovieapplication.movies.repo;

import auctamovieapplication.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    @Query(value = "SELECT * FROM Movie m WHERE m.year = :year", nativeQuery = true)
    List<Movie> findByYear(@Param("year") int year);
}
