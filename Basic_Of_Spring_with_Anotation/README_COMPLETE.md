# 🌟 Spring Framework Annotations - Complete Guide (Hindi)

## 📚 Project Overview
Ye project **Employee**, **Person** aur **Department** classes ke through Spring ke **saare important annotations** explain karta hai.

**Entry Points (Main Files):**
- `Main1` - Employee, Person, Department annotations demo
- `Main2` - Mobile, ShashwatMobile annotations demo
- `Main3` - Constructor injection example (Book -> Library)
- `Main4` - @Service + @Repository example (Student)
- `ArrayListExample` - Java ArrayList basic operations
- `HashMapExample` - Java HashMap basic operations

---

## 🎯 Spring Annotations - Complete List

### 1️⃣ **@Configuration**
```java
@Configuration
public class DemoConfiguration {
    // Configuration methods
}
```

**Kya Hai?**
- Ye annotation batata hai ki ye class **configuration class** hai
- Spring isko sabse pehle load karta hai
- Isme @Bean methods aur @ComponentScan hote hain

**Kab Use Kare?**
- Jab Spring application ki settings define karni ho
- Beans manually create karne ho

---

### 2️⃣ **@ComponentScan**
```java
@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class DemoConfiguration {
}
```

**Kya Hai?**
- Spring ko batata hai **kaha** beans search karne hain
- Specified package mein @Component classes ko **automatically** detect karta hai

**Kaise Kaam Karta Hai?**
1. Spring specified package scan karta hai
2. @Component, @Service, @Repository annotated classes dhundta hai
3. Automatically un classes ke beans bana deta hai

**Example:**
```
pom.capgemini package mein:
  - Person.java (@Component) ✓ Auto-detected
  - Employee.java (@Component) ✓ Auto-detected
  - Department.java (@Component) ✓ Auto-detected
```

---

### 3️⃣ **@Component**
```java
@Component
public class Person {
    private String name;
    private int age;
}
```

**Kya Hai?**
- Class ko **Spring bean** banata hai
- @ComponentScan isko automatically detect karta hai
- Spring khud object create kar dega

**Benefits:**
✅ No manual @Bean method needed  
✅ Automatic bean creation  
✅ Simple aur clean code  

**Kab Use Kare?**
- Simple beans ke liye
- Jaha custom configuration ki zarurat na ho

---

### 4️⃣ **@Bean**
```java
@Configuration
public class DemoConfiguration {
    
    @Bean(name = "manager")
    public Employee createManager() {
        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Priya Sharma");
        emp.setSalary(85000.0);
        return emp;
    }
}
```

**Kya Hai?**
- **Method level** annotation
- Manual bean creation ke liye
- Specific configuration chahiye to use karte hain

**Features:**
- Custom bean naam de sakte hain: `@Bean(name = "manager")`
- Pre-configured values set kar sakte hain
- Zyada control milta hai

**Kab Use Kare?**
- Jab specific configuration chahiye
- Third-party libraries ke objects banane ho
- Multiple beans same class ke banane ho

---

### 5️⃣ **@Autowired**
```java
@Component
public class Department {
    
    @Autowired  // Field Injection
    private Person person;
    
    private Employee employee;
    
    @Autowired  // Constructor Injection (Recommended)
    public Department(Employee employee) {
        this.employee = employee;
    }
}
```

**Kya Hai?**
- **Automatic Dependency Injection**
- Spring automatically dependencies inject karta hai
- Hume manually set nahi karna padta

**Types of Injection:**

#### a) Field Injection
```java
@Autowired
private Person person;
```
- Simple hai
- But testing mein problem ho sakti hai

#### b) Constructor Injection ✅ (Recommended)
```java
@Autowired
public Department(Employee employee) {
    this.employee = employee;
}
```
- Best practice hai
- Testing easy hoti hai
- Dependencies clearly visible hain

#### c) Setter Injection
```java
@Autowired
public void setPerson(Person person) {
    this.person = person;
}
```
- Optional dependencies ke liye

**Kaise Kaam Karta Hai?**
1. Spring container mein Employee bean hai
2. Department class mein Employee chahiye
3. Spring automatically Employee bean inject kar dega

---

