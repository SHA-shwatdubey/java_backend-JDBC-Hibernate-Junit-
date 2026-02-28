# Spring Boot MVC Application

A traditional Spring MVC application with JSP views, PostgreSQL database, and layered architecture.

## Project Overview

| Property | Value |
|----------|-------|
| **Project Name** | springmvcboot |
| **Java Version** | 21+ |
| **Spring Boot** | 3.5.11 |
| **Database** | PostgreSQL |
| **View Technology** | JSP with JSTL |
| **Build Tool** | Maven |
| **Port** | 8090 |

## Project Structure

```
springmvcboot/
├── src/
│   ├── main/
│   │   ├── java/com/capgemini/
│   │   │   ├── Main.java                    # Application Entry Point
│   │   │   ├── api/
│   │   │   │   └── UserController.java      # REST API Controller
│   │   │   ├── config/
│   │   │   │   └── WebConfig.java           # Web Configuration
│   │   │   ├── controller/
│   │   │   │   ├── DemoController.java      # Home/About Pages
│   │   │   │   ├── ProductController.java   # Product Management
│   │   │   │   └── UserMVCController.java   # User Management
│   │   │   ├── dto/
│   │   │   │   └── UserDTO.java             # Data Transfer Object
│   │   │   ├── entity/
│   │   │   │   └── User.java                # JPA Entity
│   │   │   ├── exception/
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java      # Data Access Layer
│   │   │   ├── service/
│   │   │   │   ├── IUserService.java        # Service Interface
│   │   │   │   └── UserService.java         # Service Implementation
│   │   │   └── util/
│   │   │       └── MapperUtil.java          # Entity-DTO Mapper
│   │   ├── resources/
│   │   │   ├── application.properties       # Configuration
│   │   │   └── static/
│   │   │       ├── css/style.css            # Stylesheet
│   │   │       └── js/main.js               # JavaScript
│   │   └── webapp/WEB-INF/views/
│   │       ├── common/
│   │       │   ├── index.jsp                # Home Page
│   │       │   ├── home.jsp                 # Home Page
│   │       │   └── about.jsp                # About Page
│   │       ├── user/
│   │       │   ├── list.jsp                 # User List
│   │       │   ├── form.jsp                 # Add/Edit User
│   │       │   └── view.jsp                 # User Details
│   │       └── product/
│   │           ├── list.jsp                 # Product List
│   │           ├── form.jsp                 # Add/Edit Product
│   │           └── view.jsp                 # Product Details
│   └── test/
│       └── java/com/capgemini/
│           ├── SpringmvcbootApplicationTests.java
│           └── service/UserServiceTest.java
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## Technology Stack

| Layer | Technology |
|-------|------------|
| **Frontend** | JSP, JSTL, HTML, CSS, JavaScript |
| **Backend** | Spring Boot 3.5.11, Spring MVC |
| **Database** | PostgreSQL |
| **ORM** | Hibernate / Spring Data JPA |
| **Build** | Maven |
| **Server** | Embedded Tomcat |

## Prerequisites

1. **Java 21+** - JDK installed and JAVA_HOME set
2. **PostgreSQL** - Database server running on port 5432
3. **Maven 3.8+** - Build tool (or use included mvnw wrapper)
4. **IDE** - IntelliJ IDEA / Eclipse / VS Code

## Database Configuration

### PostgreSQL Setup

```properties
URL: jdbc:postgresql://localhost:5432/postgres
Username: postgres
Password: root
```

### Database Properties (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

## Installation & Setup

### Step 1: Clone/Download Project

```bash
cd C:\Users\Shashwat\OneDrive\Desktop\SpringBoot\springmvcboot
```

### Step 2: Verify PostgreSQL is Running

```bash
psql -U postgres -c "SELECT 1;"
```

### Step 3: Build Project

```bash
# Using Maven Wrapper (Windows)
.\mvnw.cmd clean install

# Using Maven Wrapper (Linux/Mac)
./mvnw clean install

# Using Maven directly
mvn clean install
```

### Step 4: Run Application

```bash
# Using Maven Wrapper
.\mvnw.cmd spring-boot:run

# Using Maven
mvn spring-boot:run

# Using Java directly
java -jar target/springmvcboot-0.0.1-SNAPSHOT.jar
```

### Step 5: Access Application

Open browser and navigate to:

```
http://localhost:8090/
```

## Application URLs

### Web Pages (MVC)

| URL | Description |
|-----|-------------|
| `http://localhost:8090/` | Home Page |
| `http://localhost:8090/home` | Home Page |
| `http://localhost:8090/about` | About Page |
| `http://localhost:8090/users` | User List |
| `http://localhost:8090/users/new` | Add New User |
| `http://localhost:8090/users/{id}` | View User |
| `http://localhost:8090/users/edit/{id}` | Edit User |
| `http://localhost:8090/users/delete/{id}` | Delete User |
| `http://localhost:8090/products` | Product List |
| `http://localhost:8090/products/new` | Add New Product |

