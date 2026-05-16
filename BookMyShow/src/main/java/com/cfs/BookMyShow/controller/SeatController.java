package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.SeatDto;
import com.cfs.BookMyShow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/admin/seats/{screenId}")
    public ResponseEntity<SeatDto> createSeat(
            @PathVariable Long screenId,
            @RequestBody SeatDto seatDto
    ) {

        return new ResponseEntity<>(
                seatService.createSeat(
                        screenId,
                        seatDto
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/seats/screen/{screenId}")
    public ResponseEntity<List<SeatDto>> getSeatsByScreen(
            @PathVariable Long screenId
    ) {

        return ResponseEntity.ok(
                seatService.getSeatsByScreen(screenId)
        );
    }
}