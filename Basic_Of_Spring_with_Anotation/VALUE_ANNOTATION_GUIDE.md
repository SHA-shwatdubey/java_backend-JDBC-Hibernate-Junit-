# 🎯 @Value Annotation - Complete Guide (HINDI)

## 📚 @Value Kya Hai?

**@Value** ek Spring annotation hai jo **properties aur values ko beans mein inject** karta hai.

```java
@Value("hardcoded value")
private String name;
```

---

## 🎓 @Value Ke Different Ways

### 1️⃣ **Hardcoded Value**
```java
@Value("John Doe")
private String name;

@Value("25")
private int age;

@Value("50000.0")
private double salary;
```

**Kya Hoga?**
- Spring directly ye values inject karega
- No property file needed
- Simple aur direct hai

**Example:**
```java
@Component
public class Employee {
    
    @Value("Rajesh Kumar")
    private String name;  // Automatically "Rajesh Kumar" inject hoga
    
    @Value("101")
    private int id;  // Automatically 101 inject hoga
}
```

---

### 2️⃣ **Default Value Ke Saath** (Most Common)
```java
@Value("${propertyName:defaultValue}")
private String name;
```

**Kaise Kaam Karta Hai?**
- Pehle property file mein `propertyName` dhundta hai
- Agar property file mein `propertyName` nahi milta, to `defaultValue` use karta hai
- **Colon (`:`)** default value ka separator hai

**Example:**
```java
@Component
public class Employee {
    
    // Agar "employee.name" property file mein hai to use hoga
    // Nahi to "Unassigned" use hoga
    @Value("${employee.name:Unassigned}")
    private String name;
    
    // Agar "employee.salary" property file mein hai to use hoga
    // Nahi to "0" use hoga
    @Value("${employee.salary:0}")
    private double salary;
}
```

---

### 3️⃣ **Property File Se**
```java
@Value("${server.port}")
private int port;

@Value("${app.name}")
private String appName;
```

**application.properties file mein:**
```properties
server.port=8080
app.name=My Spring App
```

---

### 4️⃣ **SpEL Expression (Spring Expression Language)**
```java
@Value("#{systemProperties['java.version']}")
private String javaVersion;

@Value("#{T(java.lang.Math).PI}")
private double pi;

@Value("#{new java.util.Date()}")
private Date currentDate;
```

---

## 📊 @Value Examples - Practical

### Example 1: Employee Class
```java
@Component
public class Employee {
    
    @Value("0")
    private int id;
    
    @Value("${employee.name:Unknown Employee}")
    private String name;
    
    @Value("${employee.salary:0.0}")
    private double salary;
    
    // Getters aur Setters
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
```

### Example 2: Application Configuration
```java
@Component
public class AppConfig {
    
    @Value("${app.name:Default App}")
    private String appName;
    
    @Value("${app.version:1.0}")
    private String appVersion;
    
    @Value("${server.port:8080}")
    private int port;
    
    @Value("${debug.mode:false}")
    private boolean debugMode;
    
    public void printConfig() {
        System.out.println("App: " + appName);
        System.out.println("Version: " + appVersion);
        System.out.println("Port: " + port);
        System.out.println("Debug: " + debugMode);
    }
}
```

### Example 3: Database Configuration
```java
@Component
public class DatabaseConfig {
    
    @Value("${db.url:jdbc:mysql://localhost:3306/mydb}")
    private String dbUrl;
    
    @Value("${db.user:root}")
    private String dbUser;
    
    @Value("${db.password:}")
    private String dbPassword;
    
    @Value("${db.pool.size:10}")
    private int poolSize;
}
```

---

## 🔧 Property File Setup

### application.properties File Banana

```properties
# Employee Configuration
employee.name=Rajesh Kumar
employee.salary=45000.0
employee.department=IT

# Application Configuration
app.name=Spring Demo App
app.version=1.0.0
server.port=8080

# Database Configuration
db.url=jdbc:mysql://localhost:3306/mydb
db.user=root
db.password=admin123
db.pool.size=20
```

### File Location:
```
src/
  main/
    resources/
      application.properties  ← Yaha file honi chahiye
```

---

## 🎯 @Value vs Manual Initialization

### ❌ Traditional Way (Manual)
```java
public class Employee {
    private String name = "Unknown";
    private int id = 0;
    private double salary = 0.0;
}
```

**Problems:**
- Hardcoded values
- Change karne ke liye code modify karna padta hai
- Recompile karna padta hai

---

### ✅ @Value Way (Spring)
```java
@Component
public class Employee {
    
    @Value("${employee.name:Unknown}")
    private String name;
    
    @Value("${employee.id:0}")
    private int id;
    
    @Value("${employee.salary:0.0}")
    private double salary;
}
```

**Benefits:**
- Property file se values lete hain
- Runtime pe change kar sakte ho
- Recompile nahi karna padta
- Easy configuration management

---

## 📝 @Value - Type Conversion

### String
```java
@Value("${app.name}")
private String appName;
```

### Integer
```java
@Value("${server.port}")
private int port;
```

### Double
```java
@Value("${tax.rate}")
private double taxRate;
```

