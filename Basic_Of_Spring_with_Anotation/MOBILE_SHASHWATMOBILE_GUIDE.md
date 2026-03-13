# 📱 Mobile & ShashwatMobile - Real-World Spring Example (HINDI)

## 🎯 Kya Hai?

Ye ek practical example hai jisme:
- **Mobile** - Smartphone ke details ke saath (@Component + @Value)
- **ShashwatMobile** - Mobile ke owner ki details (@Component + @Autowired + @Value)

Dono classes Spring annotations use karke interconnected hain!

---

## 📱 Mobile Class

### Kya Kaam Karta Hai?

Mobile class ek smartphone ko represent karta hai. Phone ke saare properties hain:

```java
@Component
public class Mobile {
    
    @Value("${mobile.phone.number:9555660256}")
    private String mobileNumber;
    
    @Value("${mobile.brand:Apple}")
    private String brand;
    
    @Value("${mobile.model:iPhone 14 Pro Max}")
    private String model;
    
    @Value("${mobile.storage:128GB}")
    private String storage;
    
    @Value("${mobile.color:Silver}")
    private String color;
    
    @Value("${mobile.ram:6}")
    private int ram;
    
    @Value("${mobile.price:99999}")
    private double price;
    
    @Value("${mobile.is5g:true}")
    private boolean is5g;
    
    @Value("${mobile.os:iOS}")
    private String os;
}
```

### @Value Examples:

#### 1️⃣ Hardcoded Default Value
```java
@Value("${mobile.brand:Apple}")
private String brand;
```
- Property file mein `mobile.brand` dhundta hai
- Nahi milta to `"Apple"` default use hota hai

#### 2️⃣ Direct Hardcoded Value
```java
@Value("9555660256")
private String mobileNumber;
```
- Directly ye value inject hota hai

#### 3️⃣ Type Conversion
```java
@Value("${mobile.ram:6}")
private int ram;  // String "6" automatically int mein convert

@Value("${mobile.price:99999}")
private double price;  // Automatic type conversion

@Value("${mobile.is5g:true}")
private boolean is5g;  // String "true" automatically boolean mein
```

### Mobile Properties:

| Property | Type | Default | Example |
|----------|------|---------|---------|
| mobileNumber | String | 9555660256 | Phone number |
| brand | String | Apple | Samsung, Xiaomi, etc. |
| model | String | iPhone 14 Pro Max | S23 Ultra, etc. |
| storage | String | 128GB | 256GB, 512GB, etc. |
| color | String | Silver | Black, White, etc. |
| ram | int | 6 | 8, 12, 16 GB |
| price | double | 99999 | Cost in Rupees |
| is5g | boolean | true | 5G support |
| os | String | iOS | Android, HarmonyOS |

---

## 👤 ShashwatMobile Class

### Kya Kaam Karta Hai?

ShashwatMobile class ek mobile aur uske owner ki complete information rakhta hai:

```java
@Component
public class ShashwatMobile {
    
    @Value("${owner.name:Shashwat}")
    private String ownerName;
    
    @Value("${owner.age:20}")
    private int ownerAge;
    
    @Value("${owner.city:India}")
    private String ownerCity;
    
    @Value("${owner.email:shashwat@example.com}")
    private String ownerEmail;
    
    @Value("${owner.phone:9555660256}")
    private String ownerPhone;
    
    @Autowired  // Dependency Injection
    private Mobile mobile;
    
    // Display methods
    public void displayCompleteInfo() {
        // Owner aur Mobile dono ki details dikhata hai
    }
}
```

### Annotations Used:

#### 1️⃣ @Component
```java
@Component
public class ShashwatMobile { }
```
- Spring automatically iska bean banega
- @ComponentScan se detect hoga

#### 2️⃣ @Value
```java
@Value("${owner.name:Shashwat}")
private String ownerName;
```
- Owner ki properties inject hoti hain
- Default values specified hain

#### 3️⃣ @Autowired (Important!)
```java
@Autowired
private Mobile mobile;
```
- Spring automatically Mobile bean inject karega
- Mobile aur ShashwatMobile interconnected ho jayenge
- Dependency Injection example!

### Properties:

| Property | Type | Default | Purpose |
|----------|------|---------|---------|
| ownerName | String | Shashwat | Owner ka naam |
| ownerAge | int | 20 | Owner ki age |
| ownerCity | String | India | Owner ki city |
| ownerEmail | String | shashwat@example.com | Email |
| ownerPhone | String | 9555660256 | Owner ka number |
| mobile | Mobile | null | Mobile object (Injected) |

