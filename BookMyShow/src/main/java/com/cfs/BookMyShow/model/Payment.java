package com.cfs.BookMyShow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    private String paymentId;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private Double amount;

    private String paymentMethod;

    @Column(nullable = false)
    private String status;

    @OneToOne(mappedBy = "payment")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}