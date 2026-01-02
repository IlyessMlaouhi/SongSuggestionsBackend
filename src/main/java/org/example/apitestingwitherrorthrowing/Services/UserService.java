package org.example.apitestingwitherrorthrowing.Services;

import org.example.apitestingwitherrorthrowing.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
