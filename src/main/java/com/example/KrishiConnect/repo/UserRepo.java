package com.example.KrishiConnect.repo;

import com.example.KrishiConnect.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByPhone(String phone);

    List<Users> findAllByRole(Users.Role role);
}
