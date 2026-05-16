package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.model.Booking;
import com.cfs.BookMyShow.model.ShowSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(
            String toEmail,
            String name,
            double amount,
            Booking booking
    ) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);

        mailMessage.setSubject(
                "🎟️ Booking Confirmed - " +
                        booking.getShow().getMovie().getTitle()
        );

        // Get seats list
        List<String> seats = booking.getShowSeats()
                .stream()
                .map(showSeat ->
                        showSeat.getSeat().getSeatNumber())
                .collect(Collectors.toList());

        String seatNumbers = String.join(", ", seats);

        String movieName =
                booking.getShow().getMovie().getTitle();

        String theaterName =
                booking.getShow()
                        .getScreen()
                        .getTheater()
                        .getName();

        String screenName =
                booking.getShow()
                        .getScreen()
                        .getName();

        String city =
                booking.getShow()
                        .getScreen()
                        .getTheater()
                        .getCity();

        String showTime =
                booking.getShow()
                        .getStartTime()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "dd MMM yyyy hh:mm a"
                                )
                        );

        String bookingNumber =
                booking.getBookingNumber();

        String message =
                "Hi " + name + ",\n\n" +

                        "🎉 Your movie ticket booking has been confirmed successfully.\n\n" +

                        "==============================\n" +
                        "BOOKING DETAILS\n" +
                        "==============================\n\n" +

                        "🎬 Movie: " + movieName + "\n" +
                        "🏢 Theater: " + theaterName + "\n" +
                        "🖥️ Screen: " + screenName + "\n" +
                        "📍 City: " + city + "\n" +
                        "🕒 Show Time: " + showTime + "\n" +
                        "💺 Seats: " + seatNumbers + "\n" +
                        "🎟️ Booking ID: " + bookingNumber + "\n" +
                        "💰 Total Paid: ₹" + amount + "\n\n" +

                        "Please show this booking confirmation at the theater entrance.\n\n" +

                        "Enjoy your movie 🍿\n\n" +

                        "Regards,\n" +
                        "Rohit Kumar from BookMYShow App.";

        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
}