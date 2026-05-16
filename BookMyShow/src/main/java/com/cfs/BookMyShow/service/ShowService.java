package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.*;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.*;
import com.cfs.BookMyShow.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public ShowDto createShow(ShowDto showDto) {

        Show show = new Show();

        // Fetch movie
        show.setMovie(
                movieRepository.findById(showDto.getMovie().getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Movie not found"))
        );

        // Fetch screen
        Screen screen = screenRepository.findById(showDto.getScreen().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Screen not found"));

        show.setScreen(screen);

        show.setStartTime(showDto.getStartTime());
        show.setEndTime(showDto.getEndTime());

        Show savedShow = showRepository.save(show);

        // Create show seats
        List<Seat> seats =
                seatRepository.findByScreenId(screen.getId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat -> {

                    ShowSeat ss = new ShowSeat();

                    ss.setShow(savedShow);
                    ss.setSeat(seat);

                    ss.setStatus("AVAILABLE");

                    ss.setPrice(seat.getBasePrice());

                    return ss;
                })
                .collect(Collectors.toList());

        showSeatRepository.saveAll(showSeats);

        savedShow.setShowSeats(showSeats);

        return mapToDto(savedShow, showSeats);
    }

    public ShowDto getShowById(Long id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));

        // IMPORTANT FIX
        // GET ALL SEATS NOT ONLY AVAILABLE
        List<ShowSeat> allSeats =
                showSeatRepository.findByShowId(show.getId());

        return mapToDto(show, allSeats);
    }

    public List<ShowDto> getAllShows() {

        List<Show> shows = showRepository.findAll();

        return shows.stream()
                .map(show -> {

                    // GET ALL SHOW SEATS
                    List<ShowSeat> allSeats =
                            showSeatRepository.findByShowId(show.getId());

                    return mapToDto(show, allSeats);

                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByMovie(Long movieId) {

        List<Show> shows =
                showRepository.findByMovieId(movieId);

        return shows.stream()
                .map(show -> {

                    List<ShowSeat> allSeats =
                            showSeatRepository.findByShowId(show.getId());

                    return mapToDto(show, allSeats);

                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByMovieAndCity(
            Long movieId,
            String city
    ) {

        List<Show> shows =
                showRepository
                        .findByMovie_IdAndScreen_Theater_City(
                                movieId,
                                city
                        );

        return shows.stream()
                .map(show -> {

                    List<ShowSeat> allSeats =
                            showSeatRepository.findByShowId(show.getId());

                    return mapToDto(show, allSeats);

                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByDateRange(
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {

        List<Show> shows =
                showRepository.findByStartTimeBetween(
                        startDate,
                        endDate
                );

        return shows.stream()
                .map(show -> {

                    List<ShowSeat> allSeats =
                            showSeatRepository.findByShowId(show.getId());

                    return mapToDto(show, allSeats);

                })
                .collect(Collectors.toList());
    }

    private ShowDto mapToDto(
            Show show,
            List<ShowSeat> seats
    ) {

        ShowDto showDto = new ShowDto();

        showDto.setId(show.getId());

        showDto.setStartTime(show.getStartTime());

        showDto.setEndTime(show.getEndTime());

        // Movie DTO
        showDto.setMovie(
                new MovieDto(
                        show.getMovie().getId(),
                        show.getMovie().getTitle(),
                        show.getMovie().getLanguage(),
                        show.getMovie().getDescription(),
                        show.getMovie().getReleaseDate(),
                        show.getMovie().getGenre(),
                        show.getMovie().getDurationMins(),
                        show.getMovie().getPosterUrl()
                )
        );

        // Theater DTO
        TheaterDto theaterDto = new TheaterDto(
                show.getScreen().getTheater().getId(),
                show.getScreen().getTheater().getName(),
                show.getScreen().getTheater().getAddress(),
                show.getScreen().getTheater().getCity(),
                show.getScreen().getTheater().getTotalScreens()
        );

        // Screen DTO
        showDto.setScreen(
                new ScreenDto(
                        show.getScreen().getId(),
                        show.getScreen().getName(),
                        show.getScreen().getTotalSeats(),
                        theaterDto
                )
        );

        // ALL SHOW SEATS
        List<ShowSeatDto> seatDtos = seats.stream()
                .map(seat -> {

                    ShowSeatDto seatDto =
                            new ShowSeatDto();

                    seatDto.setId(seat.getId());

                    seatDto.setPrice(seat.getPrice());

                    seatDto.setStatus(seat.getStatus());

                    SeatDto baseSeatDto =
                            new SeatDto();

                    baseSeatDto.setId(
                            seat.getSeat().getId()
                    );

                    baseSeatDto.setSeatNumber(
                            seat.getSeat().getSeatNumber()
                    );

                    baseSeatDto.setSeatType(
                            seat.getSeat().getSeatType()
                    );

                    baseSeatDto.setBasePrice(
                            seat.getSeat().getBasePrice()
                    );

                    seatDto.setSeat(baseSeatDto);

                    return seatDto;
                })
                .collect(Collectors.toList());

        showDto.setShowSeats(seatDtos);

        return showDto;
    }
}