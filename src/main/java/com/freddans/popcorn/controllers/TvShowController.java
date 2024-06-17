package com.freddans.popcorn.controllers;

import com.freddans.popcorn.entities.TvShow;
import com.freddans.popcorn.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tvshows")
public class TvShowController {

    private TvShowService tvShowService;

    @Autowired
    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/latest")
    public ResponseEntity<List<TvShow>> getTenMostRecentAddedTvShows() {
        return ResponseEntity.ok(tvShowService.findTenMostRecentAddedTvShows());
    }
}
