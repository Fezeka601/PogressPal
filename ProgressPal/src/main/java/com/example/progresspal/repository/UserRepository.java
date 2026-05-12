package com.example.progresspal.repository;

import com.example.progresspal.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

}
