package com.crud.crud_api.service;

import com.crud.crud_api.dto.UserRequest;
import com.crud.crud_api.entity.User;
import com.crud.crud_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

 private final UserRepository userRepository;
 public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
 }

 public List<User> getUser() {
     return userRepository.findAll() ;
 }

 public  User createService(User userRequest) {
     return userRepository.save(userRequest) ;
 }

 public User userUpdate(UUID id , UserRequest request) {
     User user = userRepository.findById(id).orElseThrow(() ->  new RuntimeException("User not found")) ;
     if (request.getUsername() != null) {
         user.setUsername(request.getUsername());
     }

    return userRepository.save((user)) ;
 }

 //remove user api

    public String removeUserService(UUID id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);

        return "User deleted successfully";
    }
}
