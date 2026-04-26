package com.crud.crud_api.controller;

import com.crud.crud_api.dto.UserRequest;
import com.crud.crud_api.entity.User;
import com.crud.crud_api.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.crud.crud_api.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService ;

    public  UserController(UserService UserService){
        this.userService = UserService ;
    }


    @GetMapping("/get")
    public List<User> getAll() {
        return userService.getUser();
    }


    //create funtion

    @PostMapping("/create")
    public Object create(@RequestBody User user) {

        if (user.getUsername().length() < 3) {
            return  "Username too short"  ;
        }

        System.out.println("this is user username : " + user.getUsername());
        return userService.createService(user);
    }

    @PatchMapping("/update/{id}")
    public  User update(@PathVariable UUID id, @RequestBody UserRequest user) {
        return userService.userUpdate(id, user) ;
    }

    @DeleteMapping("/removeUser/{id}")
    public  String removeUser(@PathVariable UUID id ) {
        return userService.removeUserService(id) ;
    }
}
