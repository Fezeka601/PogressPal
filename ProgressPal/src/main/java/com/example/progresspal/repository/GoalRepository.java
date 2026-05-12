package com.example.progresspal.repository;


import com.example.progresspal.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goals, Integer> {

    List<Goals> findByUserId(Integer userId);
}
