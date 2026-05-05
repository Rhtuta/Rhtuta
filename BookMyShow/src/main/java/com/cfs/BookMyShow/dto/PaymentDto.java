package com.cfs.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;
    private LocalDateTime paymentTime;
    private String transactionId;
    private String paymentMethod;
    private Double amount;
    private String status;
}
