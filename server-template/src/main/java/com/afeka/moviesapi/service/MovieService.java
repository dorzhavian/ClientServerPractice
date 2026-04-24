package com.afeka.moviesapi.service;

import com.afeka.moviesapi.dto.MovieDto;
import com.afeka.moviesapi.exception.MovieNotFoundException;
import com.afeka.moviesapi.model.Movie;
import com.afeka.moviesapi.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(MovieDto::from)
                .toList();
    }

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

    // ── findById ─────────────────────────────────────────────────────

    public MovieDto findById(Long id) {
        return movieRepository.findById(id)
                .map(MovieDto::from)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    // ── create ───────────────────────────────────────────────────────

    @Transactional
    public MovieDto create(MovieDto dto) {
        Movie movie = dto.toEntity();
        Movie saved = movieRepository.save(movie);
        return MovieDto.from(saved);
    }

    // ── update ───────────────────────────────────────────────────────

    @Transactional
    public MovieDto update(Long id, MovieDto dto) {
        Movie existing = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));

        existing.setTitle(dto.getTitle());
        existing.setDirector(dto.getDirector());
        existing.setYear(dto.getYear());
        existing.setGenre(dto.getGenre());
        existing.setRating(dto.getRating());

        // No explicit save() needed — @Transactional detects the dirty entity
        return MovieDto.from(existing);
    }

    // ── delete ───────────────────────────────────────────────────────

    @Transactional
    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
    }
}
