package com.freddans.popcorn.services;

import com.freddans.popcorn.entities.Movie;
import com.freddans.popcorn.entities.TvShow;
import com.freddans.popcorn.repositories.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TvShowService {

    private TvShowRepository tvShowRepository;

    @Autowired
    public TvShowService(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShow> findTenMostRecentAddedTvShows() {
        List<TvShow> mostRecentTvShows = new ArrayList<>();
        for (int i = tvShowRepository.findAll().size()-1; i > (tvShowRepository.findAll().size()-11); i--) {
            TvShow tvShow = tvShowRepository.findAll().get(i);
            mostRecentTvShows.add(tvShow);
        }

        return mostRecentTvShows;
    }
}
