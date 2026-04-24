package com.afeka.moviesclient.runner;

import com.afeka.moviesclient.client.MovieClient;
import com.afeka.moviesclient.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DemoRunner implements CommandLineRunner {

    private final MovieClient movieClient;

    public DemoRunner(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n================================================");
        System.out.println("  MOVIES CLIENT DEMO");
        System.out.println("================================================\n");

        // ── Step 1: GET all movies (provided) ────────────────────────────────
        System.out.println("[GET] Fetching all movies...");
        List<Movie> movies = movieClient.getAllMovies();
        movies.forEach(m -> System.out.println("  -> " + m));

        // ── Task 4a: GET by ID ────────────────────────────────────────────────
        System.out.println("\n[GET] Fetching movie with ID=1...");
        Optional<Movie> movie = movieClient.getMovieById(1L);
        movie.ifPresentOrElse(
                m -> System.out.println("  -> Found: " + m),
                () -> System.out.println("  -> Not found (404)")
        );

        // ── Task 4b: GET by genre ─────────────────────────────────────────────
        System.out.println("\n[GET] Fetching Sci-Fi movies...");
        List<Movie> scifi = movieClient.getMoviesByGenre("Sci-Fi");
        scifi.forEach(m -> System.out.println("  -> " + m));

        // ── Task 4c: POST create ──────────────────────────────────────────────
        System.out.println("\n[POST] Creating a new movie...");
        Movie newMovie = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, "Crime", 8.9);
        Movie created = movieClient.createMovie(newMovie);
        System.out.println("  -> Created: " + created);
        Long newId = created.getId();

        // ── Task 4d: DELETE ───────────────────────────────────────────────────
        System.out.println("\n[DELETE] Deleting movie id=" + newId + "...");
        movieClient.deleteMovie(newId);
        System.out.println("  -> Deleted successfully");

        // ── Task 4e: Verify 404 ───────────────────────────────────────────────
        System.out.println("\n[GET] Verifying deletion (expect 404)...");
        Optional<Movie> gone = movieClient.getMovieById(newId);
        gone.ifPresentOrElse(
                m -> System.out.println("  -> Still exists? " + m),
                () -> System.out.println("  -> Confirmed 404 - movie was deleted")
        );

        System.out.println("\n================================================");
        System.out.println("  DEMO COMPLETE");
        System.out.println("================================================\n");
    }
}
