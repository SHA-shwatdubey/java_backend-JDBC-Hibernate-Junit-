# Redis Caching Guide - Hinglish me Complete Explanation

## Redis Kya Hai? 🚀

**Redis** (Remote Dictionary Server) ek **in-memory data structure store** hai jo bahut **fast** hai. Ye ek key-value database hai jo data ko RAM me store karta hai, isliye bahut jaldi data retrieve ho jata hai.

### Redis Kyu Use Karte Hain?
1. **Speed** - RAM me data hota hai to milliseconds me response milta hai
2. **Performance** - Database calls kam hote hain, application fast hoti hai
3. **Scalability** - Jyada users handle kar sakte hain
4. **Cost Saving** - Database load kam hota hai

---

## Caching Kya Hoti Hai? 💾

**Caching** ek technique hai jisme frequently used data ko temporary storage (cache) me rakha jata hai. Jab same data dobara chahiye hota hai, to database se fetch karne ki jagah cache se le lete hain.

### Example:
```
Pehli baar: User -> API -> Database -> Product Data -> Cache me store -> User ko bhejo
Dusri baar: User -> API -> Cache se directly data le lo -> User ko bhejo (Database call nahi!)
```

### Caching ke Fayde:
- ⚡ **Fast Response** - Database query nahi, seedha memory se data
- 📉 **Database Load Kam** - Kam queries = better performance
- 💰 **Cost Efficient** - Database resources save hote hain
- 👥 **Better User Experience** - Quick response time

---

## Is Project Me Redis Kaise Use Ho Raha Hai? 🛠️

### 1. **Folder Structure Explanation**

```
cachepractice/
│
├── src/main/java/com/capgemini/cachepractice/
│   │
│   ├── CachepracticeApplication.java          # Main application class with @EnableCaching
│   │
│   ├── config/cache/
│   │   └── CacheConfiguration.java            # Redis cache configuration setup
│   │
│   ├── controller/
│   │   ├── ProductController.java             # REST API endpoints
│   │   └── RootController.java                # Home endpoint
│   │
│   ├── dto/
│   │   └── ProductDto.java                    # Data Transfer Object (API layer)
│   │
│   ├── entity/
│   │   └── Product.java                       # Entity class (domain model)
│   │
│   ├── exception/
│   │   ├── GlobalExceptionHandler.java        # Global exception handling
│   │   └── ProductNotFoundException.java      # Custom exception
│   │
│   ├── mapper/
│   │   └── ProductMapper.java                 # DTO ↔ Entity conversion
│   │
│   ├── repository/
│   │   └── InMemoryProductRepository.java     # In-memory data storage
│   │
│   ├── service/
│   │   ├── ProductService.java                # Service interface
│   │   ├── cache/
│   │   │   └── CacheNames.java                # Cache names constants
│   │   └── impl/
│   │       └── ProductServiceImpl.java        # Service implementation with caching
│   │
│   └── util/
│       └── IdGeneratorUtil.java               # ID generation utility
│
└── src/main/resources/
    └── application.properties                  # Application & Redis configuration
```

---

## Har Folder Ka Kaam 📂

### **1. config/cache/** - Cache Configuration
- **CacheConfiguration.java**: Redis cache ko configure karta hai
  - TTL (Time To Live): 10 minutes - uske baad cache expire ho jata hai
  - Serialization: Data ko JSON format me Redis me store karta hai
  - Connection: Redis server se connection setup

### **2. controller/** - REST API Endpoints
- **ProductController.java**: Product ke liye CRUD APIs
  - `POST /api/products` - Naya product create
  - `GET /api/products/{id}` - ID se product get
  - `GET /api/products` - Sare products get
  - `PUT /api/products/{id}` - Product update
  - `DELETE /api/products/{id}` - Product delete
- **RootController.java**: Home page endpoint (`/`)

### **3. dto/** - Data Transfer Objects
- **ProductDto.java**: API requests/responses me use hota hai
  - Client aur server ke beech data transfer ke liye

### **4. entity/** - Domain Models
- **Product.java**: Actual product entity/model
  - Business logic layer me use hota hai

### **5. exception/** - Error Handling
- **GlobalExceptionHandler.java**: Sare exceptions ko centrally handle karta hai
- **ProductNotFoundException.java**: Jab product nahi milta to ye exception throw hota hai

### **6. mapper/** - Object Conversion
- **ProductMapper.java**: DTO ko Entity me aur Entity ko DTO me convert karta hai

### **7. repository/** - Data Storage
- **InMemoryProductRepository.java**: Products ko memory me store karta hai
  - Real application me ye database hoga (MySQL, PostgreSQL, etc.)

