# 🎯 TWO SEPARATE MAIN FILES - SPRING PROJECT

## 📁 Project Structure (Updated)

```
Basic_Of_Spring_with_Anotation/
│
├── src/main/java/pom/capgemini/
│   │
│   ├── CONFIGURATION:
│   │   └── DemoConfiguration.java    (Shared by both Main files)
│   │
│   ├── CLASSES:
│   │   ├── Employee.java             (@Component + @Value)
│   │   ├── Person.java               (@Component + @Value)
│   │   ├── Department.java           (@Component + @Autowired + @Value)
│   │   ├── Mobile.java               (@Component + @Value)
│   │   └── ShashwatMobile.java       (@Component + @Autowired + @Value)
│   │
│   ├── MAIN FILES (Two separate):
│   │   ├── Main1.java ✅             (Employee, Person, Department)
│   │   └── Main2.java ✅             (Mobile, ShashwatMobile)
│   │
│   └── (Old Main.java - DELETED)
│
└── Documentation Files
```

---

## 🎯 MAIN1.java - Employee, Person, Department

### Purpose
Employee, Person aur Department classes ko demonstrate karta hai

### What It Shows

```
STEP 1: Employee Bean (@Component + @Value)
   └─ Automatic bean creation
   └─ Properties with default values

STEP 2: Person Bean (@Component + @Value)
   └─ Another @Component class
   └─ @Value se properties inject

STEP 3: Manual Beans (@Bean methods)
   ├─ manualEmployee (Pre-configured)
   ├─ manager (Pre-configured)
   ├─ developer (Pre-configured)
   └─ manualPerson (Pre-configured)

STEP 4: Department Bean (@Component + @Autowired)
   ├─ Person automatically injected
   ├─ Employee automatically injected
   └─ Dependency Injection example!

STEP 5: @Value Properties Display
   └─ Values show karte hain

STEP 6: Bean Modification
   └─ Beans ko modify kar sakte hain
```

### Run Command
```bash
java -cp "spring-jars/*:." pom.capgemini.Main1
```

### Output Sample
```
╔════════════════════════════════════════════════════════════════╗
║   MAIN1 - EMPLOYEE, PERSON & DEPARTMENT DEMONSTRATION          ║
╚════════════════════════════════════════════════════════════════╝

STEP 1: @Component + @Value - Employee Bean

1️⃣  Employee Bean (via @Component):
Employee [id=0, name=Unassigned Employee, salary=0.0]

STEP 2: @Component + @Value - Person Bean

2️⃣  Person Bean (via @Component):
Person [name=Unknown Person, age=0, city=Unknown City]

STEP 3: @Bean - Manual Employee Beans

3️⃣  Manual Employee Bean:
Employee [id=1, name=Rajesh Kumar, salary=45000.0]

4️⃣  Manager Bean:
Employee [id=101, name=Priya Sharma, salary=85000.0]

... (aur baaki)
```

---

## 📱 MAIN2.java - Mobile, ShashwatMobile

### Purpose
Mobile aur ShashwatMobile classes ko demonstrate karta hai (Real-world example)

### What It Shows

```
STEP 1: Mobile Bean (@Component + @Value)
   └─ Smartphone specifications
   └─ 9 properties with @Value

STEP 2: ShashwatMobile Bean (@Component + @Autowired + @Value)
   ├─ Owner ki details (@Value)
   ├─ Mobile automatically injected (@Autowired)
   └─ Complete integrated example!

STEP 3: Dependency Injection Details
   └─ Mobile object automatically linked
   └─ Proof dikhaata hai

STEP 4: Detailed Property Display
   ├─ Owner details
   └─ Mobile details

STEP 5: Bean Modification
   └─ Owner details modify kar sakte hain
```

### Run Command
```bash
java -cp "spring-jars/*:." pom.capgemini.Main2
```

### Output Sample
```
╔════════════════════════════════════════════════════════════════╗
║   MAIN2 - MOBILE & SHASHWATMOBILE DEMONSTRATION               ║
╚════════════════════════════════════════════════════════════════╝

STEP 1: @Component + @Value - Mobile Bean

1️⃣  Mobile Bean (via @Component):
╔════════════════════════════════════════╗
║      📱 MOBILE PHONE DETAILS 📱         ║
╚════════════════════════════════════════╝
Phone Number: 9555660256
Brand: Apple
Model: iPhone 14 Pro Max
Storage: 128GB
RAM: 6 GB
Color: Silver
Price: ₹99999
OS: iOS
5G Capable: Yes
════════════════════════════════════════

STEP 2: @Component + @Autowired + @Value - ShashwatMobile Bean

2️⃣  ShashwatMobile Bean (via @Component with @Autowired):
╔════════════════════════════════════════╗
║   📱 SHASHWAT MOBILE OWNER INFO 📱      ║
╚════════════════════════════════════════╝

--- 👤 OWNER DETAILS ---
Name: Shashwat
Age: 20 years
City: India
Email: shashwat@example.com
Phone: 9555660256

--- 📱 MOBILE DETAILS ---
Brand: Apple
Model: iPhone 14 Pro Max
... (aur details)
```

---

## 🔄 Shared DemoConfiguration.java

**Same configuration dono Main files use karte hain:**

