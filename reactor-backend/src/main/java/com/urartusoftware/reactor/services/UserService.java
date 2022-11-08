package com.urartusoftware.reactor.services;

import com.urartusoftware.reactor.daos.UserDAO;
import com.urartusoftware.reactor.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<UserDAO> getById(int userId) {
        return userRepo.findById(userId);
    }

    public Optional<UserDAO> postUser(UserDAO newUserDAO) {
        Optional<UserDAO> savedUserOptional = Optional.of(userRepo.save(newUserDAO));
        return savedUserOptional;
    }

}
