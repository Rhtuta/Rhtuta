package com.cfs.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long id;
    private String bookingNumber;
    private String status;
    private LocalDateTime bookingTime;
    private Double totalAmount;
    private UserDto user;
    private ShowDto show;
    private List<ShowSeatDto> seats;
    private PaymentDto payment;
    private String razorpayOrderId;
    private String razorpayKey;
    private Double razorpayAmount;
}
