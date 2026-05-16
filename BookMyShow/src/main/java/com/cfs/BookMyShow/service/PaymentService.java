package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Booking;
import com.cfs.BookMyShow.model.Payment;
import com.cfs.BookMyShow.repository.BookingRepository;
import com.cfs.BookMyShow.repository.PaymentRepository;
import com.cfs.BookMyShow.repository.ShowSeatRepository;
import com.cfs.BookMyShow.security.AuthUtil;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import jakarta.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private EmailService emailService;

    public Order createOrder(Payment orderDetails)
            throws RazorpayException {

        RazorpayClient client =
                new RazorpayClient(keyId, keySecret);

        JSONObject orderRequest = new JSONObject();

        orderRequest.put(
                "amount",
                orderDetails.getAmount() * 100
        );

        orderRequest.put("currency", "INR");

        orderRequest.put(
                "receipt",
                "txn_" + UUID.randomUUID()
        );

        Order razorpayOrder =
                client.orders.create(orderRequest);

        orderDetails.setOrderId(
                razorpayOrder.get("id")
        );

        orderDetails.setStatus("CREATED");

        paymentRepo.save(orderDetails);

        return razorpayOrder;
    }

    @Transactional
    public void updateOrderStatus(
            String paymentId,
            String orderId,
            String status,
            String paymentMethod
    ) {

        Payment order =
                paymentRepo.findByOrderId(orderId);

        if (order == null) {

            throw new ResourceNotFoundException(
                    "Payment not found"
            );
        }



        order.setPaymentId(paymentId);

        order.setStatus(status);

        order.setPaymentMethod(paymentMethod);

        Booking booking = order.getBooking();

        // SUCCESS
        if ("SUCCESS".equalsIgnoreCase(status)) {

            booking.setStatus("CONFIRMED");

            booking.getShowSeats().forEach(seat -> {

                seat.setStatus("BOOKED");

                seat.setBooking(booking);

            });

            showSeatRepository.saveAll(
                    booking.getShowSeats()
            );

            emailService.sendEmail(
                    order.getUser().getEmail(),
                    order.getUser().getName(),
                    order.getAmount(),
                    booking
            );
        }

        // FAILURE
        else {

            booking.setStatus("FAILED");

            booking.getShowSeats().forEach(seat -> {

                seat.setStatus("AVAILABLE");


            });

            showSeatRepository.saveAll(
                    booking.getShowSeats()
            );
        }

        bookingRepository.save(booking);

        paymentRepo.save(order);
    }

    public String getKeyId() {

        return keyId;
    }
}