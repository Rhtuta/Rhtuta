package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.ScreenDto;
import com.cfs.BookMyShow.service.ScreenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping("/admin/screens")
    public ResponseEntity<ScreenDto> createScreen(
            @Valid @RequestBody ScreenDto screenDto
    )
    {
        return new ResponseEntity<>(
                screenService.createScreen(screenDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/screens/{id}")
    public ResponseEntity<ScreenDto> getScreenById(
            @PathVariable Long id
    )
    {
        return ResponseEntity.ok(
                screenService.getScreenById(id)
        );
    }

    @GetMapping("/screens")
    public ResponseEntity<List<ScreenDto>> getAllScreens()
    {
        return ResponseEntity.ok(
                screenService.getAllScreens()
        );
    }

    @GetMapping("/screens/theater/{theaterId}")
    public ResponseEntity<List<ScreenDto>>
    getScreensByTheater(
            @PathVariable Long theaterId
    )
    {
        return ResponseEntity.ok(
                screenService.getScreensByTheater(
                        theaterId
                )
        );
    }

    @PatchMapping("/admin/screens/update")
    public ResponseEntity<ScreenDto> updateScreen(
            @RequestParam Long id,
            @RequestBody ScreenDto screenDto
    )
    {
        return ResponseEntity.ok(
                screenService.updateScreen(
                        id,
                        screenDto
                )
        );
    }

    @DeleteMapping("/admin/screens/delete/{id}")
    public ResponseEntity<String> deleteScreen(
            @PathVariable Long id
    )
    {
        screenService.deleteScreen(id);

        return ResponseEntity.ok(
                "Screen deleted successfully"
        );
    }
}