### Boolean
```java
@Value("${debug.enabled}")
private boolean debugEnabled;
```

### List/Array
```java
@Value("${app.allowed.ips:127.0.0.1,192.168.1.1}")
private String[] allowedIps;
```

### Automatic Type Conversion
Spring automatically types convert karta hai:
- `"8080"` → `8080` (int)
- `"50000.5"` → `50000.5` (double)
- `"true"` → `true` (boolean)

---

## 🔄 @Value vs @ConfigurationProperties

### @Value
```java
@Component
public class ServerConfig {
    
    @Value("${server.port:8080}")
    private int port;
    
    @Value("${server.host:localhost}")
    private String host;
}
```

**Use Case:** Chhoti configuration ke liye

---

### @ConfigurationProperties
```java
@Component
@ConfigurationProperties(prefix = "server")
public class ServerConfig {
    
    private int port = 8080;
    private String host = "localhost";
    
    // Getters aur Setters
}
```

**Use Case:** Badi configuration ke liye

---

## ⚠️ Common Mistakes

### ❌ Mistake 1: Wrong Syntax
```java
@Value("employee.name")  // WRONG
private String name;

@Value("${employee.name}")  // CORRECT
private String name;
```

### ❌ Mistake 2: Missing Default Value
```java
@Value("${missing.property}")  // Agar property nahi hai to error!
private String value;

@Value("${missing.property:defaultValue}")  // CORRECT - Safe
private String value;
```

### ❌ Mistake 3: Wrong Type
```java
@Value("${port:abc}")  // String ke jagah abc - error!
private int port;

@Value("${port:8080}")  // CORRECT
private int port;
```

---

## 🎯 Real-World Example

### application.properties
```properties
# Company Configuration
company.name=Tech Solutions Inc.
company.city=Bangalore
company.website=www.techsolutions.com

# Employee Settings
employee.name=Rajesh Kumar
employee.id=1
employee.salary=45000.0
employee.department=IT Department

# Department Settings
department.name=Software Development
department.employee.count=50
department.budget=500000
```

### DemoConfiguration.java
```java
@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class DemoConfiguration {
    
    @Value("${company.name}")
    private String companyName;
    
    @Value("${company.city}")
    private String companyCity;
    
    @Bean
    public Employee createManager() {
        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Priya Sharma");
        emp.setSalary(85000.0);
        return emp;
    }
}
```

### Employee.java
```java
@Component
public class Employee {
    
    @Value("${employee.id:0}")
    private int id;
    
    @Value("${employee.name:Unknown}")
    private String name;
    
    @Value("${employee.salary:0.0}")
    private double salary;
    
    public void display() {
        System.out.println("Employee: " + name + " (ID: " + id + ")");
        System.out.println("Salary: " + salary);
    }
}
```

### Department.java
```java
@Component
public class Department {
    
    @Value("${department.name:IT Department}")
    private String departmentName;
    
    @Value("${department.employee.count:0}")
    private int employeeCount;
    
    @Value("${department.budget:0}")
    private double budget;
}
```

---

## 🎓 Key Points Yaad Rakho

### ✅ DO's
1. **Default value hamesha do** - `@Value("${prop:default}")`
2. **Property file use karo** - Configuration separate rakho
3. **Meaningful names do** - `${employee.salary}` not `${s}`
4. **Type se match karo** - `"8080"` int field mein
5. **Documentation likho** - Kya kya properties hain

### ❌ DON'Ts
1. **Hardcoded values avoid karo** - Unless absolutely necessary
2. **Property name galat mat likho** - Typo se error hoga
3. **Default value mat bhulo** - Agar property file mein nahi ho
4. **Sensitive data hardcode mat karo** - Passwords etc.

---

## 🚀 Testing

### Test Case
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
    
    @Autowired
    private Employee employee;
    
    @Test
    public void testValueInjection() {
        assertNotNull(employee.getName());
        assertTrue(employee.getId() > 0);
    }
}
```

---

## 📞 Troubleshooting

### Problem: Value inject nahi ho raha

**Solution:**
1. Check karo @Value syntax sahi hai
2. Check karo property file location sahi hai
3. Check karo application.properties mein property defined hai
4. Check karo default value di hai

### Problem: Type mismatch error

**Solution:**
```java
// WRONG
@Value("${port:abc}")
private int port;

// CORRECT
@Value("${port:8080}")
private int port;
```

### Problem: Null Pointer Exception

**Solution:**
- Default value always do
- `@Value("${prop:defaultValue}")` use karo

---

## 🎉 Summary

| Feature | Description |
|---------|-------------|
| **Syntax** | `@Value("${propertyName:defaultValue}")` |
| **Purpose** | Properties aur values inject karna |
| **Location** | Fields pe laga sakte ho |
| **Benefits** | Configuration management, reusability |
| **Type Support** | String, int, double, boolean, List, etc. |
| **Default Values** | Colon (`:`) se default value set karte hain |

---

**@Value annotation master bano aur configuration management easy kar lo! 🎯**

*"Configuration separate rakho, code clean rakho!"*

