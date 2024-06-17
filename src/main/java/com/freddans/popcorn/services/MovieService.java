package com.freddans.popcorn.services;

import com.freddans.popcorn.repositories.MovieRepository;
import com.freddans.popcorn.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        return optionalMovie.orElse(null);
    }

    public List<Movie> findTenMostRecentAddedMovies() {
        List<Movie> mostRecentMovies = new ArrayList<>();
        for (int i = movieRepository.findAll().size()-1; i > (movieRepository.findAll().size()-11); i--) {
            Movie movie = movieRepository.findAll().get(i);
            mostRecentMovies.add(movie);
        }

        return mostRecentMovies;
    }

    public Movie findMovieByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);

        if (movie != null) {
            return movie;
        } else {
            return null;
        }
    }

    public Movie createNewMovie(Movie newMovieInfo) {
        Movie existingMovie = findMovieByName(newMovieInfo.getName());

        if (existingMovie == null) {
            if (newMovieInfo.getName() != null && !newMovieInfo.getName().isEmpty()) {
                if (newMovieInfo.getGenre() != null && !newMovieInfo.getGenre().isEmpty()) {
                    Movie movie = new Movie(newMovieInfo.getName(), newMovieInfo.getGenre());

                    movieRepository.save(movie);

                    return movie;
                } else {
                    System.out.println("ERROR: Genre of movie was not provided");
                    return null;
                }
            } else {
                System.out.println("ERROR: Name of movie was not provided.");
                return null;
            }
        } else {
            System.out.println("ERROR: Movie already exist");
            return null;
        }
    }

    public Movie update(long id, Movie newMovieInfo) {
        Movie existingMovie = findMovieById(id);

        if (existingMovie != null) {
            if (newMovieInfo.getName() != null && !newMovieInfo.getName().isEmpty() && !newMovieInfo.getName().equals(existingMovie.getName())) {
                existingMovie.setName(newMovieInfo.getName());
            }
            if (newMovieInfo.getGenre() != null && !newMovieInfo.getGenre().isEmpty() && !newMovieInfo.getGenre().equals(existingMovie.getGenre())) {
                existingMovie.setGenre(newMovieInfo.getGenre());
            }
            if (newMovieInfo.getRating() != existingMovie.getRating()) {
                existingMovie.setRating(newMovieInfo.getRating());
            }
            if (newMovieInfo.getCoverPhoto() != null && !newMovieInfo.getCoverPhoto().isEmpty() && !newMovieInfo.getCoverPhoto().equals(existingMovie.getCoverPhoto())) {
                existingMovie.setCoverPhoto(newMovieInfo.getCoverPhoto());
            }
            if (newMovieInfo.getBackground() != null && !newMovieInfo.getBackground().isEmpty() && !newMovieInfo.getBackground().equals(existingMovie.getBackground())) {
                existingMovie.setBackground(newMovieInfo.getBackground());
            }
            if (newMovieInfo.getVideoUrl() != null && !newMovieInfo.getVideoUrl().isEmpty() && !newMovieInfo.getVideoUrl().equals(existingMovie.getVideoUrl())) {
                existingMovie.setVideoUrl(newMovieInfo.getVideoUrl());
            }

            movieRepository.save(existingMovie);

            return existingMovie;
        } else {
            System.out.println("ERROR: Movie with provided ID does not exist.");
            return null;
        }
    }
}
