package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getPhone(), user.getPasswordHash()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getPhone());
        }
        return "failure";
    }

    public Users getUserByPhone(String phoneNum) {
        return userRepo.findByPhone(phoneNum);
    }

    public Users getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<Users> getUsersByRole(String strRole) {
        Users.Role role = Users.Role.valueOf(strRole.toUpperCase());
        try {
            return userRepo.findAllByRole(role);
        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role");
        }
    }
}