### REST API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create new user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

## Architecture

### Layered Architecture

```
┌─────────────────────────────────────────────────┐
│                   JSP Views                     │
│         (WEB-INF/views/*.jsp)                   │
└─────────────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────┐
│              Controller Layer                   │
│    (DemoController, UserMVCController,          │
│     ProductController, UserController)          │
└─────────────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────┐
│               Service Layer                     │
│      (IUserService, UserService)                │
└─────────────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────┐
│              Repository Layer                   │
│           (UserRepository)                      │
└─────────────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────┐
│             PostgreSQL Database                 │
│              (users table)                      │
└─────────────────────────────────────────────────┘
```

### MVC Flow

```
Browser Request
      │
      ▼
┌─────────────┐
│DispatcherServlet│
└─────────────┘
      │
      ▼
┌─────────────┐
│ Controller  │ ──────► Model (Data)
└─────────────┘
      │
      ▼
┌─────────────┐
│   Service   │
└─────────────┘
      │
      ▼
┌─────────────┐
│ Repository  │
└─────────────┘
      │
      ▼
┌─────────────┐
│  Database   │
└─────────────┘
      │
      ▼
┌─────────────┐
│  JSP View   │
└─────────────┘
      │
      ▼
Browser Response (HTML)
```

## Code Details

### 1. Main.java (Entry Point)

```java
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.capgemini.repository")
@EntityScan(basePackages = "com.capgemini.entity")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
```

### 2. User.java (Entity)

```java
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    private String firstName;
    private String lastName;
    private String phone;
    private Long createdAt;
    private Long updatedAt;
    private Boolean active;
}
```

### 3. UserRepository.java (Data Access)

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByActiveTrue();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
```

### 4. UserService.java (Business Logic)

```java
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MapperUtil mapperUtil;
    
    // CRUD operations implementation
}
```

### 5. UserMVCController.java (MVC Controller)

```java
@Controller
@RequestMapping("/users")
public class UserMVCController {
    @Autowired(required = false)
    private IUserService userService;
    
    @GetMapping
    public String listUsers(Model model) {
        // Returns user/list.jsp
    }
    
    @GetMapping("/new")
    public String addUserForm(Model model) {
        // Returns user/form.jsp
    }
    
    @PostMapping
    public String saveUser(@ModelAttribute UserDTO userDTO) {
        // Saves user and redirects
    }
}
```

### 6. UserController.java (REST API)

```java
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Returns JSON
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Returns created user JSON
    }
}
```

## Database Schema

### Users Table

```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone VARCHAR(255) NOT NULL,
    created_at BIGINT,
    updated_at BIGINT,
    active BOOLEAN DEFAULT TRUE
);
```

## Dependencies (pom.xml)

| Dependency | Purpose |
|------------|---------|
| spring-boot-starter-web | Web MVC support |
| spring-boot-starter-data-jpa | JPA/Hibernate support |
| postgresql | PostgreSQL JDBC driver |
| tomcat-embed-jasper | JSP support |
| jakarta.servlet.jsp.jstl-api | JSTL tags |
| lombok | Boilerplate reduction |
| spring-boot-devtools | Hot reload |

## Configuration (application.properties)

```properties
# Server
spring.application.name=springmvcboot
server.port=8090
server.servlet.context-path=/

# JSP Views
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# PostgreSQL Database
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false

# Logging
logging.level.root=INFO
logging.level.com.capgemini=DEBUG

# Static Resources
spring.mvc.static-path-pattern=/**
spring.web.resources.static-locations=classpath:/static/
```

## Features

- ✅ Traditional Spring MVC Architecture
- ✅ JSP Views with JSTL Tags
- ✅ WEB-INF Folder Structure
- ✅ PostgreSQL Database Integration
- ✅ JPA/Hibernate ORM
- ✅ User CRUD Operations
- ✅ Product Management Structure
- ✅ REST API Endpoints
- ✅ Global Exception Handling
- ✅ CORS Configuration
- ✅ Static Resources (CSS, JS)
- ✅ Layered Architecture
- ✅ DTO Pattern
- ✅ Service Interface Pattern

## Troubleshooting

### Error: Database connection failed

```
Solution: Ensure PostgreSQL is running on port 5432
Command: psql -U postgres -c "SELECT 1;"
```

### Error: JSP not found

```
Solution: JSP files must be in src/main/webapp/WEB-INF/views/
```

### Error: CSS not loading

```
Solution: Static files must be in src/main/resources/static/
Path: /css/style.css (not /resources/css/style.css)
```

### Error: Port already in use

```
Solution: Change port in application.properties
server.port=8091
```

## Author

**Capgemini**

## License

This project is for educational purposes.

---

**Version:** 0.0.1-SNAPSHOT  
**Last Updated:** February 27, 2026