```java
@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class DemoConfiguration {
    
    @Value("${company.name:...}")
    private String companyName;
    
    @Bean(name = "manualEmployee")
    public Employee employee1() { ... }
    
    @Bean(name = "manager")
    public Employee createManager() { ... }
    
    @Bean(name = "developer")
    public Employee createDeveloper() { ... }
    
    @Bean(name = "manualPerson")
    public Person createPerson() { ... }
}
```

**Benefits:**
✅ Configuration ek jagah hai  
✅ Dono Main files same beans use karti hain  
✅ Easy maintenance  
✅ Consistent configuration  

---

## 📊 Classes & Annotations Summary

### MAIN1 Classes

| Class | Annotations | Purpose |
|-------|------------|---------|
| Employee | @Component, @Value | Employee details |
| Person | @Component, @Value | Person details |
| Department | @Component, @Autowired, @Value | Department + DI |

### MAIN2 Classes

| Class | Annotations | Purpose |
|-------|------------|---------|
| Mobile | @Component, @Value | Phone specs |
| ShashwatMobile | @Component, @Autowired, @Value | Owner + Phone (Real-world) |

### Shared Configuration

| Class | Annotations | Purpose |
|-------|------------|---------|
| DemoConfiguration | @Configuration, @ComponentScan, @Bean, @Value | Config for all |

---

## 🎓 What Each Main File Teaches

### MAIN1.java Seekhata Hai:
✅ Basic @Component usage  
✅ @Value property injection  
✅ @Bean manual bean creation  
✅ @Autowired dependency injection  
✅ Multiple beans management  
✅ Configuration with default values  

### MAIN2.java Seekhata Hai:
✅ @Component real-world use case  
✅ @Value practical application  
✅ @Autowired with real objects  
✅ Complete integration example  
✅ How objects talk to each other  
✅ Loose coupling benefits  

---

## 🚀 How to Use Both

### Option 1: Run Both Separately
```bash
# First, run MAIN1
java -cp "spring-jars/*:." pom.capgemini.Main1

# Then, run MAIN2
java -cp "spring-jars/*:." pom.capgemini.Main2
```

### Option 2: Run in IDE
1. **Main1.java** open karo → Run button dabao
2. **Main2.java** open karo → Run button dabao

### Option 3: Switch Between Them
- Main1 for Employee/Person/Department learning
- Main2 for real-world Mobile example

---

## 💡 Why Two Separate Main Files?

### Benefits:
1. **Clear Separation** - Different concepts separately demonstrate hoti hain
2. **Focused Learning** - Ek concept pura samajh aata hai
3. **Easy Testing** - Individually test kar sakte ho
4. **Flexible** - Kisi bhi ek ko run kar sakte ho
5. **Real-world** - MAIN2 practical scenario show karta hai
6. **Shared Config** - DemoConfiguration dono use karte hain (maintenance easy)

---

## 🎯 Concepts Per Main File

### MAIN1: Foundation Concepts
- Component creation
- Value injection
- Manual bean creation
- Multiple implementations

### MAIN2: Advanced Concepts
- Integration
- Dependency linking
- Real-world scenarios
- Complete lifecycle

---

## 📝 Flow Diagram

### MAIN1 Flow
```
DemoConfiguration
    ↓
@ComponentScan
    ↓
Detects:
  ├─ Employee
  ├─ Person
  └─ Department
    ↓
Creates @Bean:
  ├─ manualEmployee
  ├─ manager
  ├─ developer
  └─ manualPerson
    ↓
Injects @Autowired:
  ├─ Department.person
  └─ Department.employee
    ↓
MAIN1 displays all
```

### MAIN2 Flow
```
DemoConfiguration (same)
    ↓
@ComponentScan
    ↓
Detects:
  ├─ Mobile
  └─ ShashwatMobile
    ↓
Injects @Autowired:
  └─ ShashwatMobile.mobile
    ↓
@Value sets:
  ├─ Mobile properties
  └─ ShashwatMobile properties
    ↓
MAIN2 displays integration
```

---

## ✅ Project Status

| Component | Status | File |
|-----------|--------|------|
| Configuration | ✅ Complete | DemoConfiguration.java (Shared) |
| Employee | ✅ Complete | Main1.java |
| Person | ✅ Complete | Main1.java |
| Department | ✅ Complete | Main1.java |
| Mobile | ✅ Complete | Main2.java |
| ShashwatMobile | ✅ Complete | Main2.java |
| Documentation | ✅ Complete | README files |

---

## 🎉 Summary

**Ab aapke paas:**

✅ **MAIN1.java** - Employee, Person, Department learning  
✅ **MAIN2.java** - Mobile, ShashwatMobile real-world example  
✅ **DemoConfiguration.java** - Shared configuration (Ek hi rakhna tha!)  
✅ **5 Spring Classes** - All with annotations  
✅ **Complete Documentation** - README guides  

**Ab aap:**
- Dono Main files separately run kar sakte ho
- Dono ke concepts alag samjh sakte ho
- Same DemoConfiguration share kar sakte ho
- Production-ready code likh sakte ho

---

## 🚀 Next Steps

1. MAIN1.java run karo - Foundation clear ho jayega
2. MAIN2.java run karo - Real-world example samajh jayega
3. Documentation padho - Concepts deep samajh jayenge
4. Code modify karo - Apna practice karo

---

**Two Main Files = Perfect Learning Structure! 🎓**

*"Separate Main files = Better understanding! Clear concepts!"*

