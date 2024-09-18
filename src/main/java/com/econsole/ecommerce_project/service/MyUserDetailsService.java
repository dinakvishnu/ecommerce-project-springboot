package com.econsole.ecommerce_project.service;

import com.econsole.ecommerce_project.model.UserPrincipal;
import com.econsole.ecommerce_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {


    //repo currently marked as prodcu we need to create separate db for login and give it here
    @Autowired
    private ProductRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUserName(username);

        if (user == null ){
            throw new UsernameNotFoundException("User Not found");
        }
        return new UserPrincipal(user) {
        };
    }
}
