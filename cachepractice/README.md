# Cache Practice - Complete Guide (Hinglish) ??
## Project Kya Hai?
Ye ek **Spring Boot REST API** application hai jo **Redis Caching** ka use karke product management system implement karti hai. Is project me tumhe cache ki power dikhai degi - kaise data quickly fetch hota hai aur database load kam hota hai.
---
## Quick Links ??
- **REDIS_CACHING_GUIDE.md** - Redis ke baare me complete details
- **QUICK_START.md** - Application kaise setup aur run kare
---
## Setup Instructions ???
### Step 1: Redis Install
```powershell
# Docker (Recommended)
docker run --name redis-cache -p 6379:6379 -d redis
```
### Step 2: Run Application
```powershell
cd C:\Users\Shashwat\OneDrive\Desktop\SpringBoot\cachepractice
./mvnw.cmd spring-boot:run
```
### Step 3: Test
```
Browser: http://localhost:8084/
```
---
## Folder Structure Samjho ??
**config/cache/CacheConfiguration.java** - Redis setup (TTL: 10 min)
**controller/** - REST APIs aur error handling
**service/impl/ProductServiceImpl.java** - Caching logic (@Cacheable, @CachePut, @CacheEvict)
**repository/** - Data storage (in-memory)
---
## Caching Kaise Kaam Karta Hai? ??
### Pehli Request (Cache MISS)
```
GET /api/products/1 ? Database query ? Redis store ? Return (200ms)
```
### Dusri Request (Cache HIT)
```
GET /api/products/1 ? Redis return ? Response (2ms) ? 100x faster!
```
---
## Performance ??
| Request | Without Cache | With Redis | Improvement |
|---------|--------------|-----------|-------------|
| 1st | 200ms | 200ms | Same |
| 2nd-100th | 200ms each | 2ms each | **100x faster** |
---
## Complete Details
**REDIS_CACHING_GUIDE.md** me sab kuch detail me explain kiya hai!
**Happy Coding! ???**
