package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.*;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.exception.SeatUnavailableException;
import com.cfs.BookMyShow.model.*;
import com.cfs.BookMyShow.repository.BookingRepository;
import com.cfs.BookMyShow.repository.ShowRepository;
import com.cfs.BookMyShow.repository.ShowSeatRepository;
import com.cfs.BookMyShow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public BookingDto createBooking(BookingRequestDto bookingRequest){
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("user not found"));

        Show show = showRepository.findById(bookingRequest.getShowId())
                .orElseThrow(()-> new ResourceNotFoundException("show not found"));

        List<ShowSeat> selectedSeats = showSeatRepository.findAllById(bookingRequest.getSeatIds());
        for (ShowSeat seat : selectedSeats)
        {
            if (!"AVAILABLE".equals(seat.getStatus()))
            {
                throw new SeatUnavailableException("Seat "+seat.getSeat().getSeatNumber()+" is not available");
            }

            seat.setStatus("LOCKED");
        }
        showSeatRepository.saveAll(selectedSeats);

        Double totalAmount = selectedSeats.stream()
                .mapToDouble(ShowSeat::getPrice)
                .sum();

        Payment payment = new Payment();
        payment.setStatus("SUCCESS");
        payment.setPaymentTime(LocalDateTime.now());
        payment.setAmount(totalAmount);
        payment.setPaymentMethod(bookingRequest.getPaymentMethod());
        payment.setTransactionId(UUID.randomUUID().toString());

        Booking saveBooking = new Booking();
        saveBooking.setBookingTime(LocalDateTime.now());
        saveBooking.setShow(show);
        saveBooking.setUser(user);
        saveBooking.setTotalAmount(totalAmount);
        saveBooking.setPayment(payment);
        saveBooking.setBookingNumber(UUID.randomUUID().toString());
        saveBooking.setStatus("CONFIRMED");

        bookingRepository.save(saveBooking);

        selectedSeats.forEach(seat ->
        {
            seat.setStatus("BOOKED");
            seat.setBooking(saveBooking);
        });
        showSeatRepository.saveAll(selectedSeats);
        return mapToBookingDto(saveBooking,selectedSeats);
    }

    public  BookingDto getBookingById(Long id){
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("booking not found"));
        List<ShowSeat> seats = showSeatRepository.findAll()
                .stream()
                .filter(seat-> seat.getBooking()!=null && seat.getBooking().getId().equals(booking.getId()))
                .collect(Collectors.toList());

                return mapToBookingDto(booking,seats);
    }

    public  BookingDto getBookingByBookingNumber(String bookingNumber){
        Booking booking = bookingRepository.findByBookingNumber(bookingNumber)
                .orElseThrow(()->new ResourceNotFoundException("booking not found"));
        List<ShowSeat> seats = showSeatRepository.findAll()
                .stream()
                .filter(seat-> seat.getBooking()!=null && seat.getBooking().getId().equals(booking.getId()))
                .collect(Collectors.toList());

        return mapToBookingDto(booking,seats);
    }

    public  List<BookingDto> getBookingByUserId(Long userId){
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream()
                .map(booking -> {
                    List<ShowSeat> seats = showSeatRepository.findAll()
                            .stream()
                            .filter(seat->seat.getBooking()!=null && seat.getBooking().getId().equals(booking.getId()))
                            .collect(Collectors.toList());

                    return mapToBookingDto(booking,seats);
                })
                .collect(Collectors.toList());
    }

    public BookingDto cancelBooking(Long id)
    {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Booking not found"));
        List<ShowSeat> seats = showSeatRepository.findAll()
                .stream()
                .filter(seat->seat.getBooking()!=null && seat.getBooking().getId().equals(booking.getId()))
                .collect(Collectors.toList());

        seats.forEach(seat->{
            seat.setStatus("AVAILABLE");
            seat.setBooking(null);
        });

        if (booking.getPayment()!=null)
        {
            booking.getPayment().setStatus("REFUNDED");
        }

        Booking updatedBooking = bookingRepository.save(booking);
        showSeatRepository.saveAll(seats);

        return mapToBookingDto(updatedBooking,seats);
    }

    private BookingDto mapToBookingDto(Booking booking, List<ShowSeat> seats)
    {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingNumber(booking.getBookingNumber());
        bookingDto.setBookingTime(booking.getBookingTime());
        bookingDto.setId(booking.getId());
        bookingDto.setTotalAmount(booking.getTotalAmount());
        bookingDto.setStatus(booking.getStatus());


        UserDto userDto = new UserDto();
        userDto.setId(booking.getUser().getId());
        userDto.setName(booking.getUser().getName());
        userDto.setEmail(booking.getUser().getEmail());
        userDto.setPhoneNumber(booking.getUser().getPhoneNumber());
        bookingDto.setUser(userDto);

        ShowDto showDto = new ShowDto();
        showDto.setId(booking.getShow().getId());
        showDto.setEndTime(booking.getShow().getEndTime());
        showDto.setStartTime(booking.getShow().getStartTime());

        MovieDto movieDto = new MovieDto();
        movieDto.setDescription(booking.getShow().getMovie().getDescription());
        movieDto.setId(booking.getShow().getMovie().getId());
        movieDto.setGenre(booking.getShow().getMovie().getGenre());
        movieDto.setTitle(booking.getShow().getMovie().getTitle());
        movieDto.setDurationMins(booking.getShow().getMovie().getDurationMins());
        movieDto.setPosterUrl(booking.getShow().getMovie().getPosterUrl());
        movieDto.setReleaseDate(booking.getShow().getMovie().getReleaseDate());
        movieDto.setLanguage(booking.getShow().getMovie().getLanguage());
        showDto.setMovie(movieDto);

        ScreenDto screenDto = new ScreenDto();
        screenDto.setId(booking.getShow().getScreen().getId());
        screenDto.setName(booking.getShow().getScreen().getName());
        screenDto.setTotalSeats(booking.getShow().getScreen().getTotalSeats());

        TheaterDto theaterDto = new TheaterDto();
        theaterDto.setId(booking.getShow().getScreen().getTheater().getId());
        theaterDto.setName(booking.getShow().getScreen().getTheater().getName());
        theaterDto.setCity(booking.getShow().getScreen().getTheater().getCity());
        theaterDto.setTotalScreens(booking.getShow().getScreen().getTheater().getTotalScreens());
        screenDto.setTheater(theaterDto);
        showDto.setScreen(screenDto);
        bookingDto.setShow(showDto);

        List<ShowSeatDto> seatDtos = seats.stream()
                .map(seat ->{
                    ShowSeatDto seatDto = new ShowSeatDto();
                    seatDto.setId(seat.getId());
                    seatDto.setPrice(seat.getPrice());
                    seatDto.setStatus(seat.getStatus());

                    SeatDto baseSeatDto = new SeatDto();
                    baseSeatDto.setId(seat.getSeat().getId());
                    baseSeatDto.setSeatNumber(seat.getSeat().getSeatNumber());
                    baseSeatDto.setBasePrice(seat.getSeat().getBasePrice());
                    baseSeatDto.setSeatType(seat.getSeat().getSeatType());
                    seatDto.setSeat(baseSeatDto);
                    return seatDto;
                })
                .collect(Collectors.toList());
        bookingDto.setSeats(seatDtos);

        if(booking.getPayment()!=null)
        {
            PaymentDto paymentDto = new PaymentDto();
            paymentDto.setId(booking.getPayment().getId());
            paymentDto.setStatus(booking.getPayment().getStatus());
            paymentDto.setPaymentMethod(booking.getPayment().getPaymentMethod());
            paymentDto.setAmount(booking.getPayment().getAmount());
            paymentDto.setTransactionId(booking.getPayment().getTransactionId());
            paymentDto.setPaymentTime(booking.getPayment().getPaymentTime());
            bookingDto.setPayment(paymentDto);
        }

        return bookingDto;
    }
}
