package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;


    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users registerUser(Users user) {
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getPhone(),user.getPasswordHash()));

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.getPhone());
        }
        return "failure";
    }
}
