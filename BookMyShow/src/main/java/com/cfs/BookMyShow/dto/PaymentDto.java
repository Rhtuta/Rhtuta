package com.cfs.BookMyShow.dto;

import com.cfs.BookMyShow.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;
    private LocalDateTime createAt;
    private String orderId;
    private String paymentMethod;
    private Double amount;
    private String status;
    private UserDto user;
}
