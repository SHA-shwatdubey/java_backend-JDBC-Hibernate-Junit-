# 📢 Event Announcement System

A robust **RESTful API** for managing event announcements, built with **Spring Boot 3.3.5** and secured with **Spring Security** (HTTP Basic Authentication). This system supports full CRUD operations, role-based access control, input validation, and advanced querying capabilities.

---

## 📑 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Configuration](#-configuration)
- [Authentication & Authorization](#-authentication--authorization)
- [API Endpoints](#-api-endpoints)
- [Request & Response Examples](#-request--response-examples)
- [Event Types & Statuses](#-event-types--statuses)
- [Error Handling](#-error-handling)
- [Testing](#-testing)
- [Project Structure](#-project-structure)
- [How to Recreate from Scratch](#-how-to-recreate-this-project-from-scratch)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

| Feature | Description |
|---|---|
| **Full CRUD** | Create, Read, Update, and Delete events |
| **Role-Based Access Control** | `ADMIN` for full access, `USER` for read-only |
| **HTTP Basic Auth** | Stateless authentication via Spring Security |
| **Input Validation** | Jakarta Bean Validation on all request payloads |
| **Search & Filter** | Search by title, filter by event type, view upcoming events |
| **Cancel Events** | Soft-cancel events via a dedicated PATCH endpoint |
| **Global Exception Handling** | Consistent error responses with `@RestControllerAdvice` |
| **Automatic Timestamps** | `createdAt` and `updatedAt` managed via JPA lifecycle callbacks |
| **H2 Test Profile** | In-memory H2 database for isolated integration testing |

---

## 🛠 Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| **Java** | 21 | Programming Language |
| **Spring Boot** | 3.3.5 | Application Framework |
| **Spring Security** | — | Authentication & Authorization |
| **Spring Data JPA** | — | Data Access & ORM |
| **Hibernate** | — | JPA Implementation |
| **PostgreSQL** | — | Production Database |
| **H2 Database** | — | Testing Database (in-memory) |
| **Jakarta Validation** | — | Input Validation |
| **Maven** | — | Build & Dependency Management |
| **JUnit 5** | — | Testing Framework |

---

## 🏗 Architecture

The project follows a **layered architecture** pattern:

```
┌─────────────────────────────────────────────┐
│              Controller Layer                │  ← REST endpoints
├─────────────────────────────────────────────┤
│               Service Layer                  │  ← Business logic
├─────────────────────────────────────────────┤
│             Repository Layer                 │  ← Data access (JPA)
├─────────────────────────────────────────────┤
│           PostgreSQL Database                │  ← Persistence
└─────────────────────────────────────────────┘
```

**Key design decisions:**
- **DTO Pattern** — Separate `EventRequest` (input) and `EventResponse` (output) DTOs decouple the API contract from the entity model.
- **Stateless Security** — Sessions are disabled (`STATELESS`); every request is authenticated independently.
- **Global Exception Handling** — A centralized `@RestControllerAdvice` returns consistent error payloads.

---

## 📋 Prerequisites

Before running this project, ensure you have:

- **Java 21** (or higher) — [Download](https://adoptium.net/)
- **Maven 3.8+** — [Download](https://maven.apache.org/download.cgi)
- **PostgreSQL 14+** — [Download](https://www.postgresql.org/download/)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/event-announcement-system.git
cd event-announcement-system
```

### 2. Set Up the Database

Create a PostgreSQL database:

```sql
CREATE DATABASE event_announcement_db;
```

### 3. Configure Database Credentials

Update `src/main/resources/application.properties` if your PostgreSQL credentials differ:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/event_announcement_db
spring.datasource.username=postgres
spring.datasource.password=root
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn spring-boot:run
```

The application will start on **http://localhost:8076**

---

## ⚙ Configuration

### Application Properties (`application.properties`)

| Property | Value | Description |
|---|---|---|
| `server.port` | `8076` | Server port |
| `spring.datasource.url` | `jdbc:postgresql://localhost:5432/event_announcement_db` | Database URL |
| `spring.jpa.hibernate.ddl-auto` | `update` | Auto-creates/updates DB schema |
| `spring.jpa.show-sql` | `true` | Logs SQL queries to console |
| `spring.jpa.properties.hibernate.format_sql` | `true` | Pretty-prints SQL logs |

---

## 🔐 Authentication & Authorization

The API uses **HTTP Basic Authentication** with **in-memory user credentials**.

### Default Users

| Username | Password | Role | Permissions |
|---|---|---|---|
| `admin` | `admin123` | `ADMIN` | Full CRUD access (GET, POST, PUT, PATCH, DELETE) |
| `user` | `user123` | `USER` | Read-only access (GET only) |

### Access Control Rules

| HTTP Method | Endpoint | Required Role |
|---|---|---|
| `GET` | `/events/**` | `USER` or `ADMIN` |
| `POST` | `/events` | `ADMIN` |
| `PUT` | `/events/{id}` | `ADMIN` |
| `PATCH` | `/events/{id}/cancel` | `ADMIN` |
| `DELETE` | `/events/{id}` | `ADMIN` |

### Example — Authenticating with cURL

```bash
# As admin (full access)
curl -u admin:admin123 http://localhost:8076/events

# As user (read-only)
curl -u user:user123 http://localhost:8076/events
```

---

## 📡 API Endpoints

### Events

| Method | Endpoint | Description | Auth Role |
|---|---|---|---|
| `GET` | `/events` | Get all events (sorted by date & time) | USER, ADMIN |
| `GET` | `/events/{id}` | Get a single event by ID | USER, ADMIN |
| `GET` | `/events/upcoming` | Get upcoming scheduled events | USER, ADMIN |
| `GET` | `/events/type/{eventType}` | Get events filtered by type | USER, ADMIN |
| `GET` | `/events/search?title={keyword}` | Search events by title (case-insensitive) | USER, ADMIN |
| `POST` | `/events` | Create a new event | ADMIN |
| `PUT` | `/events/{id}` | Update an existing event | ADMIN |
| `PATCH` | `/events/{id}/cancel` | Cancel an event (sets status to `CANCELLED`) | ADMIN |
| `DELETE` | `/events/{id}` | Delete an event permanently | ADMIN |

---

## 📦 Request & Response Examples

### ➕ Create an Event

**`POST /events`** (Requires `ADMIN` role)

```bash
curl -u admin:admin123 -X POST http://localhost:8076/events \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Spring Boot Workshop",
    "description": "Hands-on workshop covering Spring Boot fundamentals, REST APIs, and Spring Security.",
    "eventType": "WORKSHOP",
    "location": "Tech Hub, Building A, Room 301",
    "eventDate": "2026-04-15",
    "startTime": "10:00:00",
    "endTime": "13:00:00",
    "organizerName": "John Doe",
    "contactPhone": "+91-9876543210"
  }'
```

**Response** `201 Created`:

```json
{
  "id": 1,
  "title": "Spring Boot Workshop",
  "description": "Hands-on workshop covering Spring Boot fundamentals, REST APIs, and Spring Security.",
  "eventType": "WORKSHOP",
  "location": "Tech Hub, Building A, Room 301",
  "eventDate": "2026-04-15",
  "startTime": "10:00:00",
  "endTime": "13:00:00",
  "organizerName": "John Doe",
  "contactPhone": "+91-9876543210",
  "status": "SCHEDULED",
  "createdAt": "2026-03-07T14:30:00",
  "updatedAt": "2026-03-07T14:30:00"
}
```

### 📋 Get All Events

**`GET /events`**

```bash
curl -u user:user123 http://localhost:8076/events
```

### 🔍 Search Events by Title

**`GET /events/search?title=spring`**

```bash
curl -u user:user123 "http://localhost:8076/events/search?title=spring"
```

### 🏷 Filter Events by Type

**`GET /events/type/WORKSHOP`**

```bash
curl -u user:user123 http://localhost:8076/events/type/WORKSHOP
```

### 📅 Get Upcoming Events

**`GET /events/upcoming`**

```bash
curl -u user:user123 http://localhost:8076/events/upcoming
```

### ✏️ Update an Event

**`PUT /events/{id}`** (Requires `ADMIN` role)

```bash
curl -u admin:admin123 -X PUT http://localhost:8076/events/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Advanced Spring Boot Workshop",
    "description": "Deep dive into Spring Boot with microservices patterns.",
    "eventType": "WORKSHOP",
    "location": "Tech Hub, Building B, Room 505",
    "eventDate": "2026-04-20",
    "startTime": "09:00:00",
    "endTime": "12:00:00",
    "organizerName": "Jane Smith",
    "contactPhone": "+91-9876543211"
  }'
```

### ❌ Cancel an Event

**`PATCH /events/{id}/cancel`** (Requires `ADMIN` role)

```bash
curl -u admin:admin123 -X PATCH http://localhost:8076/events/1/cancel
```

### 🗑 Delete an Event

**`DELETE /events/{id}`** (Requires `ADMIN` role)

```bash
curl -u admin:admin123 -X DELETE http://localhost:8076/events/1
```

**Response**: `204 No Content`

---

## 🏷 Event Types & Statuses

### Event Types (`EventType`)

| Type | Description |
|---|---|
| `WORKSHOP` | Hands-on practical sessions |
| `SEMINAR` | Lecture-based educational events |
| `MEETUP` | Informal community gatherings |
| `CULTURAL` | Cultural and arts events |

### Event Statuses (`EventStatus`)

| Status | Description |
|---|---|
| `SCHEDULED` | Default status — event is active and upcoming |
| `CANCELLED` | Event has been cancelled via the cancel endpoint |

---

## ⚠️ Error Handling

The API provides consistent, structured error responses via a global exception handler.

### Resource Not Found (404)

```json
{
  "message": "Event not found with id: 99"
}
```

### Validation Error (400)

```json
{
  "message": "Validation failed",
  "errors": {
    "title": "must not be blank",
    "eventDate": "must not be null",
    "contactPhone": "contactPhone must contain only digits, spaces, + or -"
  }
}
```

### Unauthorized (401)

Returned when no credentials or invalid credentials are provided.

### Forbidden (403)

Returned when a `USER` role tries to access `ADMIN`-only endpoints (POST, PUT, PATCH, DELETE).

---

## 🧪 Testing

The project includes a **test profile** with an in-memory **H2 database**, so tests run independently without requiring PostgreSQL.

### Run Tests

```bash
mvn test
```

### Test Configuration (`application-test.properties`)

```properties
spring.datasource.url=jdbc:h2:mem:eventdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop
```

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/pom/capgemini/
│   │   ├── Main.java                              # Spring Boot entry point
│   │   ├── common/
│   │   │   ├── GlobalExceptionHandler.java         # Centralized exception handling
│   │   │   └── ResourceNotFoundException.java      # Custom 404 exception
│   │   ├── config/
│   │   │   └── SecurityConfig.java                 # Spring Security configuration
│   │   └── event/
│   │       ├── controller/
│   │       │   └── EventController.java            # REST API endpoints
│   │       ├── dto/
│   │       │   ├── EventRequest.java               # Input DTO with validation
│   │       │   └── EventResponse.java              # Output DTO
│   │       ├── entity/
│   │       │   └── Event.java                      # JPA entity
│   │       ├── model/
│   │       │   ├── EventStatus.java                # Enum: SCHEDULED, CANCELLED
│   │       │   └── EventType.java                  # Enum: WORKSHOP, SEMINAR, MEETUP, CULTURAL
│   │       ├── repository/
│   │       │   └── EventRepository.java            # Spring Data JPA repository
│   │       └── service/
│   │           └── EventService.java               # Business logic
│   └── resources/
│       └── application.properties                  # App configuration
└── test/
    ├── java/pom/capgemini/
    │   └── MainTests.java                          # Context load test
    └── resources/
        └── application-test.properties             # H2 test database config
```

---

## 🔄 How to Recreate This Project from Scratch

If you want to build this entire project from the ground up, follow the steps below. Each step includes the **exact file path** and **complete source code**.

---

### Step 1 — Create the Project Skeleton

Use [Spring Initializr](https://start.spring.io/) or create a Maven project manually with the following settings:

| Setting | Value |
|---|---|
| **Group** | `pom.capgemini` |
| **Artifact** | `6th_MAR_Event_Announcement_System` |
| **Java** | 21 |
| **Spring Boot** | 3.3.5 |
| **Dependencies** | Spring Web, Spring Security, Spring Data JPA, Validation, PostgreSQL Driver |

---

### Step 2 — `pom.xml`

📄 **File:** `pom.xml` (project root)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.5</version>
        <relativePath/>
    </parent>

    <groupId>pom.capgemini</groupId>
    <artifactId>6th_MAR_Event_Announcement_System</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>Event Announcement System</name>
    <description>Event Announcement System secured with Spring Security Basic Authentication</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

---

### Step 3 — Application Properties

📄 **File:** `src/main/resources/application.properties`

```properties
spring.application.name=event-announcement-system

spring.datasource.url=jdbc:postgresql://localhost:5432/event_announcement_db
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8076
```

📄 **File:** `src/test/resources/application-test.properties`

```properties
spring.datasource.url=jdbc:h2:mem:eventdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

---

### Step 4 — Main Application Class

📄 **File:** `src/main/java/pom/capgemini/Main.java`

```java
package pom.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
```

---

### Step 5 — Enums (Models)

📄 **File:** `src/main/java/pom/capgemini/event/model/EventType.java`

```java
package pom.capgemini.event.model;

public enum EventType {
    WORKSHOP,
    SEMINAR,
    MEETUP,
    CULTURAL
}
```

📄 **File:** `src/main/java/pom/capgemini/event/model/EventStatus.java`

```java
package pom.capgemini.event.model;

public enum EventStatus {
    SCHEDULED,
    CANCELLED
}
```

---

### Step 6 — Event Entity

📄 **File:** `src/main/java/pom/capgemini/event/entity/Event.java`

```java
package pom.capgemini.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import pom.capgemini.event.model.EventStatus;
import pom.capgemini.event.model.EventType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String organizerName;

    @Column(nullable = false)
    private String contactPhone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.status == null) {
            this.status = EventStatus.SCHEDULED;
        }
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ───── Getters & Setters ─────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public EventType getEventType() { return eventType; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getOrganizerName() { return organizerName; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
```

---

### Step 7 — DTOs (Data Transfer Objects)

📄 **File:** `src/main/java/pom/capgemini/event/dto/EventRequest.java`

```java
package pom.capgemini.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pom.capgemini.event.model.EventStatus;
import pom.capgemini.event.model.EventType;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private EventType eventType;

    @NotBlank
    private String location;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotBlank
    private String organizerName;

    @NotBlank
    @Pattern(regexp = "^[0-9+\\- ]{7,20}$", message = "contactPhone must contain only digits, spaces, + or -")
    private String contactPhone;

    private EventStatus status;

    // ───── Getters & Setters ─────

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public EventType getEventType() { return eventType; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getOrganizerName() { return organizerName; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }
}
```

📄 **File:** `src/main/java/pom/capgemini/event/dto/EventResponse.java`

```java
package pom.capgemini.event.dto;

import pom.capgemini.event.entity.Event;
import pom.capgemini.event.model.EventStatus;
import pom.capgemini.event.model.EventType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private EventType eventType;
    private String location;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String organizerName;
    private String contactPhone;
    private EventStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static EventResponse fromEntity(Event event) {
        EventResponse response = new EventResponse();
        response.setId(event.getId());
        response.setTitle(event.getTitle());
        response.setDescription(event.getDescription());
        response.setEventType(event.getEventType());
        response.setLocation(event.getLocation());
        response.setEventDate(event.getEventDate());
        response.setStartTime(event.getStartTime());
        response.setEndTime(event.getEndTime());
        response.setOrganizerName(event.getOrganizerName());
        response.setContactPhone(event.getContactPhone());
        response.setStatus(event.getStatus());
        response.setCreatedAt(event.getCreatedAt());
        response.setUpdatedAt(event.getUpdatedAt());
        return response;
    }

    // ───── Getters & Setters ─────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public EventType getEventType() { return eventType; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getOrganizerName() { return organizerName; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
```

---

### Step 8 — Repository

📄 **File:** `src/main/java/pom/capgemini/event/repository/EventRepository.java`

```java
package pom.capgemini.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pom.capgemini.event.entity.Event;
import pom.capgemini.event.model.EventStatus;
import pom.capgemini.event.model.EventType;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByStatusAndEventDateGreaterThanEqualOrderByEventDateAscStartTimeAsc(EventStatus status, LocalDate eventDate);

    List<Event> findByEventTypeOrderByEventDateAscStartTimeAsc(EventType eventType);

    List<Event> findByTitleContainingIgnoreCaseOrderByEventDateAscStartTimeAsc(String title);
}
```

---

### Step 9 — Service Layer

📄 **File:** `src/main/java/pom/capgemini/event/service/EventService.java`

```java
package pom.capgemini.event.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pom.capgemini.common.ResourceNotFoundException;
import pom.capgemini.event.dto.EventRequest;
import pom.capgemini.event.entity.Event;
import pom.capgemini.event.model.EventStatus;
import pom.capgemini.event.model.EventType;
import pom.capgemini.event.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        Sort sort = Sort.by(Sort.Order.asc("eventDate"), Sort.Order.asc("startTime"));
        return eventRepository.findAll(sort);
    }

    public List<Event> getUpcomingEvents() {
        return eventRepository.findByStatusAndEventDateGreaterThanEqualOrderByEventDateAscStartTimeAsc(
                EventStatus.SCHEDULED,
                LocalDate.now()
        );
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
    }

    public List<Event> getEventsByType(EventType eventType) {
        return eventRepository.findByEventTypeOrderByEventDateAscStartTimeAsc(eventType);
    }

    public List<Event> searchByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCaseOrderByEventDateAscStartTimeAsc(title);
    }

    public Event createEvent(EventRequest request) {
        Event event = new Event();
        mapRequestToEntity(request, event);
        if (event.getStatus() == null) {
            event.setStatus(EventStatus.SCHEDULED);
        }
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, EventRequest request) {
        Event event = getEventById(id);
        mapRequestToEntity(request, event);
        if (event.getStatus() == null) {
            event.setStatus(EventStatus.SCHEDULED);
        }
        return eventRepository.save(event);
    }

    public Event cancelEvent(Long id) {
        Event event = getEventById(id);
        event.setStatus(EventStatus.CANCELLED);
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    private void mapRequestToEntity(EventRequest request, Event event) {
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setEventType(request.getEventType());
        event.setLocation(request.getLocation());
        event.setEventDate(request.getEventDate());
        event.setStartTime(request.getStartTime());
        event.setEndTime(request.getEndTime());
        event.setOrganizerName(request.getOrganizerName());
        event.setContactPhone(request.getContactPhone());
        event.setStatus(request.getStatus());
    }
}
```

---

### Step 10 — REST Controller

📄 **File:** `src/main/java/pom/capgemini/event/controller/EventController.java`

```java
package pom.capgemini.event.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pom.capgemini.event.dto.EventRequest;
import pom.capgemini.event.dto.EventResponse;
import pom.capgemini.event.model.EventType;
import pom.capgemini.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents().stream().map(EventResponse::fromEntity).toList();
    }

    @GetMapping("/upcoming")
    public List<EventResponse> getUpcomingEvents() {
        return eventService.getUpcomingEvents().stream().map(EventResponse::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public EventResponse getEventById(@PathVariable Long id) {
        return EventResponse.fromEntity(eventService.getEventById(id));
    }

    @GetMapping("/type/{eventType}")
    public List<EventResponse> getEventsByType(@PathVariable EventType eventType) {
        return eventService.getEventsByType(eventType).stream().map(EventResponse::fromEntity).toList();
    }

    @GetMapping("/search")
    public List<EventResponse> searchByTitle(@RequestParam String title) {
        return eventService.searchByTitle(title).stream().map(EventResponse::fromEntity).toList();
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody EventRequest request) {
        EventResponse response = EventResponse.fromEntity(eventService.createEvent(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequest request) {
        return EventResponse.fromEntity(eventService.updateEvent(id, request));
    }

    @PatchMapping("/{id}/cancel")
    public EventResponse cancelEvent(@PathVariable Long id) {
        return EventResponse.fromEntity(eventService.cancelEvent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
```

---

### Step 11 — Exception Handling

📄 **File:** `src/main/java/pom/capgemini/common/ResourceNotFoundException.java`

```java
package pom.capgemini.common;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

📄 **File:** `src/main/java/pom/capgemini/common/GlobalExceptionHandler.java`

```java
package pom.capgemini.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Validation failed");

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }
}
```

---

### Step 12 — Security Configuration

📄 **File:** `src/main/java/pom/capgemini/config/SecurityConfig.java`

```java
package pom.capgemini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/events/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/events/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

---

### Step 13 — Test Class

📄 **File:** `src/test/java/pom/capgemini/MainTests.java`

```java
package pom.capgemini;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MainTests {

    @Test
    void contextLoads() {
    }
}
```

---

### Step 14 — Build & Run

```bash
# 1. Create the PostgreSQL database
psql -U postgres -c "CREATE DATABASE event_announcement_db;"

# 2. Build the project
mvn clean install

# 3. Run the application
mvn spring-boot:run

# 4. Test it!
curl -u admin:admin123 http://localhost:8076/events
```

---


