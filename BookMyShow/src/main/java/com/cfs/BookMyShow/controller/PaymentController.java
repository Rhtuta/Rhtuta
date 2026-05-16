package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/update-order")
    public ResponseEntity<String> updateOrderStatus(
            @RequestParam String paymentId,
            @RequestParam String orderId,
            @RequestParam String status,
            @RequestParam String paymentMethod)
    {

        paymentService.updateOrderStatus(
                paymentId,
                orderId,
                status,
                paymentMethod
        );

        return ResponseEntity.ok(
                "Payment updated successfully"
        );
    }
}