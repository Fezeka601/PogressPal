package com.example.progresspal.service;

import com.example.progresspal.model.GoalStatus;
import com.example.progresspal.model.Goals;
import com.example.progresspal.model.Users;
import com.example.progresspal.repository.GoalRepository;
import com.example.progresspal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    private Users getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public List<Goals> getMyGoals() {

        Users currentUser = getCurrentUser();

        return goalRepository.findByUser(currentUser);
    }

    public Goals addGoal(Goals goal) {

        Users currentUser = getCurrentUser();

        goal.setUser(currentUser);

        return goalRepository.save(goal);
    }

    public Goals getGoalById(Integer goalId) {

        Users currentUser = getCurrentUser();

        return goalRepository.findByIdAndUser(goalId, currentUser)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found"));
    }

    public void deleteGoal(Integer goalId) {

        Users currentUser = getCurrentUser();

        Goals goal = goalRepository
                .findByIdAndUser(goalId, currentUser)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found"));

        goalRepository.delete(goal);
    }

    public Goals updateGoal(Integer goalId, Goals updatedGoal) {

        Users currentUser = getCurrentUser();

        Goals goal = goalRepository
                .findByIdAndUser(goalId, currentUser)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found"));

        goal.setTitle(updatedGoal.getTitle());
        goal.setDescription(updatedGoal.getDescription());
        goal.setTargetDate(updatedGoal.getTargetDate());
        goal.setCategory(updatedGoal.getCategory());
        goal.setTargetValue(updatedGoal.getTargetValue());
        goal.setCurrentValue(updatedGoal.getCurrentValue());
        goal.setStatus(updatedGoal.getStatus());

        return goalRepository.save(goal);
    }
    public Goals updateProgress(Integer goalId, Integer progress) {

        Users currentUser = getCurrentUser();

        Goals goal = goalRepository
                .findByIdAndUser(goalId, currentUser)
                .orElseThrow(() ->
                        new RuntimeException("Goal not found"));

        goal.setCurrentValue(progress);

        if (goal.getCurrentValue() >= goal.getTargetValue()) {
            goal.setStatus(GoalStatus.COMPLETED);
        } else {
            goal.setStatus(GoalStatus.IN_PROGRESS);
        }

        return goalRepository.save(goal);
    }
}