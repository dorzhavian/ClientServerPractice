package com.afeka.moviesapi.dto;

import jakarta.validation.constraints.*;

/**
 * DTO — Data Transfer Object.
 * זה מה שנחשף ב-API. לא חושפים את ה-Entity ישירות!
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
public class MovieDto {

    private Long id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Director must not be blank")
    private String director;

    @Min(value = 1888, message = "Year must be 1888 or later")
    @Max(value = 2100, message = "Year must be 2100 or earlier")
    private int year;

    @NotBlank(message = "Genre must not be blank")
    private String genre;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 10, message = "Rating must be at most 10")
    private double rating;

    // ── Constructors ──────────────────────────────────────────────────────────
    public MovieDto() {}

    public MovieDto(Long id, String title, String director, int year, String genre, double rating) {
        this.id       = id;
        this.title    = title;
        this.director = director;
        this.year     = year;
        this.genre    = genre;
        this.rating   = rating;
    }

    // ── Static factory: Entity → DTO ─────────────────────────────────────────
    public static MovieDto from(Movie movie) {
        return new MovieDto(
            movie.getId(), movie.getTitle(), movie.getDirector(),
            movie.getYear(), movie.getGenre(), movie.getRating()
        );
    }

    // ── Convert DTO → Entity ──────────────────────────────────────────────────
    public Movie toEntity() {
        return new Movie(title, director, year, genre, rating);
    }

    // ── Getters & Setters ─────────────────────────────────────────────────────
    public Long   getId()                       { return id; }
    public void   setId(Long id)                { this.id = id; }
    public String getTitle()                    { return title; }
    public void   setTitle(String title)        { this.title = title; }
    public String getDirector()                 { return director; }
    public void   setDirector(String director)  { this.director = director; }
    public int    getYear()                     { return year; }
    public void   setYear(int year)             { this.year = year; }
    public String getGenre()                    { return genre; }
    public void   setGenre(String genre)        { this.genre = genre; }
    public double getRating()                   { return rating; }
    public void   setRating(double rating)      { this.rating = rating; }
}
