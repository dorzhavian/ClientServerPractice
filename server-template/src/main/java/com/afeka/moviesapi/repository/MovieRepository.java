package com.afeka.moviesapi.repository;

import com.afeka.moviesapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA Repository.
 * Spring מייצר את המימוש אוטומטית — אין צורך לכתוב SQL!
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Spring Data מייצר שאילתה מתוך שם המתודה:
    // SELECT * FROM movies WHERE director = ?
    List<Movie> findByDirector(String director);

    // SELECT * FROM movies WHERE genre = ?
    List<Movie> findByGenre(String genre);
}
