package com.freddans.popcorn.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tvshows")
public class TvShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String genre;
    private double rating;
    private String coverPhoto;
    private String background;
    private String trailerUrl;
    private String videoUrl;

    public TvShow() {
    }

    public TvShow(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.rating = 0;
        this.coverPhoto = "/images/coverphotos/default.jpg";
        this.background = "/images/backgrounds/default.jpg";
        this.trailerUrl = "https://www.youtube.com";
        this.videoUrl = "/video/example.mp4";
    }

    public TvShow(String name, String genre, double rating, String coverPhoto, String background, String trailerUrl, String videoUrl) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.coverPhoto = coverPhoto;
        this.background = background;
        this.trailerUrl = trailerUrl;
        this.videoUrl = videoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
