# Online Book Ordering System - Microservices

Spring Boot microservices with RabbitMQ messaging and PostgreSQL databases.

## Services

- **Book Service** (Port 8060): Manages book catalog and inventory
- **Order Service** (Port 8061): Handles customer orders and order processing

## Technologies

- Spring Boot 3.2.0
- Spring Data JPA
- Spring AMQP (RabbitMQ)
- PostgreSQL
- Swagger/OpenAPI

## Quick Start

### Prerequisites
- Java 21+
- PostgreSQL running on localhost:5432
- RabbitMQ running on localhost:5672

### Build
```bash
mvn clean install -DskipTests
```

### Run Services
```bash
# Terminal 1
cd book-service
mvn spring-boot:run

# Terminal 2
cd order-service
mvn spring-boot:run
```

## Swagger Documentation

- Book Service: http://localhost:8060/swagger-ui.html
- Order Service: http://localhost:8061/swagger-ui.html

## Architecture

When an order is created:
1. Order Service saves order to database
2. Order Service publishes event to RabbitMQ
3. Book Service consumes event
4. Book Service automatically reduces stock

## Database

Uses PostgreSQL schemas (book_service, order_service) for data isolation.