---

## 🔗 Dependency Injection - How It Works?

### Traditional Way ❌
```java
public class ShashwatMobile {
    private Mobile mobile = new Mobile();  // Tight coupling
}
```

**Problems:**
- Hardcoded dependency
- Testing mein problem
- Flexibility nahi

### Spring Way ✅
```java
@Component
public class ShashwatMobile {
    
    @Autowired  // Spring automatically inject karega
    private Mobile mobile;
}
```

**Benefits:**
- Spring manage karta hai
- Testing easy
- Loose coupling
- Flexibility

### Kaise Kaam Karta Hai?

```
1. Spring Container start hota hai
   ↓
2. @ComponentScan "pom.capgemini" package scan karta hai
   ↓
3. Mobile.java detect hota hai → Mobile bean banta hai
   ↓
4. ShashwatMobile.java detect hota hai → ShashwatMobile bean banta hai
   ↓
5. ShashwatMobile mein @Autowired Mobile dikh raha hai
   ↓
6. Spring automatically Mobile bean inject karta hai
   ↓
7. ShashwatMobile.mobile ab Mobile object se linked hai!
```

---

## 🎯 Real-World Example

### Scenario
```
Shashwat ek Apple iPhone 14 Pro Max rakhta hai.
Phone ki sari details aur owner ki details ek saath manage karne hain.
```

### Code
```java
// Mobile bean - Phone ki details
@Component
public class Mobile {
    @Value("${mobile.brand:Apple}")
    private String brand;  // "Apple"
    
    @Value("${mobile.model:iPhone 14 Pro Max}")
    private String model;  // "iPhone 14 Pro Max"
}

// ShashwatMobile bean - Owner ki details
@Component
public class ShashwatMobile {
    @Value("${owner.name:Shashwat}")
    private String ownerName;  // "Shashwat"
    
    @Autowired
    private Mobile mobile;  // Mobile bean automatically inject
}

// Main.java - Usage
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        
        ShashwatMobile sm = ctx.getBean(ShashwatMobile.class);
        
        sm.displayCompleteInfo();
        // Output:
        // Name: Shashwat
        // Brand: Apple
        // Model: iPhone 14 Pro Max
        // ... aur saari details
    }
}
```

---

## 📊 Class Diagram

```
┌─────────────────────────────────┐
│      DemoConfiguration          │
│  @Configuration                 │
│  @ComponentScan                 │
└─────────────────────────────────┘
           ↓ scans
           
┌─────────────────────────────────┐
│         Mobile                  │
│  @Component + @Value            │
│                                 │
│  - mobileNumber                 │
│  - brand                        │
│  - model                        │
│  - storage                      │
│  - color                        │
│  - ram                          │
│  - price                        │
│  - is5g                         │
│  - os                           │
└─────────────────────────────────┘
           ↑ injected
           │ (Dependency Injection)
           │
┌─────────────────────────────────┐
│      ShashwatMobile             │
│  @Component + @Autowired + @Value│
│                                 │
│  - ownerName                    │
│  - ownerAge                     │
│  - ownerCity                    │
│  - ownerEmail                   │
│  - ownerPhone                   │
│  - mobile ← @Autowired          │
└─────────────────────────────────┘
```

---

## 🎓 Key Concepts

### 1️⃣ Bean Lifecycle
```
Spring starts
    ↓
Scans packages (ComponentScan)
    ↓
Finds @Component classes
    ↓
Creates beans
    ↓
Injects dependencies (@Autowired)
    ↓
Bean ready for use
```

### 2️⃣ @Autowired Kaise Kaam Karta Hai
```java
@Component
public class ShashwatMobile {
    
    @Autowired
    private Mobile mobile;  // Ye line dekh rahe hain
    
    // Spring automatically:
    // 1. Mobile class dhundta hai
    // 2. Dekhta hai ki @Component hai
    // 3. Mobile ka bean create karta hai (agar nahi bana)
    // 4. Mobile object ko ShashwatMobile.mobile mein set karta hai
}
```

### 3️⃣ @Value aur @Autowired ka Difference

| @Value | @Autowired |
|--------|-----------|
| Simple values/properties | Beans/Objects |
| `@Value("${prop:default}")` | `@Autowired private Bean b;` |
| Strings, int, boolean | Class objects |
| Property injection | Dependency injection |

---

