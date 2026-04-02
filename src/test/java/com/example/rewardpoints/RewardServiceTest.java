package com.example.rewardpoints;


import com.example.rewardpoints.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.rewardpoints.service.RewardService;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class RewardServiceTest {

    private TransactionRepository repository;
    private RewardService rewardService;

    @BeforeEach
    void setup() {
        repository = Mockito.mock(TransactionRepository.class);
        rewardService = new RewardService(repository);
    }

    @Test
    void testCalculatePointsAbove100() {
        int points = rewardService.calculatePoints(120);
        assertEquals(90, points);
    }

    @Test
    void testCalculatePointsBetween50And100() {
        int points = rewardService.calculatePoints(70);
        assertEquals(20, points);
    }

    @Test
    void testCalculatePointsBelow50() {
        int points = rewardService.calculatePoints(40);
        assertEquals(0, points);
    }
}