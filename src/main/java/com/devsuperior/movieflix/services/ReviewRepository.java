package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT obj "
            + "FROM Review obj "
            + "WHERE :movie IS NULL OR obj.movie = :movie")
    List<Review> findByMovie(Movie movie);
}
