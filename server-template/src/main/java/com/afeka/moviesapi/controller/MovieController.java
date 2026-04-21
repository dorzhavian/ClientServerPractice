package com.afeka.moviesapi.controller;

import com.afeka.moviesapi.dto.MovieDto;
import com.afeka.moviesapi.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * ════════════════════════════════════════════════════════════════
 *  משימה 2 — MovieController (שכבת ה-HTTP / REST)
 * ════════════════════════════════════════════════════════════════
 *
 * Base URL: http://localhost:<port>/api/v1/movies
 *
 * עליכם להשלים את ה-endpoints שמסומנים ב-TODO.
 * ה-endpoint הראשון (GET /movies) נתון כדוגמה.
 *
 * זכרו:
 *   - @GetMapping    → HTTP GET
 *   - @PostMapping   → HTTP POST  (יצירה → 201 Created)
 *   - @PutMapping    → HTTP PUT   (עדכון → 200 OK)
 *   - @DeleteMapping → HTTP DELETE (מחיקה → 204 No Content)
 *   - @PathVariable  → פרמטר מה-URI:  /movies/{id}
 *   - @RequestBody   → גוף ה-request (JSON → Java)
 *   - @RequestParam  → query string:  /movies?genre=Action
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // ── מוכן לדוגמה — GET כל הסרטים ─────────────────────────────────────
    @GetMapping
    public List<MovieDto> listMovies(
            @RequestParam(required = false) String director,
            @RequestParam(required = false) String genre) {

        if (director != null) return movieService.findByDirector(director);
        if (genre    != null) return movieService.findByGenre(genre);
        return movieService.findAll();
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2א — GET סרט לפי ID
    // ════════════════════════════════════════════════════════════════════════
    /**
     * החזירו סרט בודד לפי ID.
     * אם לא קיים — השירות זורק MovieNotFoundException ו-Spring מחזיר 404.
     *
     * רמז: @GetMapping("/{id}")
     *       public MovieDto getMovie(@PathVariable Long id) { ... }
     */
    // TODO: הוסיפו כאן את ה-endpoint


    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ב — POST יצירת סרט חדש
    // ════════════════════════════════════════════════════════════════════════
    /**
     * קבלו MovieDto מגוף הבקשה, שמרו, והחזירו 201 Created.
     * כללו Location header שמצביע על ה-URI של הסרט החדש.
     *
     * חתימה מלאה:
     *   @PostMapping
     *   public ResponseEntity<MovieDto> createMovie(
     *       @RequestBody @Valid MovieDto dto,
     *       UriComponentsBuilder ucb)
     *
     * רמז ל-Location header:
     *   URI location = ucb.path("/api/v1/movies/{id}")
     *                     .buildAndExpand(saved.getId())
     *                     .toUri();
     *   return ResponseEntity.created(location).body(saved);
     */
    // TODO: הוסיפו כאן את ה-endpoint


    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ג — PUT עדכון סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * קבלו ID ב-path וגוף מעודכן ב-body. עדכנו והחזירו 200 OK.
     *
     * רמז: @PutMapping("/{id}")
     *       public MovieDto updateMovie(@PathVariable Long id,
     *                                   @RequestBody @Valid MovieDto dto)
     */
    // TODO: הוסיפו כאן את ה-endpoint


    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 2ד — DELETE מחיקת סרט
    // ════════════════════════════════════════════════════════════════════════
    /**
     * מחקו סרט לפי ID. החזירו 204 No Content.
     *
     * רמז: @DeleteMapping("/{id}")
     *       public ResponseEntity<Void> deleteMovie(@PathVariable Long id)
     *
     * לאחר movieService.delete(id):
     *   return ResponseEntity.noContent().build();
     */
    // TODO: הוסיפו כאן את ה-endpoint
}
