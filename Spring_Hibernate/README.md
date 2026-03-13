# Spring Hibernate Employee Management System

A complete, production-ready Spring-Hibernate project with PostgreSQL integration demonstrating proper layered architecture, transaction management, and best practices.

## 🎯 Project Overview

This project implements an **Employee Management System** using:
- **Spring Framework 6.0** - Dependency injection and configuration
- **Hibernate 6.3** - JPA persistence layer
- **PostgreSQL** - Relational database
- **Maven** - Build and dependency management

## 📦 Key Technologies

| Component | Version | Purpose |
|-----------|---------|---------|
| Spring Context | 6.0.10 | Core Spring framework |
| Spring ORM | 6.0.10 | Hibernate integration |
| Hibernate | 6.3.1.Final | JPA provider |
| Jakarta Persistence | 3.1.0 | JPA specification |
| PostgreSQL JDBC | 42.7.1 | Database driver |
| SLF4J + Logback | 2.0.9 / 1.4.11 | Logging framework |
| Java | 21 | Compilation target |

## 🏗️ Project Architecture

### Layered Architecture
```
┌─────────────────────────────────────────┐
│        Controller Layer                  │
│  (EmployeeController)                   │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Service Layer                     │
│  (EmployeeService/EmployeeServiceImpl)   │
│  - Business Logic                        │
│  - Data Validation                       │
│  - Exception Handling                    │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        DAO/Repository Layer              │
│  (EmployeeDAO/EmployeeDao)              │
│  - Data Access Operations                │
│  - JPQL Queries                          │
│  - Transaction Management                │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Entity Layer                      │
│  (Employee, User)                        │
│  - JPA Mapped Entities                   │
│  - Database Models                       │
└──────────────┬──────────────────────────┘
               │
┌──────────────▼──────────────────────────┐
│        Database Layer                    │
│  (PostgreSQL)                            │
│  - Persistent Data Storage               │
└─────────────────────────────────────────┘
```

## 📂 Project Structure

```
Spring_Hibernate/
├── pom.xml                          # Maven configuration
├── BUILD_AND_RUN.txt               # Build instructions
├── SETUP_CHECKLIST.txt             # Setup verification
├── QUICK_REFERENCE.txt             # Quick guide
├── DATABASE_SCHEMA.txt             # SQL scripts
├── FINAL_SUMMARY.txt               # Complete documentation
│
└── src/main/
    ├── java/pom/capgemini/
    │   ├── Main.java               # Application entry point
    │   ├── AppService.java         # Connection testing
    │   │
    │   ├── config/
    │   │   └── HibernateConfig.java
    │   │
    │   ├── controller/
    │   │   └── EmployeeController.java
    │   │
    │   ├── service/
    │   │   ├── EmployeeService.java
    │   │   └── impl/
    │   │       └── EmployeeServiceImpl.java
    │   │
    │   ├── dao/
    │   │   ├── EmployeeDAO.java
    │   │   └── impl/
    │   │       └── EmployeeDao.java
    │   │
    │   ├── entity/
    │   │   ├── Employee.java
    │   │   └── User.java
    │   │
    │   ├── exception/
    │   │   ├── InvalidDataException.java
    │   │   └── ResourceNotFoundException.java
    │   │
    │   └── util/
    │       ├── ValidationUtil.java
    │       └── LoggerUtil.java
    │
    └── resources/
        ├── applicationContext.xml
        └── META-INF/
            └── persistence.xml
```

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Maven 3.6+
- PostgreSQL 10+

### Setup Steps

1. **Create PostgreSQL Database**
   ```sql
   CREATE DATABASE mydb;
   ```

2. **Build Project**
   ```bash
   mvn clean install
   ```

3. **Run Application**
   ```bash
   mvn exec:java -Dexec.mainClass="pom.capgemini.Main"
   ```

4. **Verify Database**
   ```sql
   SELECT * FROM employees;
   ```

## 💼 Employee Entity

```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false)
    private Double salary;
    
    @Column(length = 100)
    private String position;
    
    @Column(length = 100)
    private String department;
}
```

## 🔧 Configuration

### Database Connection
- **Driver**: org.postgresql.Driver
- **URL**: jdbc:postgresql://localhost:5432/mydb
- **User**: postgres
- **Password**: root

### Spring Configuration
- **XML-based**: `applicationContext.xml`
- **Component Scanning**: Enabled
- **Transaction Management**: JPA-based
- **DDL Strategy**: Auto-update (for development)