### **8. service/** - Business Logic
- **ProductService.java**: Service interface
- **ProductServiceImpl.java**: Actual implementation with caching annotations
  - `@Cacheable`: Data cache me store karo aur future me wahi use karo
  - `@CachePut`: Cache update karo
  - `@CacheEvict`: Cache se data remove karo
- **cache/CacheNames.java**: Cache names define karta hai

### **9. util/** - Utility Classes
- **IdGeneratorUtil.java**: Unique IDs generate karta hai products ke liye

---

## Redis Caching Annotations Explained 🏷️

### 1. **@Cacheable** - Read Operation (GET)
```java
@Cacheable(value = CacheNames.PRODUCT_BY_ID, key = "#id")
public ProductDto getById(Long id) {
    // Pehli baar: Database se data fetch, Redis me store karo
    // Agli baar: Directly Redis se return karo
}
```
**Kya Hota Hai:**
- Pehli request me method execute hota hai aur result Redis me save hota hai
- Agli baar same ID ke liye Redis se directly data mil jata hai
- Method execute nahi hota!

### 2. **@CachePut** - Update Cache (CREATE/UPDATE)
```java
@CachePut(value = CacheNames.PRODUCT_BY_ID, key = "#result.id")
public ProductDto create(ProductDto productDto) {
    // New product create karo aur cache me bhi add karo
}
```
**Kya Hota Hai:**
- Method execute hota hai
- Result Redis cache me store/update ho jata hai
- Fresh data cache me rehta hai

### 3. **@CacheEvict** - Remove from Cache (DELETE)
```java
@CacheEvict(value = CacheNames.PRODUCT_BY_ID, key = "#id")
public void delete(Long id) {
    // Product delete karo aur cache se bhi remove karo
}
```
**Kya Hota Hai:**
- Cache se specified data remove ho jata hai
- Next request me fresh data fetch hoga

### 4. **@Caching** - Multiple Cache Operations
```java
@Caching(evict = {
    @CacheEvict(value = CacheNames.PRODUCT_BY_ID, key = "#id"),
    @CacheEvict(value = CacheNames.PRODUCT_LIST, allEntries = true)
})
public void delete(Long id) {
    // Multiple caches ko ek saath handle karo
}
```
**Kya Hota Hai:**
- Ek saath multiple cache operations execute hote hain

---

## Application Properties Explanation ⚙️

```properties
# Server Port
server.port=8084                                    # Application 8084 port pe chalegi

# Redis Configuration
spring.cache.type=redis                             # Redis caching use karenge
spring.cache.redis.time-to-live=600000              # 10 minutes TTL (600000 ms)
spring.cache.redis.cache-null-values=false          # Null values cache nahi hongi

# Redis Server Connection
spring.data.redis.host=localhost                    # Redis local machine pe hai
spring.data.redis.port=6379                         # Redis default port
spring.data.redis.timeout=60000                     # Connection timeout: 60 seconds

# Logging
logging.level.org.springframework.cache=TRACE       # Cache operations ka detailed log
logging.level.org.springframework.data.redis=DEBUG  # Redis operations ka log
```

---

## How to Run This Application 🚀

### Step 1: Redis Install Karo (Windows)

**Option 1: Docker Use Karo (Recommended)**
```powershell
# Redis container run karo
docker run --name redis-cache -p 6379:6379 -d redis

# Check karo running hai ya nahi
docker ps
```

**Option 2: Redis for Windows**
1. Download: https://github.com/microsoftarchive/redis/releases
2. Install karo aur Redis server start karo
3. Command: `redis-server.exe`

### Step 2: Check Redis Running Hai
```powershell
# Redis CLI open karo
redis-cli

# Redis me type karo
ping
# Response: PONG (agar running hai)
```

### Step 3: Application Run Karo
```powershell
# Maven dependencies install karo
mvn clean install

# Application start karo
mvn spring-boot:run

# Ya direct run karo
./mvnw spring-boot:run
```

---

## Testing the Application 🧪

### 1. Check Application Running
```
Browser me open karo: http://localhost:8084/
Response: {"message": "Cache Practice API is running", "productsApi": "/api/products"}
```

### 2. Create Product (Cache Me Add Hoga)
```bash
curl -X POST http://localhost:8084/api/products ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"Laptop\",\"price\":50000}"
```

### 3. Get Product by ID (Pehli Baar - Database Se)
```bash
curl http://localhost:8084/api/products/1
```
**Log Me Dikhega:** Cache miss - database query execute hui

### 4. Get Product by ID Again (Dusri Baar - Cache Se)
```bash
curl http://localhost:8084/api/products/1
```
**Log Me Dikhega:** Cache hit - Redis se directly data mila!

### 5. Check Redis Me Data Hai
```bash
redis-cli
KEYS *                          # Sare keys dekho
GET "PRODUCT_BY_ID::1"          # Product data dekho
```

