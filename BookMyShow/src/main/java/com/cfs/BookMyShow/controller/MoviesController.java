package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.BookingDto;
import com.cfs.BookMyShow.dto.BookingRequestDto;
import com.cfs.BookMyShow.dto.MovieDto;
import com.cfs.BookMyShow.service.BookingService;
import com.cfs.BookMyShow.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/admin/movies")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto)
    {
        return new ResponseEntity<>(movieService.createMovie(movieDto), HttpStatus.CREATED);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAllMovies()
    {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/language/{language}")
    public ResponseEntity<List<MovieDto>> getMoviesByLanguage(@PathVariable String language)
    {

        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable String genre)
    {

        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/movies/title/{title}")
    public ResponseEntity<List<MovieDto>> searchMovies(@PathVariable String title)
    {

        return ResponseEntity.ok(movieService.searchMovies(title));
    }

    @PatchMapping("/admin/movies/update")
    public ResponseEntity<MovieDto> updateMovie(@RequestParam Long id, @RequestBody MovieDto movieDto)
    {
        return ResponseEntity.ok(movieService.updateMovie(id, movieDto));
    }

    @DeleteMapping("/admin/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id)
    {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
