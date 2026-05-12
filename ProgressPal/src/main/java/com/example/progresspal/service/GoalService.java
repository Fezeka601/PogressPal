package com.example.progresspal.service;


import com.example.progresspal.model.Goals;
import com.example.progresspal.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired

    GoalRepository goalRepository;

    public List<Goals> getAllData() {

        return goalRepository.findAll();

    }

    public Goals addGoal(Goals goal) {


        return goalRepository.save(goal);
    }

    public List<Goals> getGoalsByUserId(Integer userId) {
        return goalRepository.findByUserId(userId);
    }

}