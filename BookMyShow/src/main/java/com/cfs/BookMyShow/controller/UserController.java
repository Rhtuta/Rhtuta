package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.TheaterDto;
import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/me")
    public ResponseEntity<UserDto> getMyProfile() {
        return ResponseEntity.ok(userService.getMyProfile());
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PatchMapping("/users/update")
    public ResponseEntity<UserDto> updateUser(@RequestParam Long id,@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }

    @DeleteMapping("/admin/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