### 6️⃣ **@Value**
```java
@Component
public class Employee {
    
    @Value("0")
    private int id;
    
    @Value("Unknown Employee")
    private String name;
    
    @Value("0.0")
    private double salary;
}
```

**Kya Hai?**
- Properties ko inject karne ke liye
- Default values set karne ke liye

**Use Cases:**
```java
@Value("John Doe")  // Hardcoded value
private String name;

@Value("${app.name}")  // Property file se value
private String appName;

@Value("#{systemProperties['user.name']}")  // SpEL expression
private String systemUser;
```

---

## 📊 @Component vs @Bean - Complete Comparison

| Feature | @Component | @Bean |
|---------|-----------|-------|
| **Level** | Class level | Method level |
| **Location** | Class pe directly | @Configuration class mein |
| **Detection** | @ComponentScan se automatic | Manual definition |
| **Control** | Kam control | Zyada control |
| **Use Case** | Simple beans | Complex configuration |
| **Example** | `@Component class Person {}` | `@Bean public Person createPerson() {}` |

---

## 🏗️ Project Structure

```
Basic_Of_Spring_with_Anotation/
│
├── src/main/java/pom/capgemini/
│   │
│   ├── Person.java                    [@Component]
│   │   └── Simple POJO with @Component annotation
│   │
│   ├── Employee.java                  [@Component, @Value]
│   │   └── Bean with default values using @Value
│   │
│   ├── Department.java                [@Component, @Autowired]
│   │   └── Shows dependency injection with @Autowired
│   │
│   ├── DemoConfiguration.java         [@Configuration, @ComponentScan, @Bean]
│   │   └── Configuration class with manual beans
│   │
│   └── Main.java
│       └── Application entry point
│
├── pom.xml
└── README_COMPLETE.md (Ye file)
```

---

## 🚀 Kaise Kaam Karta Hai? (Step by Step)

### Step 1: Spring Container Initialize
```java
AnnotationConfigApplicationContext ioc = 
    new AnnotationConfigApplicationContext(DemoConfiguration.class);
```
- Spring container start hota hai
- DemoConfiguration class load hoti hai

### Step 2: @ComponentScan Execute
```java
@ComponentScan(basePackages = "pom.capgemini")
```
- Spring "pom.capgemini" package scan karta hai
- @Component classes detect hoti hain:
  - Person.java ✓
  - Employee.java ✓
  - Department.java ✓

### Step 3: Beans Create
- **@Component beans:** Automatically create
  - Person bean ✓
  - Employee bean ✓
  - Department bean ✓

- **@Bean methods:** Manually execute
  - manualEmployee bean ✓
  - manager bean ✓
  - developer bean ✓
  - manualPerson bean ✓

### Step 4: @Autowired Dependencies Inject
```java
@Autowired
private Person person;  // Spring automatically inject karega
```
- Department class mein Person aur Employee chahiye
- Spring automatically inject kar deta hai

### Step 5: Beans Use Karo
```java
Person person = ioc.getBean(Person.class);
Employee emp = ioc.getBean("manager");
```

---

## 💡 Real-World Example

### Scenario: Company Management System

```java
// 1. Employee (Basic component)
@Component
public class Employee {
    private String name;
    private double salary;
}

// 2. Department (Has dependencies)
@Component
public class Department {
    @Autowired
    private Employee employee;  // Automatic injection
}

// 3. Configuration (Custom beans)
@Configuration
@ComponentScan(basePackages = "com.company")
public class AppConfig {
    
    @Bean(name = "ceo")
    public Employee createCEO() {
        Employee ceo = new Employee();
        ceo.setName("Sundar Pichai");
        ceo.setSalary(500000);
        return ceo;
    }
}

// 4. Main Application
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Employee regularEmp = ctx.getBean(Employee.class);
        Employee ceo = (Employee) ctx.getBean("ceo");
        Department dept = ctx.getBean(Department.class);
    }
}
```

---

## 🎓 Key Learnings

### 1. IOC (Inversion of Control)
```java
// Traditional way ❌
Employee emp = new Employee();
emp.setName("John");

// Spring way ✅
Employee emp = ioc.getBean(Employee.class);
// Spring ne already object bana diya!
```

