package com.freddans.popcorn.repositories;

import com.freddans.popcorn.entities.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {
    TvShow findTvShowByName(String name);
}
