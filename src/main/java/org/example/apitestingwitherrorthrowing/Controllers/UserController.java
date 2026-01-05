package org.example.apitestingwitherrorthrowing.Controllers;


import org.example.apitestingwitherrorthrowing.Entities.User;
import org.example.apitestingwitherrorthrowing.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("name")
    public ResponseEntity<User> getUserByName(@RequestParam String name) {
        User user=userService.getUserByName(name);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users=userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser= userService.addUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestParam String name) {
        User deletedUser = userService.deleteUser(name);
        return ResponseEntity.status(204).body(deletedUser);
    }
}