### 6. Update Product (Cache Update Hoga)
```bash
curl -X PUT http://localhost:8084/api/products/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"Gaming Laptop\",\"price\":75000}"
```

### 7. Delete Product (Cache Se Remove Hoga)
```bash
curl -X DELETE http://localhost:8084/api/products/1
```

---

## Cache Flow - Visual Explanation 🔄

### **GET Request Flow (With Caching):**
```
1. User sends request: GET /api/products/1

2. Spring checks Redis cache:
   ┌─────────────────┐
   │ Cache me hai?   │
   └────────┬────────┘
            │
     ┌──────┴──────┐
     │             │
   YES            NO
     │             │
     ▼             ▼
   Return      Execute Method
   from Cache  ──> Query Database
     │             │
     │             ▼
     │         Store in Redis
     │             │
     └─────┬───────┘
           │
           ▼
   Return to User
```

### **POST/PUT Request Flow:**
```
1. User sends POST/PUT request

2. Execute method (Business Logic)
   ↓
3. Save to Database/Repository
   ↓
4. Update Redis Cache (@CachePut)
   ↓
5. Return response to User
```

### **DELETE Request Flow:**
```
1. User sends DELETE request

2. Execute method (Business Logic)
   ↓
3. Delete from Database/Repository
   ↓
4. Remove from Redis Cache (@CacheEvict)
   ↓
5. Return response to User
```

---

## Cache Eviction Strategies 🗑️

### **Time-Based Eviction (TTL)**
- **10 minutes** baad automatically cache expire ho jata hai
- Fresh data ensure hota hai
- Configured in: `application.properties`

### **Manual Eviction**
- **@CacheEvict** use karke manually remove karte hain
- Update/Delete operations me use hota hai

### **All Entries Eviction**
```java
@CacheEvict(value = CacheNames.PRODUCT_LIST, allEntries = true)
```
- Puri cache clear ho jati hai (jab list update hoti hai)

---

## Performance Benefits 📈

### Without Caching:
```
Request 1: 200ms (Database query)
Request 2: 200ms (Database query)
Request 3: 200ms (Database query)
Average: 200ms per request
```

### With Redis Caching:
```
Request 1: 200ms (Database query + Cache store)
Request 2: 2ms   (Cache hit - Redis)
Request 3: 2ms   (Cache hit - Redis)
Average: 68ms per request (3x faster!)
```

---

## Common Issues & Solutions 🔧

### 1. **Redis Connection Error**
**Problem:** Could not connect to Redis at localhost:6379
**Solution:** 
- Redis server start karo: `redis-server` ya `docker run -d -p 6379:6379 redis`

### 2. **Port Already in Use**
**Problem:** Port 8084 already in use
**Solution:** 
- `application.properties` me port change karo: `server.port=8085`

### 3. **Cache Not Working**
**Problem:** Data cache nahi ho raha
**Solution:**
- Check `@EnableCaching` annotation main class me hai ya nahi
- Redis running hai verify karo
- Logs check karo: `logging.level.org.springframework.cache=TRACE`

### 4. **Serialization Error**
**Problem:** Cannot serialize object
**Solution:**
- Ensure classes have default constructor (already done)
- JSON serialization use kar rahe hain (configured in CacheConfiguration)

---

## Best Practices ✅

1. **TTL Set Karo:** Cache ko expire hone ka time define karo (10 min is good)
2. **Cache Names Constants:** Hardcoded strings use mat karo, constants use karo (CacheNames class)
3. **Proper Eviction:** Update/Delete me cache clear karo
4. **Null Values:** Null values cache mat karo (configured)
5. **Monitoring:** Logs enable rakho development me
6. **Key Design:** Meaningful keys use karo: `PRODUCT_BY_ID::1`

---

## What's Next? 🎯

1. **Redis Cluster:** Production me Redis cluster setup karo
2. **Cache Monitoring:** Redis monitoring tools use karo (Redis Insight, RedisInsight)
3. **Advanced Patterns:** Cache-aside, Write-through patterns explore karo
4. **Cache Warming:** Application startup pe cache pre-load karo
5. **Distributed Caching:** Multiple instances ke saath cache sharing

---

## Summary - TL;DR 📝

✅ **Redis** = Fast in-memory cache  
✅ **@Cacheable** = Read operation me cache use  
✅ **@CachePut** = Cache update karo  
✅ **@CacheEvict** = Cache se remove karo  
✅ **TTL** = 10 minutes  
✅ **Port** = 8084  
✅ **Benefits** = 3-10x faster responses!  

---

## Questions? 🤔

Agar koi confusion hai to:
1. Logs check karo (TRACE level enable hai)
2. Redis me data dekho: `redis-cli` → `KEYS *`
3. Postman/curl se test karo
4. Performance compare karo (with vs without cache)

**Happy Caching! 🚀✨**

