package com.freddans.popcorn.repositories;

import com.freddans.popcorn.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findMovieByName(String name);
}
