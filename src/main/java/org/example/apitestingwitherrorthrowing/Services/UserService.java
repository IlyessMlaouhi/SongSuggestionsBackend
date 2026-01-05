package org.example.apitestingwitherrorthrowing.Services;

import org.example.apitestingwitherrorthrowing.Entities.User;
import org.example.apitestingwitherrorthrowing.Exceptions.BusinessException;
import org.example.apitestingwitherrorthrowing.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name){
        Optional<User> user = userRepository.getUserByName(name);
        if(user.isEmpty()){
            throw new BusinessException("User named "+ name +" not found");
        }
        return user.get();
    }

    public List<User> getAllUsers(){
        List<User> users=userRepository.findAll();
        if(users.isEmpty()){
            throw new BusinessException("there are no users is empty");
        }
        return users;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User deleteUser(String name){
            User user=getUserByName(name);
            userRepository.deleteById(user.getId());
            return user;
    }
}
