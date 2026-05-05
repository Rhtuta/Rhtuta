package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.*;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Movie;
import com.cfs.BookMyShow.model.Screen;
import com.cfs.BookMyShow.model.Show;
import com.cfs.BookMyShow.model.ShowSeat;
import com.cfs.BookMyShow.repository.MovieRepository;
import com.cfs.BookMyShow.repository.ScreenRepository;
import com.cfs.BookMyShow.repository.ShowRepository;
import com.cfs.BookMyShow.repository.ShowSeatRepository;
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

    public ShowDto createShow(ShowDto showDto)
    {
        Show show = new Show();
        Movie movie = movieRepository.findById(show.getMovie().getId())
                .orElseThrow(()-> new ResourceNotFoundException("Movie not found with id:- "+show.getMovie().getId()));
        Screen screen = screenRepository.findById(show.getScreen().getId())
                .orElseThrow(()-> new ResourceNotFoundException("Screen not found with id:- "+show.getScreen().getId()));

        show.setMovie(movie);
        show.setScreen(screen);
        show.setEndTime(showDto.getEndTime());
        show.setStartTime(showDto.getStartTime());

        List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
        return mapToDto(show,availableSeats);
    }

    public ShowDto getShowById(Long id){
        Show show = showRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Show not found with id:- "+id));
        List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
        return mapToDto(show,availableSeats);
    }

    public List<ShowDto> getAllShows(){
        List<Show> shows = showRepository.findAll();
        return shows.stream()
                .map(show -> {
                    List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
                    return mapToDto(show,availableSeats);
                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByMovie(Long movieId){
        List<Show> shows = showRepository.findByMovieId(movieId);
        return shows.stream()
                .map(show -> {
                    List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
                    return mapToDto(show,availableSeats);
                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByMovieAndCity(Long movieId, String city){
        List<Show> shows = showRepository.findByMovie_IdAndScreen_Theater_City(movieId,city);
        return shows.stream()
                .map(show -> {
                    List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
                    return mapToDto(show,availableSeats);
                })
                .collect(Collectors.toList());
    }

    public List<ShowDto> getShowsByDateRange(LocalDateTime startDate, LocalDateTime endDate){
        List<Show> shows = showRepository.findByStartTimeBetween(startDate,endDate);
        return shows.stream()
                .map(show -> {
                    List<ShowSeat> availableSeats = showSeatRepository.findByShowIdAndStatus(show.getId(),"AVAILABLE");
                    return mapToDto(show,availableSeats);
                })
                .collect(Collectors.toList());
    }

    private ShowDto mapToDto(Show show,List<ShowSeat> availableSeats)
    {
        ShowDto showDto = new ShowDto();
        showDto.setId(show.getId());
        showDto.setEndTime(show.getEndTime());
        showDto.setStartTime(show.getStartTime());

        showDto.setMovie(new MovieDto(
               show.getMovie().getId(),
               show.getMovie().getTitle(),
               show.getMovie().getLanguage(),
               show.getMovie().getDescription(),
               show.getMovie().getReleaseDate(),
               show.getMovie().getGenre(),
               show.getMovie().getDurationMins(),
               show.getMovie().getPosterUrl()
        ));

        TheaterDto theaterDto = new TheaterDto(
                show.getScreen().getTheater().getId(),
                show.getScreen().getTheater().getName(),
                show.getScreen().getTheater().getAddress(),
                show.getScreen().getTheater().getCity(),
                show.getScreen().getTheater().getTotalScreens()
        );

        showDto.setScreen(new ScreenDto(
                show.getScreen().getId(),
                show.getScreen().getName(),
                show.getScreen().getTotalSeats(),
                theaterDto
        ));

        List<ShowSeatDto> seatDtos =  availableSeats.stream()
                .map(seat->{
                    ShowSeatDto seatDto = new ShowSeatDto();
                    seatDto.setPrice(seat.getPrice());
                    seatDto.setStatus(seat.getStatus());
                    seatDto.setId(seat.getId());

                    SeatDto baseSeatDto = new SeatDto();
                    baseSeatDto.setSeatType(seat.getSeat().getSeatType());
                    baseSeatDto.setSeatNumber(seat.getSeat().getSeatNumber());
                    baseSeatDto.setBasePrice(seat.getSeat().getBasePrice());
                    baseSeatDto.setId(seat.getSeat().getId());

                    seatDto.setSeat(baseSeatDto);
                    return seatDto;
                })
                .collect(Collectors.toList());
        showDto.setAvailableSeats(seatDtos);
        return showDto;
    }
}
