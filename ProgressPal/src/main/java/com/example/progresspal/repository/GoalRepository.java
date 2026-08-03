package com.example.progresspal.repository;

import com.example.progresspal.model.Goals;
import com.example.progresspal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goals, Integer> {

    List<Goals> findByUser(Users user);

    Optional<Goals> findByIdAndUser(Integer id, Users user);
}