package com.freddans.popcorn.controllers;

import com.freddans.popcorn.entities.Movie;
import com.freddans.popcorn.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Movie>> getTenMostRecentAddedMovies() {
        return ResponseEntity.ok(movieService.findTenMostRecentAddedMovies());
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createNewMovie(movie));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> update(@PathVariable long id, @RequestBody Movie newMovieInfo) {
        return ResponseEntity.ok(movieService.update(id, newMovieInfo));
    }
}
