# Quick Start Guide - Redis Setup

## Step 1: Redis Install Karo

### Option A: Docker Use Karo (Easiest)
```powershell
docker run --name redis-cache -p 6379:6379 -d redis
docker ps
```

### Option B: Redis for Windows
1. Download Redis: https://github.com/microsoftarchive/redis/releases/download/win-3.0.504/Redis-x64-3.0.504.msi
2. Install karo
3. Start Redis: `redis-server.exe`

### Option C: WSL2 me Redis
```bash
# WSL2 terminal me
sudo apt-get update
sudo apt-get install redis-server
sudo service redis-server start
redis-cli ping  # Should return PONG
```

## Step 2: Check Redis Running Hai
```powershell
redis-cli
ping
# Response: PONG
```

## Step 3: Application Build Karo
Make sure JAVA_HOME is set:
```powershell
# Check Java
java -version

# If needed, set JAVA_HOME
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"  # Apna Java path dalo
```

Then build:
```powershell
cd C:\Users\Shashwat\OneDrive\Desktop\SpringBoot\cachepractice
./mvnw.cmd clean install -DskipTests
```

## Step 4: Run Application
```powershell
./mvnw.cmd spring-boot:run
```

## Step 5: Test Karo
Open browser: http://localhost:8084/

---

## Already Built Hai? Direct Run Karo

```powershell
cd C:\Users\Shashwat\OneDrive\Desktop\SpringBoot\cachepractice

# Run karo
java -jar target\cachepractice-0.0.1-SNAPSHOT.jar
```

---

## API Test Karo (Postman ya curl)

### 1. Home Page
```
GET http://localhost:8084/
```

### 2. Create Product
```
POST http://localhost:8084/api/products
Content-Type: application/json

{
  "name": "Laptop",
  "price": 50000
}
```

### 3. Get Product (First time - DB query)
```
GET http://localhost:8084/api/products/1
```

### 4. Get Product Again (Second time - Redis cache hit!)
```
GET http://localhost:8084/api/products/1
```

### 5. Check Redis Me Data
```powershell
redis-cli
KEYS *
GET "PRODUCT_BY_ID::1"
```

---

## Agar 404 Error Aa Raha Hai

Ye normal hai! Root URL (/) pe hit karne par ye message aana chahiye:
```json
{
  "message": "Cache Practice API is running",
  "productsApi": "/api/products"
}
```

Agar ye aata hai to sab kuch theek hai! Static resources ki error ignore karo.

---

## Complete Details Ke Liye

`REDIS_CACHING_GUIDE.md` file check karo - usme EVERYTHING explain kiya hai!

