package com.afeka.moviesclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * מייצג סרט בצד הלקוח.
 * @JsonIgnoreProperties מבטיח שאם השרת יחזיר שדות שאנחנו לא מכירים,
 * הלקוח לא יקרוס — הוא פשוט יתעלם מהם.
 *
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private Long   id;
    private String title;
    private String director;
    private int    year;
    private String genre;
    private double rating;

    public Movie() {}

    public Movie(String title, String director, int year, String genre, double rating) {
        this.title    = title;
        this.director = director;
        this.year     = year;
        this.genre    = genre;
        this.rating   = rating;
    }

    // Getters & Setters
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

    @Override
    public String toString() {
        return String.format("Movie{id=%d, title='%s', director='%s', year=%d, genre='%s', rating=%.1f}",
                             id, title, director, year, genre, rating);
    }
}
