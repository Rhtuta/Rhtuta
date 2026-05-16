package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.AuthRequest;
import com.cfs.BookMyShow.dto.AuthResponse;
import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.model.Role;
import com.cfs.BookMyShow.model.User;
import com.cfs.BookMyShow.repository.UserRepository;
import com.cfs.BookMyShow.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // LOGIN
    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(token);
    }

    // REGISTER
    public UserDto register(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // DEFAULT ROLE = USER
        user.setRole(Role.USER);

        //user.setRole(Role.ADMIN);

        User savedUser = userRepository.save(user);

        UserDto response = new UserDto();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPhoneNumber(savedUser.getPhoneNumber());

        return response;
    }
}