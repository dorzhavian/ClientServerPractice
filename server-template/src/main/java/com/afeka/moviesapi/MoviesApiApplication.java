package com.afeka.moviesapi;

import com.afeka.moviesapi.model.Movie;
import com.afeka.moviesapi.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class MoviesApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoviesApiApplication.class, args);
    }
}

/**
 * טוען נתוני דוגמה לבסיס הנתונים בהפעלה.
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
@Component
class DataSeeder implements CommandLineRunner {

    private final MovieRepository movieRepository;

    DataSeeder(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {
        movieRepository.saveAll(List.of(
            new Movie("The Shawshank Redemption", "Frank Darabont",    1994, "Drama",  9.3),
            new Movie("The Godfather",             "Francis Coppola",  1972, "Crime",  9.2),
            new Movie("Inception",                 "Christopher Nolan",2010, "Sci-Fi", 8.8),
            new Movie("Parasite",                  "Bong Joon-ho",     2019, "Thriller",8.5),
            new Movie("Interstellar",              "Christopher Nolan",2014, "Sci-Fi", 8.6),
            new Movie("The Matrix",                "Wachowski Sisters",1999, "Sci-Fi", 8.7)
        ));
        System.out.println("6 movies loaded into the database.");
        System.out.println("API ready at: http://localhost:" + port + "/api/v1/movies");
    }
}
