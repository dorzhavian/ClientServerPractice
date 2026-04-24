package com.afeka.moviesapi.model;

import jakarta.persistence.*;

/**
 * JPA Entity — מייצג סרט בבסיס הנתונים.
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(name = "release_year", nullable = false)
    private int year;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private double rating; // 1.0 – 10.0

    // ── Constructors ──────────────────────────────────────────────────────────
    public Movie() {}

    public Movie(String title, String director, int year, String genre, double rating) {
        this.title    = title;
        this.director = director;
        this.year     = year;
        this.genre    = genre;
        this.rating   = rating;
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
