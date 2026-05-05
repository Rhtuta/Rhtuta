package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.MovieDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Movie;
import com.cfs.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieDto createMovie(MovieDto movieDto)
    {
        Movie movie = mapToEntity(movieDto);
        Movie saveMovie = movieRepository.save(movie);
        return mapToDto(saveMovie);
    }

    public MovieDto getMovieById(Long id)
    {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie not found with id:- "+id));
        return mapToDto(movie);
    }

    public List<MovieDto>  getAllMovies()
    {
        List<Movie> movies = movieRepository.findAll();
                return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto>  getMoviesByLanguage(String language)
    {
        List<Movie> movies = movieRepository.findByLanguage(language);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto>  getMoviesByGenre(String genre)
    {
        List<Movie> movies = movieRepository.findByGenre(genre);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto>  searchMovies(String title)
    {
        List<Movie> movies = movieRepository.findByTitleContaining(title);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public MovieDto updateMovie(Long id, MovieDto movieDto)
    {
        Movie movie = movieRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Movie not found with id:- "+id));
        movie.setId(movieDto.getId());
        movie.setDescription(movieDto.getDescription());
        movie.setGenre(movieDto.getGenre());
        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setDurationMins(movieDto.getDurationMins());
        movie.setPosterUrl(movieDto.getPosterUrl());
        Movie updatedMovie = movieRepository.save(movie);
        return mapToDto(updatedMovie);
    }

    public void deleteMovie(Long id)
    {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie not found with id:- "+id));
        movieRepository.delete(movie);
    }

    private MovieDto mapToDto(Movie movie)
    {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setDescription(movie.getDescription());
        movieDto.setGenre(movie.getGenre());
        movieDto.setTitle(movie.getTitle());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setDurationMins(movie.getDurationMins());
        movieDto.setPosterUrl(movie.getPosterUrl());
        return movieDto;
    }

    public Movie mapToEntity(MovieDto movieDto)
    {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setDescription(movieDto.getDescription());
        movie.setGenre(movieDto.getGenre());
        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setDurationMins(movieDto.getDurationMins());
        movie.setPosterUrl(movieDto.getPosterUrl());
        return movie;
    }
}
