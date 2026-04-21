package com.afeka.moviesapi.service;

import com.afeka.moviesapi.dto.MovieDto;
import com.afeka.moviesapi.exception.MovieNotFoundException;
import com.afeka.moviesapi.model.Movie;
import com.afeka.moviesapi.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ════════════════════════════════════════════════════════════════
 *  משימה 1 — MovieService (שכבת הלוגיקה העסקית)
 * ════════════════════════════════════════════════════════════════
 *
 * עליכם להשלים את המתודות שמסומנות ב-TODO.
 * המתודות השלמות (findByDirector, findByGenre) נשארות כמו שהן — לדוגמה.
 *
 * הנחיה: כל מתודה שמחזירה DTO צריכה להשתמש ב-MovieDto.from(movie).
 * כל מתודה שיוצרת Entity צריכה להשתמש ב-dto.toEntity().
 */
@Service
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // ── מתודה מוכנה לדוגמה — קראו וה בינו אותה ────────────────────────────
    public List<MovieDto> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(MovieDto::from)
                .toList();
    }

    // ── מתודה מוכנה לדוגמה ────────────────────────────────────────────────
    public List<MovieDto> findByDirector(String director) {
        return movieRepository.findByDirector(director)
                .stream()
                .map(MovieDto::from)
                .toList();
    }

    public List<MovieDto> findByGenre(String genre) {
        return movieRepository.findByGenre(genre)
                .stream()
                .map(MovieDto::from)
                .toList();
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 1א — מימוש findById
    // ════════════════════════════════════════════════════════════════════════
    /**
     * מצא סרט לפי ID.
     * אם הסרט לא קיים — זרוק MovieNotFoundException.
     *
     * רמז: השתמשו ב- movieRepository.findById(id)
     *       ואז ב- .map(MovieDto::from)
     *       ואז ב- .orElseThrow(() -> new MovieNotFoundException(id))
     */
    public MovieDto findById(Long id) {
        // TODO: החליפו את השורה הבאה במימוש אמיתי
        throw new UnsupportedOperationException("TODO: implement findById");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 1ב — מימוש create
    // ════════════════════════════════════════════════════════════════════════
    /**
     * צור סרט חדש ושמור ב-DB.
     * החזר את ה-DTO של הסרט שנשמר (כולל ה-ID שהוקצה).
     *
     * רמז: השתמשו ב- dto.toEntity() כדי לקבל Movie
     *       ואז ב- movieRepository.save(movie)
     *       ואז ב- MovieDto.from(saved)
     */
    @Transactional
    public MovieDto create(MovieDto dto) {
        // TODO: החליפו את השורה הבאה במימוש אמיתי
        throw new UnsupportedOperationException("TODO: implement create");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 1ג — מימוש update
    // ════════════════════════════════════════════════════════════════════════
    /**
     * עדכן סרט קיים.
     * אם הסרט לא קיים — זרוק MovieNotFoundException.
     *
     * רמז: 1. מצאו את הסרט עם findById (ו-orElseThrow)
     *       2. עדכנו את השדות: title, director, year, genre, rating
     *       3. Spring שומר אוטומטית בסוף ה-@Transactional — אין צורך ב-save!
     *       4. החזירו MovieDto.from(existing)
     */
    @Transactional
    public MovieDto update(Long id, MovieDto dto) {
        // TODO: החליפו את השורה הבאה במימוש אמיתי
        throw new UnsupportedOperationException("TODO: implement update");
    }

    // ════════════════════════════════════════════════════════════════════════
    // TODO משימה 1ד — מימוש delete
    // ════════════════════════════════════════════════════════════════════════
    /**
     * מחק סרט לפי ID.
     * אם הסרט לא קיים — זרוק MovieNotFoundException.
     *
     * רמז: 1. בדקו עם movieRepository.existsById(id)
     *       2. אם לא קיים — זרוק MovieNotFoundException
     *       3. אם קיים — קראו ל- movieRepository.deleteById(id)
     */
    @Transactional
    public void delete(Long id) {
        // TODO: החליפו את השורה הבאה במימוש אמיתי
        throw new UnsupportedOperationException("TODO: implement delete");
    }
}
