About the Project

This project was developed to implement the basic principles of microservices architecture. My goal was to demonstrate how microservices can work independently, have their own databases, and how communication between services can be established. The project demonstrates how each microservice is designed independently and how these services interact with each other, as well as how modern approaches such as configuration management are integrated. Additionally, a Mail Service was implemented using Kafka for asynchronous communication, ensuring that email notifications are sent reliably and efficiently in a decoupled manner across microservices.



Technologies

Backend: Spring Boot
Database: H2 (Lightweight, in-memory database for local development)
Service Discovery: Eureka (For service discovery between microservices)
API Communication: Feign Client (For communication between services)
Configuration Management: Configuration files pulled from GitHub (Centralized configuration for each microservice)
Mail Service: A dedicated microservice for handling email notifications
Kafka: Used for asynchronous communication between services, enabling the Mail Service to efficiently handle email-related tasks independently from other services.
