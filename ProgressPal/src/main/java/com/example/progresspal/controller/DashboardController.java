
    package com.example.progresspal.controller;
    import com.example.progresspal.model.Users;
    import com.example.progresspal.service.GoalService;
    import com.example.progresspal.service.UserService;
    import org.springframework.security.core.Authentication;
import com.example.progresspal.model.Goals;
import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;

    @Controller
    public class DashboardController {

        private final GoalService goalService;
private final UserService userService;

        public DashboardController(GoalService goalService, UserService userService) {
            this.goalService = goalService;
            this.userService = userService;
        }
        @GetMapping("/dashboard")
        public String getDashboard(Authentication authentication, Model model) {

            String username = authentication.getName();


            Users user = userService.findByUsername(username);

            List<Goals> goals = goalService.getGoalsByUserId(user.getId());

            model.addAttribute("goals", goals);
            model.addAttribute("username", username);

            return "dashboard";
        }


        @PostMapping("/goals")
        public String addGoal(@RequestParam String title, Authentication authentication) {

            String username = authentication.getName();

            Users user = userService.findByUsername(username);

            Goals goal = new Goals();
            goal.setTitle(title);
            goal.setUserId(user.getId());

            goalService.addGoal(goal);

            return "redirect:/dashboard";
        }
    }