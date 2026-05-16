package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.BookingDto;
import com.cfs.BookMyShow.dto.BookingRequestDto;
import com.cfs.BookMyShow.dto.MovieDto;
import com.cfs.BookMyShow.dto.ShowDto;
import com.cfs.BookMyShow.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/admin/shows")
    public ResponseEntity<ShowDto> createShow(@Valid @RequestBody ShowDto showDto)
    {
        return new ResponseEntity<>(showService.createShow(showDto), HttpStatus.CREATED);
    }

    @GetMapping("/shows/{id}")
    public ResponseEntity<ShowDto> getShowById(@PathVariable Long id)
    {
        return ResponseEntity.ok(showService.getShowById(id));
    }


    @GetMapping("/shows")
    public ResponseEntity<List<ShowDto>> getAllShows()
    {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/shows/movie")
    public ResponseEntity<List<ShowDto>> getShowsByMovie(@RequestParam Long movieId)
    {
        return ResponseEntity.ok(showService.getShowsByMovie(movieId));
    }

    @GetMapping("/shows/filter")
    public ResponseEntity<List<ShowDto>> getShowsByMovieAndCity(@RequestParam Long movieId, @RequestParam String city)
    {
        return ResponseEntity.ok(showService.getShowsByMovieAndCity(movieId,city));
    }

    @GetMapping("/shows/range")
    public ResponseEntity<List<ShowDto>> getShowsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate)
    {
        return ResponseEntity.ok(showService.getShowsByDateRange(startDate,endDate));
    }
}
