# Spring Framework - Basic Annotation Project (Hindi Explanation)

## 📚 Project Overview
Ye ek simple Spring Framework project hai jo **Employee** class ke through Spring ke basic concepts explain karta hai.

## 🎯 Spring ke Main Concepts

### 1. **IOC (Inversion of Control) Container**
- Spring ek container hai jo objects ko manage karta hai
- Hume manually `new Employee()` nahi likhna padta
- Spring automatically objects create aur manage karta hai

### 2. **Dependency Injection (DI)**
- Spring objects ko create karke humein provide karta hai
- Hum sirf configuration dete hain, baaki Spring sambhalta hai

### 3. **Annotations**

#### `@Configuration`
```java
@Configuration
public class DemoConfiguration {
    // Ye class configuration class hai
}
```
- Ye annotation batata hai ki ye class Spring ki configuration class hai
- Isme hum @Bean methods define karte hain

#### `@Bean`
```java
@Bean
public Employee employee1() {
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Rajesh Kumar");
    emp.setSalary(45000.0);
    return emp;
}
```
- Method ko Spring bean banata hai
- Spring is method ko automatically call karega
- Return value Spring container mein store hoga
- Bean ka naam by default method ka naam hota hai

#### `@Bean(name = "customName")`
```java
@Bean(name = "manager")
public Employee createManager() {
    // Custom naam se bean create hoga
}
```
- Hum bean ko custom naam de sakte hain
- Is naam se bean ko retrieve kar sakte hain

## 📁 Project Structure

```
Basic_Of_Spring_with_Anotation/
├── src/main/java/pom/capgemini/
│   ├── Employee.java              (Simple POJO class)
│   ├── DemoConfiguration.java     (Spring Configuration with @Bean)
│   └── Main.java                  (Application entry point)
├── pom.xml                        (Maven dependencies)
└── README_HINDI.md                (Ye file)
```

## 🔧 Important Files

### 1. **Employee.java**
- Simple POJO (Plain Old Java Object) class
- Properties: id, name, salary
- Getters aur Setters
- msg() method for displaying employee details

### 2. **DemoConfiguration.java**
- `@Configuration` annotation se mark kiya gaya hai
- Teen `@Bean` methods hain:
  - `employee1()` - Default naam se bean
  - `createManager()` - "manager" naam se bean
  - `createDeveloper()` - "developer" naam se bean

### 3. **Main.java**
- Application ka entry point
- Spring Container (IOC) initialize karta hai
- Beans ko retrieve aur use karta hai
- Spring concepts ko demonstrate karta hai

## 🚀 Kaise Chalaye?

### Method 1: IDE se
1. Main.java file ko open karo
2. Run button pe click karo

### Method 2: Maven se
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="pom.capgemini.Main"
```

## 📤 Expected Output

```
========================================
SPRING FRAMEWORK - EMPLOYEE MANAGEMENT
========================================

✓ Spring Container initialized successfully!

1. Bean naam 'employee1' se retrieve karo:
Employee [id=1, name=Rajesh Kumar, salary=45000.0]

2. Bean naam 'manager' se retrieve karo:
Employee [id=101, name=Priya Sharma, salary=85000.0]

3. Bean naam 'developer' se retrieve karo:
Employee [id=25, name=Amit Singh, salary=60000.0]

4. Bean ko modify karna:
   Pehle:
Employee [id=1, name=Rajesh Kumar, salary=45000.0]
   Baad mein (salary badhayi):
Employee [id=1, name=Rajesh Kumar, salary=50000.0]

========================================
SPRING KEY CONCEPTS:
========================================
1. IOC Container: Spring ne 3 Employee objects manage kiye
2. @Configuration: DemoConfiguration class ne beans define kiye
3. @Bean: Teen methods ne teen alag Employee beans banaye
4. Dependency Injection: Hume 'new' keyword nahi likhna pada
5. Bean Scope: Default scope SINGLETON hai (ek hi object reuse hota hai)
========================================

✓ Spring Container closed successfully!
```

## 🎓 Key Learnings

### 1. **Spring Container (IOC)**
```java
AnnotationConfigApplicationContext ioc = 
    new AnnotationConfigApplicationContext(DemoConfiguration.class);
```
- Ye line Spring container create karti hai
- DemoConfiguration class se configuration load hoti hai

### 2. **Bean Retrieval**
```java
// Method 1: Bean naam se
Employee emp = (Employee) ioc.getBean("employee1");

// Method 2: Class type se
Employee emp = ioc.getBean(Employee.class); // Jab ek hi bean ho us type ka
```

### 3. **Bean Scope**
- Default scope: **SINGLETON**
- Matlab same bean naam se har baar same object milega
- Ek baar create hota hai, phir reuse hota hai

### 4. **Benefits**
✅ No manual object creation (`new` keyword nahi chahiye)  
✅ Spring objects ko manage karta hai  
✅ Loose coupling  
✅ Easy testing  
✅ Better code organization  

## 🔍 Common Issues

### Issue 1: Bean not found
```
NoSuchBeanDefinitionException
```
**Solution:** Check karo bean ka naam sahi hai ya nahi

### Issue 2: Multiple beans of same type
```
NoUniqueBeanDefinitionException
```
**Solution:** Bean naam specify karo ya @Primary use karo

## 📚 Dependencies (pom.xml)

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.3.39</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.39</version>
</dependency>
```

## 💡 Next Steps

Agar aap aur advance Spring concepts seekhna chahte ho:

1. **@ComponentScan** - Automatic bean discovery
2. **@Autowired** - Automatic dependency injection
3. **@Scope** - Bean scopes (Singleton, Prototype, etc.)
4. **@Qualifier** - Multiple beans ko distinguish karne ke liye
5. **Spring Boot** - Convention over configuration

## 📞 Help

Agar koi doubt ho toh:
1. Code ko carefully padho
2. Comments padho (Hindi mein likhe hain)
3. Output ko expected output se compare karo
4. Spring documentation dekho

---

**Happy Coding! 🎉**

*Spring Framework seekhna mushkil nahi hai, bas practice karte raho!*