### Hibernate Properties
- **Dialect**: PostgreSQLDialect
- **DDL Auto**: update (auto-create/update tables)
- **Show SQL**: true (log SQL statements)
- **Format SQL**: true (formatted output)
- **Batch Size**: 20 (batch operations)
- **Connection Pool**: C3P0 (min: 5, max: 20)

## 📋 Employee Controller Methods

| Method | Parameters | Returns | Description |
|--------|-----------|---------|-------------|
| `addNewEmployee()` | Employee | void | Create new employee |
| `updateEmployeeDetails()` | Employee | void | Update existing employee |
| `deleteEmployee()` | Integer id | void | Delete employee by ID |
| `retrieveEmployee()` | Integer id | Employee | Get employee by ID |
| `retrieveAllEmployees()` | - | List<Employee> | Get all employees |
| `retrieveEmployeesByDepartment()` | String dept | List<Employee> | Get by department |

## ✅ Features

- ✓ Complete CRUD operations for Employees
- ✓ Data validation in service layer
- ✓ Custom exception handling
- ✓ Transaction management
- ✓ Parameterized queries (SQL injection prevention)
- ✓ Component-based dependency injection
- ✓ Proper separation of concerns
- ✓ Logging with SLF4J
- ✓ Connection pooling
- ✓ Auto schema generation

## 🔍 Sample Data

The application automatically creates sample employees:

| Name | Email | Salary | Position | Department |
|------|-------|--------|----------|-----------|
| John Doe | john@example.com | 50000 | Senior Developer | IT |
| Jane Smith | jane@example.com | 45000 | Developer | IT |
| Bob Johnson | bob@example.com | 55000 | Manager | HR |

## 📊 Database Schema

### employees table
```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    salary DOUBLE PRECISION NOT NULL,
    position VARCHAR(100),
    department VARCHAR(100)
);
```

## 🧪 Testing the Application

After running the application, verify in PostgreSQL:

```sql
-- Check all employees
SELECT * FROM employees;

-- Filter by department
SELECT * FROM employees WHERE department = 'IT';

-- Count by department
SELECT department, COUNT(*) FROM employees GROUP BY department;
```

## 📚 Documentation Files

- **BUILD_AND_RUN.txt** - Complete build and run instructions
- **QUICK_REFERENCE.txt** - Quick usage guide
- **DATABASE_SCHEMA.txt** - SQL scripts and queries
- **SETUP_CHECKLIST.txt** - Setup verification checklist
- **FINAL_SUMMARY.txt** - Detailed technical documentation
- **COMPLETE_FILE_LISTING.txt** - File reference guide

## 🔐 Exception Handling

### Custom Exceptions
- **InvalidDataException** - Thrown when validation fails
- **ResourceNotFoundException** - Thrown when entity not found

Both extend `RuntimeException` for automatic transaction rollback.

## 📈 Validation Rules

| Field | Rules |
|-------|-------|
| Name | Required, min 2 chars |
| Email | Required, valid format |
| Salary | Required, >= 0 |
| Age | 0-150 range (User entity) |

## 🔄 Transaction Management

- **Strategy**: Annotation-driven (@Transactional)
- **Manager**: JpaTransactionManager
- **Isolation**: Default (READ_COMMITTED)
- **Rollback**: On unchecked exceptions

## 🛠️ Next Steps for Development

1. Add more entities (Department, Project, etc.)
2. Implement REST API with Spring Web
3. Add pagination and sorting
4. Implement search functionality
5. Add Spring Security
6. Create unit and integration tests
7. Add Swagger documentation
8. Optimize queries with caching

## 📞 Support & Troubleshooting

### Common Issues

**PostgreSQL Connection Refused**
- Ensure PostgreSQL is running
- Verify credentials: postgres/root
- Check database exists: mydb

**Build Failures**
- Verify Java 21+ installed
- Run: `mvn clean install -U`
- Check internet connection

**No Entity Manager**
- Verify persistence.xml exists in META-INF
- Check applicationContext.xml configuration
- Ensure Hibernate JAR in classpath

## 📝 License

This project is provided as-is for educational purposes.

---

**Created**: February 2026  
**Status**: ✅ Production Ready  
**Version**: 1.0-SNAPSHOT

For detailed information, refer to the documentation files in the project root.

