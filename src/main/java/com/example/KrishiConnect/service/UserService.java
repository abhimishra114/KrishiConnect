package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users registerUser(Users user) {
        return userRepo.save(user);
    }
}
