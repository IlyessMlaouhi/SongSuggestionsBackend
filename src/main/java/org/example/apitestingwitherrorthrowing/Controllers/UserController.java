package org.example.apitestingwitherrorthrowing.Controllers;


import org.example.apitestingwitherrorthrowing.Dtos.UserDto;
import org.example.apitestingwitherrorthrowing.Dtos.UserRequest;
import org.example.apitestingwitherrorthrowing.Dtos.UserResponse;
import org.example.apitestingwitherrorthrowing.Entities.User;
import org.example.apitestingwitherrorthrowing.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/auth")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users=userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserDto user) {
        UserResponse savedUser= userService.addUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }


    @PostMapping("login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest user) {
        UserResponse loggedInUser = userService.login(user);
        return ResponseEntity.status(200).body(loggedInUser);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestParam String name) {
        User deletedUser = userService.deleteUser(name);
        return ResponseEntity.status(204).body(deletedUser);
    }
}
