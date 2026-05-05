package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.User;
import com.cfs.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto)
    {
        User user = mapToEntity(userDto);
        User savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    public UserDto getUserById(Long id)
    {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id:- "+id));
        return mapToDto(user);
    }

    public List<UserDto> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto updateUser(Long id,UserDto userDto)
    {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id:- "+id));
        user.setId(userDto.getId());
        user.setName(userDto.getEmail());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    public void deleteUser(Long id)
    {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id:- "+id));
        userRepository.delete(user);
    }

    private UserDto mapToDto(User savedUser) {
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPhoneNumber(savedUser.getPhoneNumber());
        return userDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getEmail());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }
}
