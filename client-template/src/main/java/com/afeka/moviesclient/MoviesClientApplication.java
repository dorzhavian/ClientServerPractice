package com.afeka.moviesclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * נקודת כניסה ללקוח.
 * ודאו שהשרת רץ לפני הפעלת הלקוח!
 */
@SpringBootApplication
public class MoviesClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoviesClientApplication.class, args);
    }
}
