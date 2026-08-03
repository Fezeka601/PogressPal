
package com.example.progresspal.controller;

import com.example.progresspal.model.Goals;
import com.example.progresspal.service.GoalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller
    public class DashboardController {

        private final GoalService goalService;

        public DashboardController(GoalService goalService) {
            this.goalService = goalService;
        }

        @GetMapping("/dashboard")
        public String dashboard(Model model) {

            model.addAttribute("goals", goalService.getMyGoals());

            return "dashboard";
        }

        @PostMapping("/goals")
        public String addGoal(
                @RequestParam String title,
                @RequestParam Integer targetValue) {

            Goals goal = new Goals();

            goal.setTitle(title);
            goal.setTargetValue(targetValue);
            goal.setCurrentValue(0);

            goalService.addGoal(goal);

            return "redirect:/dashboard";
        }

        @PostMapping("/goals/{id}/progress")
        public String updateProgress(
                @PathVariable Integer id,
                @RequestParam Integer currentValue) {

            goalService.updateProgress(id, currentValue);

            return "redirect:/dashboard";
        }
    }