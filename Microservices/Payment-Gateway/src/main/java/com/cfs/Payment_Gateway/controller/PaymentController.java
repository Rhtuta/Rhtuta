package com.cfs.Payment_Gateway.controller;

import com.cfs.Payment_Gateway.entity.PaymentOrder;
import com.cfs.Payment_Gateway.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService service;
    
    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestBody PaymentOrder orderdetails){
        System.out.println("inside controller..........");
        try {
            String response = service.createOrder(orderdetails);
            return ResponseEntity.ok(response);
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error in creating order");
        }
    }

    @PostMapping("/update-order")
    public ResponseEntity<String> updateOrderStatus(@RequestParam String paymentId,
                                                    @RequestParam String orderId,
                                                    @RequestParam String status){
        service.updateOrderStatus(paymentId,orderId,status);
        System.out.println("Email sent successfully");
        return ResponseEntity.ok("order updated successfully");
    }
}