## 🔥 Advantages

### 1. Code Reusability
```java
// Mobile class ko multiple owners ke liye use kar sakte ho
ShashwatMobile sm1 = ctx.getBean(ShashwatMobile.class);
// Aur kisi aur ke liye
// Owner change hota hai par Mobile bean same reh sakte hain
```

### 2. Easy Testing
```java
@Test
public void testShashwatMobile() {
    Mobile mockMobile = mock(Mobile.class);
    ShashwatMobile sm = new ShashwatMobile();
    sm.setMobile(mockMobile);  // Mock object set kar sakte ho
    // Testing easy!
}
```

### 3. Loose Coupling
```java
// Ye nahi likhna padta:
ShashwatMobile sm = new ShashwatMobile(new Mobile());  // Tight coupling

// Spring automatically handle karta hai:
@Autowired
private Mobile mobile;  // Loose coupling
```

### 4. Flexibility
```java
// Property file se values change kar sakte ho
// Recompile nahi karna padta
// Config ke through kaam complete hota hai
```

---

## 📝 Complete Example Flow

### Step 1: DemoConfiguration
```java
@Configuration
@ComponentScan(basePackages = "pom.capgemini")
public class DemoConfiguration {
    // Spring isko load karega
}
```

### Step 2: Mobile Bean Creation
```java
@Component
public class Mobile {
    @Value("${mobile.brand:Apple}")
    private String brand;
    // Spring: Mobile bean banega
}
```

### Step 3: ShashwatMobile Bean Creation
```java
@Component
public class ShashwatMobile {
    @Autowired
    private Mobile mobile;
    // Spring: ShashwatMobile bean banega
    // Mobile automatically inject hoga
}
```

### Step 4: Usage in Main
```java
ShashwatMobile sm = ioc.getBean(ShashwatMobile.class);
sm.displayCompleteInfo();
// Output: Owner aur Phone dono ki details
```

---

## 🎯 @Autowired Different Placement Options

### Option 1: Field Injection (Used in project)
```java
@Component
public class ShashwatMobile {
    
    @Autowired
    private Mobile mobile;  // Field pe lagaya
}
```

### Option 2: Constructor Injection (Recommended)
```java
@Component
public class ShashwatMobile {
    
    private Mobile mobile;
    
    @Autowired
    public ShashwatMobile(Mobile mobile) {  // Constructor pe
        this.mobile = mobile;
    }
}
```

### Option 3: Setter Injection
```java
@Component
public class ShashwatMobile {
    
    private Mobile mobile;
    
    @Autowired
    public void setMobile(Mobile mobile) {  // Setter pe
        this.mobile = mobile;
    }
}
```

---

## 🚀 How to Run

### Step 1: Create property file (Optional)
```
src/main/resources/application.properties
```

Content:
```properties
mobile.brand=Apple
mobile.model=iPhone 14 Pro Max
mobile.storage=128GB
mobile.color=Silver
mobile.ram=6
mobile.price=99999
mobile.is5g=true
mobile.os=iOS

owner.name=Shashwat
owner.age=20
owner.city=India
owner.email=shashwat@example.com
owner.phone=9555660256
```

### Step 2: Run Main.java
```bash
javac -cp "spring-jars/*" src/main/java/pom/capgemini/*.java
java -cp "spring-jars/*:." pom.capgemini.Main
```

### Step 3: Output
```
✓ Mobile object created by Spring!
✓ ShashwatMobile object created by Spring!

--- OWNER DETAILS ---
Name: Shashwat
Age: 20
City: India
Email: shashwat@example.com
Phone: 9555660256

--- MOBILE DETAILS ---
Brand: Apple
Model: iPhone 14 Pro Max
Storage: 128GB
Color: Silver
RAM: 6 GB
Price: ₹99999
OS: iOS
5G: Yes
```

---

## 🎉 Summary

| Concept | Mobile | ShashwatMobile |
|---------|--------|----------------|
| **Annotation** | @Component + @Value | @Component + @Autowired + @Value |
| **Purpose** | Phone details | Owner + Phone details |
| **Values** | Brand, Model, Price, etc. | Owner name, age, city, etc. |
| **Dependency** | None | Mobile (via @Autowired) |
| **Real-world** | Smartphone specifications | User with their phone |

---

**Mobile aur ShashwatMobile ek practical example hai Spring dependency injection ka! 🚀**

*"When objects need each other, Spring helps them find each other!" - Every Spring Developer*

