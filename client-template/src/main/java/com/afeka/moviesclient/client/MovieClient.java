package com.afeka.moviesclient.client;

import com.afeka.moviesclient.model.Movie;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

/**
 * ════════════════════════════════════════════════════════════════
 *  משימה 3 — MovieClient (קריאות HTTP מהלקוח לשרת)
 * ════════════════════════════════════════════════════════════════
 *
 * השלימו את המתודות המסומנות ב-TODO.
 * getMethods הראשונה (getAllMovies) נתונה כדוגמה.
 *
 * תבנית כללית של RestClient:
 *
 *   restClient
 *     .get() / .post() / .put() / .delete()
 *     .uri("/api/v1/movies")          ← נתיב
 *     .body(object)                   ← רק ב-POST/PUT
 *     .retrieve()
 *     .body(Movie.class)              ← אובייקט בודד
 *     OR
 *     .body(new ParameterizedTypeReference<List<Movie>>() {})  ← רשימה
 *     OR
 *     .toEntity(Movie.class)          ← כולל status code + headers
 *     OR
 *     .toBodilessEntity()             ← כשאין גוף (DELETE → 204)
 */
@Component
public class MovieClient {

    private final RestClient restClient;

    public MovieClient(RestClient restClient) {
        this.restClient = restClient;
    }

    // ── מוכן לדוגמה — GET כל הסרטים ─────────────────────────────────────
    public List<Movie> getAllMovies() {
        return restClient
                .get()
                .uri("/api/v1/movies")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Movie>>() {});
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 3א — GET סרט לפי ID
    // ════════════════════════════════════════════════════════════════════════
    /**
     * שלחו GET ל- /api/v1/movies/{id}
     * אם השרת מחזיר 404 — תחזירו Optional.empty()
     * אחרת — תחזירו Optional.of(movie)
     *
     * רמז:
     *   try {
     *       Movie m = restClient.get()
     *           .uri("/api/v1/movies/{id}", id)
     *           .retrieve()
     *           .body(Movie.class);
     *       return Optional.ofNullable(m);
     *   } catch (HttpClientErrorException.NotFound e) {
     *       return Optional.empty();
     *   }
     */
    public Optional<Movie> getMovieById(Long id) {
        // TODO: מחקו את השורה הבאה וכתבו מימוש
        throw new UnsupportedOperationException("TODO: implement getMovieById");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 3ב — GET סרטים לפי ז'אנר
    // ════════════════════════════════════════════════════════════════════════
    /**
     * שלחו GET ל- /api/v1/movies?genre={genre}
     * החזירו List<Movie>
     *
     * רמז: .uri("/api/v1/movies?genre={genre}", genre)
     */
    public List<Movie> getMoviesByGenre(String genre) {
        // TODO: מחקו את השורה הבאה וכתבו מימוש
        throw new UnsupportedOperationException("TODO: implement getMoviesByGenre");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 3ג — POST יצירת סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * שלחו POST ל- /api/v1/movies עם גוף ה-Movie
     * החזירו את ה-Movie שנוצר (כולל ה-ID שהוקצה על ידי השרת)
     *
     * השתמשו ב- .toEntity(Movie.class) כדי לקבל ResponseEntity
     * ואז הדפיסו את ה-status code וה-Location header (אופציונלי)
     *
     * רמז:
     *   ResponseEntity<Movie> response = restClient.post()
     *       .uri("/api/v1/movies")
     *       .body(movie)
     *       .retrieve()
     *       .toEntity(Movie.class);
     *   return response.getBody();
     */
    public Movie createMovie(Movie movie) {
        // TODO: מחקו את השורה הבאה וכתבו מימוש
        throw new UnsupportedOperationException("TODO: implement createMovie");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 3ד — DELETE מחיקת סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * שלחו DELETE ל- /api/v1/movies/{id}
     * אין גוף בתשובה (204 No Content) — השתמשו ב- .toBodilessEntity()
     */
    public void deleteMovie(Long id) {
        // TODO: מחקו את השורה הבאה וכתבו מימוש
        throw new UnsupportedOperationException("TODO: implement deleteMovie");
    }
}
