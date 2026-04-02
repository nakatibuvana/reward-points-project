package com.example.rewardpoints.service;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    private final TransactionRepository repository;

    public RewardService(TransactionRepository repository) {
        this.repository = repository;
    }

    public int calculatePoints(double amount) {
        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }

        if (amount > 50) {
            points += (amount - 50);
        }

        return points;
    }

    public int getTotalPoints(String customerId) {
        List<Transaction> transactions = repository.findByCustomerId(customerId);

        return transactions.stream()
                .mapToInt(t -> calculatePoints(t.getAmount()))
                .sum();
    }
}