### 2. Dependency Injection
```java
// Traditional way ❌
public class Department {
    private Employee emp = new Employee();  // Tight coupling
}

// Spring way ✅
@Component
public class Department {
    @Autowired
    private Employee emp;  // Loose coupling, Spring inject karega
}
```

### 3. Component Scanning
```java
// Manual bean creation ❌
@Bean public Person p1() { return new Person(); }
@Bean public Employee e1() { return new Employee(); }
@Bean public Department d1() { return new Department(); }

// Component Scanning ✅
@ComponentScan(basePackages = "com.company")
// Sab automatically detect ho jayega!
```

---

## 🔥 Important Points

### ✅ DO's
1. **@ComponentScan use karo** - Automatic bean detection ke liye
2. **@Component use karo** - Simple beans ke liye
3. **@Bean use karo** - Complex configuration ke liye
4. **Constructor injection prefer karo** - @Autowired ke saath
5. **Meaningful bean names do** - `@Bean(name = "manager")`

### ❌ DON'Ts
1. @Component aur @Bean dono same class pe mat use karo
2. @ComponentScan ke bina @Component kaam nahi karega
3. Circular dependencies se bacho
4. Field injection avoid karo (testing mein problem)

---

## 🎯 Common Errors & Solutions

### Error 1: NoSuchBeanDefinitionException
```
No qualifying bean of type 'Employee' available
```

**Reason:**
- Bean nahi mila Spring container mein

**Solution:**
- Check karo @Component annotation hai ya nahi
- Check karo @ComponentScan sahi package scan kar raha hai
- Check karo bean naam sahi hai

### Error 2: NoUniqueBeanDefinitionException
```
expected single matching bean but found 2
```

**Reason:**
- Same type ke multiple beans hain

**Solution:**
```java
// Option 1: Bean naam specify karo
@Bean(name = "employee1")
public Employee createEmp1() { ... }

@Bean(name = "employee2")
public Employee createEmp2() { ... }

// Usage
Employee emp = (Employee) ioc.getBean("employee1");

// Option 2: @Primary use karo
@Bean
@Primary
public Employee defaultEmployee() { ... }
```

### Error 3: UnsatisfiedDependencyException
```
Error creating bean with name 'department': Unsatisfied dependency
```

**Reason:**
- Dependency inject nahi ho payi

**Solution:**
- Check karo dependent bean exist karta hai
- Check karo @Autowired sahi jagah hai
- Check karo circular dependency toh nahi

---

## 📝 Complete Annotations Summary

| Annotation | Type | Purpose | Example |
|------------|------|---------|---------|
| `@Configuration` | Class | Configuration class define karna | `@Configuration class Config {}` |
| `@ComponentScan` | Class | Package scan karna | `@ComponentScan("com.app")` |
| `@Component` | Class | Automatic bean creation | `@Component class Person {}` |
| `@Bean` | Method | Manual bean creation | `@Bean public Person p() {}` |
| `@Autowired` | Field/Constructor/Setter | Dependency injection | `@Autowired private Person p;` |
| `@Value` | Field | Value injection | `@Value("John") String name;` |

---

## 🎉 Final Tips

1. **Start Simple**
   - Pehle @Component samjho
   - Phir @Autowired samjho
   - Last mein @Bean use karo

2. **Practice Karo**
   - Khud se beans banao
   - Dependency injection try karo
   - Errors ko solve karo

3. **Best Practices Follow Karo**
   - Constructor injection use karo
   - Meaningful names do
   - Comments likho

4. **Documentation Padho**
   - Spring official docs
   - Baeldung tutorials
   - Stack Overflow

---

## 🚀 Run Karne Ke Liye

```bash
# Compile
javac -cp "spring-jars/*" src/main/java/pom/capgemini/*.java

# Run
java -cp "spring-jars/*:." pom.capgemini.Main
```

**Ya IDE se:**
1. Main.java open karo
2. Run button dabao
3. Output dekho!

---

## 📞 Help Needed?

Agar koi doubt ho toh:
1. Comments carefully padho (Hindi mein hain)
2. Code ko step by step run karo
3. Errors ko carefully padho
4. Google karo specific error

---

**🎉 Happy Learning! Spring Framework master bano! 🎉**

*"Code likhte raho, seekhte raho!" - Every Spring Developer*

---

**Made with ❤️ for Spring Learners**
