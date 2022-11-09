package com.urartusoftware.reactor.controllers;

import com.urartusoftware.reactor.daos.UserDAO;
import com.urartusoftware.reactor.models.User;
import com.urartusoftware.reactor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable int userId) {

        Optional<UserDAO> userOptional = userService.getById(userId);

        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = new User(userOptional.get());
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDAO newUser) {

        Optional<UserDAO> userOptional = userService.postUser(newUser);

        if (!userOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new User(userOptional.get()));
    }
}
