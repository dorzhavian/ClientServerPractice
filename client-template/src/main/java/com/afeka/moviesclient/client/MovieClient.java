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
 *  משימה 2 — MovieClient (קריאות HTTP מהלקוח לשרת)
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
    // TODO משימה 2א — GET סרט לפי ID
    // ════════════════════════════════════════════════════════════════════════
    /**
     * send GET to - /api/v1/movies/{id}
     * שימו לב שהבקשה היא למשוך סרט לפי id
     * אם השרת מחזיר 404 — תחזירו ()Optional.empty
     * אחרת — תחזירו Optional.of(movie)
     *
     * רמז:
     * כדי להיעזר בהערות שמופיעות בשורות 14-35
     *  
     */
    public Optional<Movie> getMovieById(Long id) {
        /**
         try {
         *      // WRITE YOUR CODE HERE
         *       return Optional.ofNullable(movie);
         *   } catch (HttpClientErrorException.NotFound e) {
         *       return Optional.empty();
         *   }
         */
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ב — GET סרטים לפי ז'אנר
    // ════════════════════════════════════════════════════════════════════════
    /**
     *send GET to - /api/v1/movies?genre={genre}
     *החזירו List מסוג Movie
     *
     *רמז:
     * הקריאה GET דומה מאוד לקריאה בפונקציה getMovieById
     * אבל ההחזרה צריכה להתבצע בדומה לפונקציה ב- getAllMovies
     */
    public List<Movie> getMoviesByGenre(String genre) {
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ג — POST יצירת סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * send POST to - /api/v1/movies with the type of Movie
     * החזירו את ה-Movie שנוצר (כולל ה-ID שהוקצה על ידי השרת)
     *
     * השתמשו ב- .toEntity(Movie.class) כדי לקבל ResponseEntity
     * ואז הדפיסו את ה-status code וה-Location header (אופציונלי) וכבר ביצענו רק להוריד סימון הערה
     *
     * הנחיות:
     * עבוד לפי המבנה שהגדרנו בהערה בפונציה
     *
     */
    public Movie createMovie(Movie movie) {
        /**
         * ResponseEntity<Movie> response = restClient.
         *
         *  FILL UR CODE HERE
         *
         * System.out.println("  Server responded with: " + response.getStatusCode());
         * System.out.println("  Location: " + response.getHeaders().getLocation())
         * return response.getBody();
         *
         */

    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ד — DELETE מחיקת סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * send DELETE to /api/v1/movies/{id}
     * אין גוף בתשובה (204 No Content) — השתמשו ב- ()toBodilessEntity
     */
    public void deleteMovie(Long id) {

    }
}
