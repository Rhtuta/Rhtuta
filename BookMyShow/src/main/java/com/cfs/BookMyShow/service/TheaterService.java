package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.TheaterDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.Theater;
import com.cfs.BookMyShow.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public TheaterDto createTheater(TheaterDto theaterDto)
    {
        Theater theater = mapToEntity(theaterDto);
        Theater savedTheater = theaterRepository.save(theater);
        return mapToDto(savedTheater);
    }

    public TheaterDto getTheaterById(Long id){
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Theater not found with id:- "+id));
        return mapToDto(theater);
    }

    public List<TheaterDto> getAllTheaters()
    {
        List<Theater> theaters = theaterRepository.findAll();
        return theaters.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<TheaterDto> getAllTheatersByCity(String city)
    {
        List<Theater> theaters = theaterRepository.findByCity(city);
        return theaters.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public TheaterDto updateTheater(Long id, TheaterDto theaterDto)
    {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Theater not found with id: "+id));
        theater.setId(theaterDto.getId());
        theater.setName(theaterDto.getName());
        theater.setCity(theaterDto.getCity());
        theater.setAddress(theaterDto.getAddress());
        theater.setTotalScreens(theaterDto.getTotalScreens());
        Theater updatedTheater = theaterRepository.save(theater);
        return mapToDto(updatedTheater);
    }

    public void deleteTheater(Long id){
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Theater not found with id:- "+id));
        theaterRepository.delete(theater);
    }

    private TheaterDto mapToDto(Theater savedTheater) {
        TheaterDto theaterDto = new TheaterDto();
        theaterDto.setId(savedTheater.getId());
        theaterDto.setName(savedTheater.getName());
        theaterDto.setCity(savedTheater.getCity());
        theaterDto.setAddress(savedTheater.getAddress());
        theaterDto.setTotalScreens(savedTheater.getTotalScreens());
        return theaterDto;
    }

    private Theater mapToEntity(TheaterDto theaterDto) {
        Theater theater = new Theater();
        theater.setId(theaterDto.getId());
        theater.setCity(theaterDto.getCity());
        theater.setName(theaterDto.getName());
        theater.setAddress(theaterDto.getAddress());
        theater.setTotalScreens(theaterDto.getTotalScreens());
        return theater;
    }
}
