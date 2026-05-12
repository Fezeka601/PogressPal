package com.example.progresspal.controller;

import com.example.progresspal.model.Goals;
import com.example.progresspal.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping ("/postgres")
    public class GoalController {

    @Autowired
    GoalService goalService;


        @GetMapping ("/getAllData")
        public List<Goals> getAllData (){

            return goalService.getAllData ();
        }
@PostMapping ("/addGoal")
        public Goals addGoal(@RequestBody Goals goal) {
            return goalService.addGoal(goal);

        }
    }


