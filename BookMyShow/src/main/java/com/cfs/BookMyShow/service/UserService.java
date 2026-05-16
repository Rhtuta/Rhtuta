package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.model.User;
import com.cfs.BookMyShow.repository.UserRepository;
import com.cfs.BookMyShow.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // GET USER BY ID (ADMIN USE)
    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id:- " + id));

        return mapToDto(user);
    }

    // GET MY PROFILE (USER ONLY)
    public UserDto getMyProfile() {

        String email = AuthUtil.getLoggedInUserEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        return mapToDto(user);
    }

    // GET ALL USERS (ADMIN ONLY)
    public List<UserDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // UPDATE USER (SELF UPDATE OR ADMIN)
    public UserDto updateUser(Long id, UserDto userDto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id:- " + id));

        String loggedInEmail = AuthUtil.getLoggedInUserEmail();

        if (!user.getEmail().equals(loggedInEmail)) {
            throw new RuntimeException("Access denied: You can only update your own profile");
        }

        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());

        User updatedUser = userRepository.save(user);

        return mapToDto(updatedUser);
    }

    // DELETE USER (ADMIN ONLY)
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id:- " + id));

        userRepository.delete(user);
    }

    // MAPPING METHOD
    private UserDto mapToDto(User user) {

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());

        return dto;
    }
}