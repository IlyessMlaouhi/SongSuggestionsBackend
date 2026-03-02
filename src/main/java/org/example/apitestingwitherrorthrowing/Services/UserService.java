package org.example.apitestingwitherrorthrowing.Services;

import org.example.apitestingwitherrorthrowing.Config.JwtUtil;
import org.example.apitestingwitherrorthrowing.Dtos.UserDto;
import org.example.apitestingwitherrorthrowing.Dtos.UserRequest;
import org.example.apitestingwitherrorthrowing.Dtos.UserResponse;
import org.example.apitestingwitherrorthrowing.Entities.User;
import org.example.apitestingwitherrorthrowing.Exceptions.UserException;
import org.example.apitestingwitherrorthrowing.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByName(String name){
        Optional<User> user = userRepository.getUserByName(name);
        if(user.isEmpty()){
            throw new UserException("User named "+ name +" not found");
        }
        return user.get();
    }

    public List<User> getAllUsers(){
        List<User> users=userRepository.findAll();
        if(users.isEmpty()){
            throw new UserException("there are no users is empty");
        }
        return users;
    }
        public UserResponse addUser(UserDto userDto){
            User user = userToUserDto(userDto);
            UserResponse userResponse= new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setEmail(user.getEmail());
            try{
            userRepository.save(user);}
            catch (Exception e){;
                throw new UserException("Error while saving user: " + e.getMessage());
            }
            return userResponse;
        }

        public User userToUserDto(UserDto user){
            User userDto=new User();
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(passwordEncoder.encode(user.getPassword()));
            return userDto;
        }

    public User deleteUser(String name){
            User user=getUserByName(name);
            userRepository.deleteById(user.getId());
            return user;
    }

    public UserResponse login(UserRequest userRequest){

        User user = userRepository.getUserByEmail(userRequest.getEmail())
                .orElseThrow(() ->
                        new UserException("User with email "+ userRequest.getEmail() +" not found")
                );

        if(!passwordEncoder.matches(userRequest.getPassword(), user.getPassword())){
            throw new UserException("Incorrect password");
        }

        String token = jwtUtil.generateToken(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setToken(token);

        return userResponse;
    }
}
