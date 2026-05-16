package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.SeatDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Screen;
import com.cfs.BookMyShow.model.Seat;
import com.cfs.BookMyShow.model.Show;
import com.cfs.BookMyShow.model.ShowSeat;
import com.cfs.BookMyShow.repository.ScreenRepository;
import com.cfs.BookMyShow.repository.SeatRepository;
import com.cfs.BookMyShow.repository.ShowRepository;
import com.cfs.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;


    public SeatDto createSeat(
            Long screenId,
            SeatDto seatDto
    ) {

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found"
                        )
                );


        Seat seat = new Seat();

        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setSeatType(seatDto.getSeatType());
        seat.setBasePrice(seatDto.getBasePrice());
        seat.setScreen(screen);

        Seat savedSeat = seatRepository.save(seat);



        List<Show> shows =
                showRepository.findByScreenId(screenId);

        for (Show show : shows) {

            ShowSeat showSeat = new ShowSeat();

            showSeat.setShow(show);

            showSeat.setSeat(savedSeat);

            // use base price as default
            showSeat.setPrice(savedSeat.getBasePrice());

            // AVAILABLE by default
            showSeat.setStatus("AVAILABLE");

            showSeatRepository.save(showSeat);
        }

        return mapToDto(savedSeat);
    }

    public List<SeatDto> getSeatsByScreen(Long screenId) {

        List<Seat> seats =
                seatRepository.findByScreenId(screenId);

        return seats.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }



    private SeatDto mapToDto(Seat seat) {

        return new SeatDto(
                seat.getId(),
                seat.getSeatType(),
                seat.getSeatNumber(),
                seat.getBasePrice()
        );
    }
}

