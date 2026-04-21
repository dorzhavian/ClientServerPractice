package com.afeka.moviesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * נזרקת כאשר סרט עם ה-ID המבוקש לא קיים.
 * Spring מחזיר אוטומטית HTTP 404 Not Found.
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
public class MovieNotFoundException extends ResponseStatusException {

    public MovieNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Movie not found with id: " + id);
    }
}
