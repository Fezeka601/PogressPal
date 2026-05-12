package com.example.progresspal.service;

import com.example.progresspal.model.UserPrincipal;
import com.example.progresspal.model.Users;
import com.example.progresspal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users user = repository.findByUsername(username)

                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: " + username));

        return new UserPrincipal(user);
    }

    public Users findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}





