
<div align="center">

# ☕ Java Backend Ecosystem Showcase

**A comprehensive repository demonstrating enterprise-grade backend development ranging from foundational JDBC concepts to scalable Spring Cloud Microservices.**

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://docs.oracle.com/en/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)](https://hibernate.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)](https://www.rabbitmq.com/)
[![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)

</div>

---

## 📖 Overview

This repository serves as a curated portfolio and learning resource for advanced Java backend engineering. It contains over 60 meticulously structured modules covering a wide spectrum of technologies and architectural patterns. From raw database connectivity to distributed event-driven architectures, this repository demonstrates pragmatic implementations of real-world backend scenarios.

## 📑 Table of Contents

- [Core Technologies & Frameworks](#-core-technologies--frameworks)
- [Repository Architecture](#-repository-architecture)
- [Getting Started](#-getting-started)
- [Microservices Startup Sequence](#-microservices-startup-sequence)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🛠️ Core Technologies & Frameworks

| Category | Technologies | Description |
| :--- | :--- | :--- |
| **Language** | Java 17+ | Core programming language |
| **Frameworks** | Spring Boot, Spring MVC | Rapid REST API development |
| **Serialization & ORM** | Hibernate, JPA, JDBC | Database interaction and object mapping |
| **Distributed Systems** | Spring Cloud (Netflix Eureka, API Gateway) | Microservices infrastructure |
| **Messaging & Events** | RabbitMQ | Asynchronous inter-service communication |
| **Security** | Spring Security | Authentication, Authorization, and JWT |
| **Testing** | JUnit 5, Mockito | Unit testing and component mocking |

---

## 🏗️ Repository Architecture

The codebase is partitioned into functional domains. Here is the visual tree breakdown of the repository structure:

```text
📦 java_backend-JDBC-Hibernate-Junit-
 ┣ 📂 1. Data Access & ORM (Hibernate)
 ┃ ┣ 📂 learn_jdbc/                   # Core JDBC direct database queries
 ┃ ┣ 📂 OneToOneMapping/              # Entity relationship mapping
 ┃ ┣ 📂 OneToMany/                    # 1:N relations
 ┃ ┣ 📂 manytoonemapping/             # N:1 relations
 ┃ ┣ 📂 manytomanymappinguni/         # N:M Unidirectional mapping
 ┃ ┣ 📂 manytomanymappingbidirectional# N:M Bidirectional mapping
 ┃ ┣ 📂 firstlevelcaching/            # Hibernate L1 Cache optimization
 ┃ ┣ 📂 secondlevelcaching/           # Hibernate L2 Cache optimization
 ┃ ┗ 📂 cachepractice/
 ┃
 ┣ 📂 2. Spring Framework Core
 ┃ ┣ 📂 springbasicsxmlconfig/        # Legacy XML configuration
 ┃ ┣ 📂 springbasicsannotation/       # Modern annotation-driven setups
 ┃ ┗ 📂 springmvcboot/                # Foundation of MVC APIs
 ┃
 ┣ 📂 3. Microservices Architecture
 ┃ ┣ 📂 Infrastructure (Spring Cloud)
 ┃ ┃ ┣ 📂 config_server/            # Centralized config management
 ┃ ┃ ┣ 📂 service_registry/         # Service discovery (Netflix Eureka)
 ┃ ┃ ┗ 📂 api-gateway/              # Edge service & routing
 ┃ ┣ 📂 Domain Services
 ┃ ┃ ┣ 📂 user-service/             
 ┃ ┃ ┣ 📂 order-service/
 ┃ ┃ ┣ 📂 payment-service/
 ┃ ┃ ┗ 📂 book-service/
 ┃ ┗ 📂 Event-Driven
 ┃   ┣ 📂 RABBITMQ/                 # Base RabbitMQ integrations
 ┃   ┗ 📂 13th_March_Asynchronous_... # Async microservices communication
 ┃
 ┣ 📂 4. Enterprise Case Studies
 ┃ ┣ 📂 Financial Technology
 ┃ ┃ ┣ 📂 FinTech_Banking_System/
 ┃ ┃ ┣ 📂 Smart_Payment_Processing_System/
 ┃ ┃ ┗ 📂 Banking_Loan_Approval_System/
 ┃ ┣ 📂 Operations Management
 ┃ ┃ ┣ 📂 HMS/                      # Hospital Management
 ┃ ┃ ┣ 📂 CRM-SMS/                  # Customer Relations
 ┃ ┃ ┣ 📂 26Feb_Employee_Management_...
 ┃ ┃ ┗ 📂 9th_Mar_Student_Management_...
 ┃ ┣ 📂 E-Commerce Solutions
 ┃ ┃ ┣ 📂 Online_Food_Delivery_System/
 ┃ ┃ ┣ 📂 13th_march_Online_Book_...
 ┃ ┃ ┗ 📂 26_Feb_Product_Category_...
 ┃ ┗ 📂 Micro-Utilities
 ┃   ┣ 📂 28_Feb_URL_Shortener_Service/
 ┃   ┣ 📂 4th_Mar_To_Do_List_Web_...
 ┃   ┗ 📂 6th_MAR_Event_Announcement_...
 ┃
 ┗ 📂 5. Testing & Quality Assurance
   ┣ 📂 Junit/                        # TDD Fundamentals
   ┣ 📂 JunitTesting/
   ┣ 📂 Mockito_practice/             # Isolating layers via mocks
   ┣ 📂 mockitowithouthibernate/      # Mocking service layers
   ┗ 📂 mockito_with_hibernate/       # Mocking persistence layers
