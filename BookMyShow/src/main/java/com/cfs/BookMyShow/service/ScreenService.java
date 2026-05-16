package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.ScreenDto;
import com.cfs.BookMyShow.dto.TheaterDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Screen;
import com.cfs.BookMyShow.model.Theater;
import com.cfs.BookMyShow.repository.ScreenRepository;
import com.cfs.BookMyShow.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public ScreenDto createScreen(ScreenDto screenDto)
    {
        Theater theater = theaterRepository.findById(
                screenDto.getTheater().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Theater not found"
                )
        );

        long existingScreens = screenRepository.countByTheaterId(screenDto.getTheater().getId());

        if (existingScreens >= theater.getTotalScreens()) {
            throw new RuntimeException(
                    "Cannot add more screens. Maximum limit reached for this theater."
            );
        }

        Screen screen = new Screen();

        screen.setName(screenDto.getName());
        screen.setTotalSeats(
                screenDto.getTotalSeats()
        );
        screen.setTheater(theater);

        Screen savedScreen =
                screenRepository.save(screen);

        return mapToDto(savedScreen);
    }

    public ScreenDto getScreenById(Long id)
    {
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found"
                        )
                );

        return mapToDto(screen);
    }

    public List<ScreenDto> getAllScreens()
    {
        List<Screen> screens =
                screenRepository.findAll();

        return screens.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ScreenDto> getScreensByTheater(
            Long theaterId
    )
    {
        List<Screen> screens =
                screenRepository.findByTheaterId(
                        theaterId
                );

        return screens.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ScreenDto updateScreen(
            Long id,
            ScreenDto screenDto
    )
    {
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found"
                        )
                );

        Theater theater = theaterRepository.findById(
                screenDto.getTheater().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Theater not found"
                )
        );

        screen.setName(screenDto.getName());

        screen.setTotalSeats(
                screenDto.getTotalSeats()
        );

        screen.setTheater(theater);

        Screen updatedScreen =
                screenRepository.save(screen);

        return mapToDto(updatedScreen);
    }

    public void deleteScreen(Long id)
    {
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found"
                        )
                );

        screenRepository.delete(screen);
    }

    private ScreenDto mapToDto(Screen screen)
    {
        TheaterDto theaterDto = new TheaterDto();

        theaterDto.setId(
                screen.getTheater().getId()
        );

        theaterDto.setName(
                screen.getTheater().getName()
        );

        theaterDto.setAddress(
                screen.getTheater().getAddress()
        );

        theaterDto.setCity(
                screen.getTheater().getCity()
        );

        theaterDto.setTotalScreens(
                screen.getTheater().getTotalScreens()
        );

        return new ScreenDto(
                screen.getId(),
                screen.getName(),
                screen.getTotalSeats(),
                theaterDto
        );
    }
}