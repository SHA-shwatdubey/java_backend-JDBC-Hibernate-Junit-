# BASIC SPRING HIBERNATE EMPLOYEE PROJECT

## SIMPLE STRUCTURE

**Employee Fields:**
- id (Auto-generated)
- name (String)
- salary (Double)

## QUICK START

### 1. Create Database
```sql
CREATE DATABASE mydb;
```

### 2. Build
```bash
mvn clean install
```

### 3. Run
```bash
mvn exec:java -Dexec.mainClass="pom.capgemini.Main"
```

## PROJECT STRUCTURE

```
src/main/java/pom/capgemini/
├── Main.java                          (Run this)
├── entity/
│   └── Employee.java                  (3 fields only)
├── dao/
│   ├── EmployeeDAO.java               (Interface)
│   └── impl/EmployeeDao.java          (Implementation)
├── service/
│   ├── EmployeeService.java           (Interface)
│   └── impl/EmployeeServiceImpl.java   (Implementation)
└── controller/
    └── EmployeeController.java        (Controller)

src/main/resources/
├── applicationContext.xml             (Spring config)
└── META-INF/persistence.xml          (JPA config)
```

## CODE FLOW

```
Main.java
    ↓
EmployeeController
    ↓
EmployeeService (Business Logic)
    ↓
EmployeeDAO (Database Operations)
    ↓
Employee (Entity)
    ↓
PostgreSQL Database
```

## DATABASE SCHEMA

```sql
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE PRECISION NOT NULL
);
```

## SIMPLE EXAMPLE

```java
// Create Employee
Employee emp = new Employee("John", 50000.0);
controller.addEmployee(emp);

// Get All
List<Employee> list = controller.getAllEmployees();
list.forEach(System.out::println);

// Get One
Employee e = controller.getEmployee(1);
System.out.println(e);
```

## OUTPUT EXAMPLE

```
Employee{id=1, name='John', salary=50000.0}
Employee{id=2, name='Priya', salary=45000.0}
Employee{id=3, name='Amit', salary=55000.0}
```

That's it! Simple aur clean code. 🎯

