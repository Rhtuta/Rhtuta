package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.BookingDto;
import com.cfs.BookMyShow.dto.BookingRequestDto;
import com.cfs.BookMyShow.dto.PaymentDto;
import com.cfs.BookMyShow.model.Payment;
import com.cfs.BookMyShow.service.BookingService;
import com.razorpay.RazorpayException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping("/bookings")
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingRequestDto bookingRequest) throws RazorpayException {
        return new ResponseEntity<>(bookingService.createBooking(bookingRequest), HttpStatus.CREATED);
    }

    @GetMapping("/admin/bookings")
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/bookings/my")
    public ResponseEntity<List<BookingDto>> getMyBookings() {
        return ResponseEntity.ok(bookingService.getMyBookings());
    }

    @GetMapping("/admin/bookings/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id)
    {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping("/admin/bookings/bookingNumber/{bookingNumber}")
    public ResponseEntity<BookingDto> getBookingByBookingNumber(@PathVariable String bookingNumber)
    {
        return ResponseEntity.ok(bookingService.getBookingByBookingNumber(bookingNumber));
    }

    @GetMapping("/admin/bookings/user")
    public ResponseEntity<List<BookingDto>> getBookingByUserId(@RequestParam Long userId)
    {
        return ResponseEntity.ok(bookingService.getBookingByUserId(userId));
    }

    @PatchMapping("/bookings/cancel/{id}")
    public ResponseEntity<BookingDto> cancelBooking(@PathVariable Long id)
    {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }
}
