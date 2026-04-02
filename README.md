Reward Points API - Spring Boot

This application calculates reward points for customers based on transactions.

Rules:
- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100
- 0 points below $50

API:
GET /rewards/{customerId}

Returns monthly and total reward points.

Tech Stack:
- Java
- Spring Boot
- REST API
- JUnit