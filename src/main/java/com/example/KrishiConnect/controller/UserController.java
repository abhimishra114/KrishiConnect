package com.example.KrishiConnect.controller;

import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@Tag(name = "User API", description = "User authentication operations")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Operation(summary = "Get all users", description = "Get all users from the database")
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(summary = "Get a user with phone num")
    @GetMapping("users/phone/{phoneNum}")
    public ResponseEntity<Users> getUserByPhone(@PathVariable String phoneNum) {
        Users user = userService.getUserByPhone(phoneNum);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Get a user with id")
    @GetMapping("users/id/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Users user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Get a user with role(FARMER/BUSINESS)")
    @GetMapping("users/role/{role}")
    public ResponseEntity<List<Users>> getUsersByRole(@PathVariable String role) {
        return new ResponseEntity<>(userService.getUsersByRole(role), HttpStatus.OK);
    }

    @Operation(summary = "Register a user", description = "Register a user in the database")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        try {
            user.setPasswordHash(encoder.encode(user.getPasswordHash()));
            return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Login a user", description = "Login a user in the database")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        try {
            String status = userService.verify(user);
            System.out.println(status);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
