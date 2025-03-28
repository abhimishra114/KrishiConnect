package com.example.KrishiConnect.service;

import com.example.KrishiConnect.model.UserPrincipal;
import com.example.KrishiConnect.model.Users;
import com.example.KrishiConnect.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        Users user = userRepo.findByPhone(phone);
        if (user == null){
            System.out.println("User not found" + phone);
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("Loaded user: " + user.getPhone());
        return new UserPrincipal(user);
    }
}
