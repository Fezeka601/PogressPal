package com.example.progresspal.service;

import com.example.progresspal.model.Users;
import com.example.progresspal.model.UserPrincipal;
import com.example.progresspal.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository ;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // ============================
    // LOGIN (Spring Security uses this)
    // ============================
    @Override


    public UserDetails loadUserByUsername(String username)

            throws UsernameNotFoundException {


        Users user = repository.findByUsername(username)

                .orElseThrow(() ->

                        new UsernameNotFoundException(

                                "User not found with username: " + username

                        )

                );
        return new UserPrincipal(user);
    }

    public Users registerUser(Users user) {

        if (repository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);

    } }
