package com.econsole.ecommerce_project.service;

import com.econsole.ecommerce_project.model.Users;
import com.econsole.ecommerce_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     @Autowired
    private ProductRepo userRepo;

     private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);

    }
}
