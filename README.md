# Order Service

Handles order placement, tracking, and management for Food-on-Wheels.

---

## Overview
- Spring Boot microservice using **MongoDB Atlas** for persistence.  
- RESTful APIs for order management.  
- Registered with Eureka for discovery.
- Exposed through Ingress and AWS ALB.
- Deployed on AWS EKS via ArgoCD.

---

## Tech Stack
Spring Boot, Spring Data JPA, Mongo Atlas, Eureka Client, Docker, Kubernetes, Jenkins, SonarQube, ArgoCD

---

## Endpoints
| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/saveFoodOrder` | Place a new order |

## Future additions
- Get order details
- Update order
- Cancel order

---

## Deployment
Image: `tejassrivathsa/order-service:latest`  
Deployed to AWS EKS using ArgoCD.  
MongoDB Atlas provides cloud NoSQL data storage.
