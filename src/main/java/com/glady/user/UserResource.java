package com.glady.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("users")
public record UserResource(UserService userService) {

    @GetMapping
    List<User> getAll(){
        return userService.findAllUsers();
    }

    @GetMapping("balance")
    double getBalance(@RequestParam(name = "userId") Long userID, @RequestParam(name = "type") String type){
        return userService.userBalance(userID, type);
    }
}
