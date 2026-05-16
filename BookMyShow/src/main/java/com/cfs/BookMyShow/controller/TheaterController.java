package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.TheaterDto;
import com.cfs.BookMyShow.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/admin/theaters")
    public ResponseEntity<TheaterDto> createTheater(@Valid @RequestBody TheaterDto theaterDto)
    {
        return new ResponseEntity<>(theaterService.createTheater(theaterDto), HttpStatus.CREATED);
    }

    @GetMapping("/theaters")
    public ResponseEntity<List<TheaterDto>> getAllTheaters()
    {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/admin/theaters/{id}")
    public ResponseEntity<TheaterDto> getTheaterById(@PathVariable Long id)
    {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/theaters/city/{city}")
    public ResponseEntity<List<TheaterDto>> getAllTheatersByCity(@PathVariable String city)
    {
        return ResponseEntity.ok(theaterService.getAllTheatersByCity(city));
    }

    @PatchMapping("/admin/theaters/update")
    public ResponseEntity<TheaterDto> updateTheater(@RequestParam Long id, @RequestBody TheaterDto theaterDto)
    {
        return ResponseEntity.ok(theaterService.updateTheater(id,theaterDto));
    }

    @DeleteMapping("/admin/theaters/delete/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable Long id)
    {
        theaterService.deleteTheater(id);
        return ResponseEntity.ok("Theater deleted successfully");
    }
}
