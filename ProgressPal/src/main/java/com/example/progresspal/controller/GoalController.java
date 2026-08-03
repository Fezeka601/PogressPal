
package com.example.progresspal.controller;

import com.example.progresspal.model.Goals;
import com.example.progresspal.service.GoalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping
    public List<Goals> getMyGoals() {
        return goalService.getMyGoals();
    }

    @PostMapping
    public Goals addGoal(@RequestBody Goals goal) {
        return goalService.addGoal(goal);
    }

    @GetMapping("/{id}")
    public Goals getGoal(@PathVariable Integer id) {
        return goalService.getGoalById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Integer id) {
        goalService.deleteGoal(id);
    }
    @PutMapping("/{id}")
    public Goals updateGoal(
            @PathVariable Integer id,
            @RequestBody Goals goal) {

        return goalService.updateGoal(id, goal);
    }
    @PatchMapping("/{id}/progress")
    public Goals updateProgress(
            @PathVariable Integer id,
            @RequestParam Integer progress) {

        return goalService.updateProgress(id, progress);
    }
}
