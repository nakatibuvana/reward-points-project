package com.example.rewardpoints.controller;

import com.example.rewardpoints.service.RewardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService service;

    public RewardController(RewardService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public int getRewardPoints(@PathVariable String customerId) {
        return service.getTotalPoints(customerId);
    }
}