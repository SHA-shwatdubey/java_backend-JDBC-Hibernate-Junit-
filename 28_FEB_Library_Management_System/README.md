# 📚 Library Management System - Spring Boot REST API

## 📋 Project Overview

Yeh ek **Library Management System** ka backend API hai jo **Spring Boot** se bana hai. Is system se ek librarian books, authors, categories, library branches, members ko manage kar sakta hai aur books issue/return kar sakta hai. Saari loan history permanently store hoti hai reporting aur auditing ke liye.

---

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| **Spring Boot 3.2.5** | REST API Framework |
| **Spring Data JPA** | DAO / Repository Layer |
| **Hibernate / JPA** | ORM - Entity Relationships & Mappings |
| **PostgreSQL 18** | Database |
| **Lombok** | Boilerplate code reduce karne ke liye |
| **Springdoc OpenAPI 2.3.0** | Swagger UI Documentation |
| **Maven** | Build Tool |
| **Java 21** | Programming Language |

---

## 📁 Project Structure

```
com.capgemini.library/
├── LibraryManagementApplication.java       → Main Spring Boot Application
├── config/
│   └── SwaggerConfig.java                  → Swagger/OpenAPI Configuration
├── entity/
│   ├── Book.java                           → Book Entity
│   ├── Author.java                         → Author Entity
│   ├── Category.java                       → Category Entity
│   ├── LibraryBranch.java                  → Library Branch Entity
│   ├── Member.java                         → Member Entity
│   └── Loan.java                           → Loan (Borrow Record) Entity
├── repository/
│   ├── BookRepository.java                 → Book DAO
│   ├── AuthorRepository.java               → Author DAO
│   ├── CategoryRepository.java             → Category DAO
│   ├── LibraryBranchRepository.java        → Branch DAO
│   ├── MemberRepository.java               → Member DAO
│   └── LoanRepository.java                 → Loan DAO (+ findByMemberMemberId)
├── service/
│   ├── BookService.java                    → Book Business Logic
│   ├── AuthorService.java                  → Author Business Logic
│   ├── CategoryService.java                → Category Business Logic
│   ├── BranchService.java                  → Branch Business Logic
│   ├── MemberService.java                  → Member Business Logic
│   └── LoanService.java                    → Loan Issue/Return Business Logic
├── controller/
│   ├── BookController.java                 → /api/v1/books
│   ├── AuthorController.java               → /api/v1/authors
│   ├── CategoryController.java             → /api/v1/categories
│   ├── BranchController.java               → /api/v1/branches
│   ├── MemberController.java               → /api/v1/members
│   └── LoanController.java                 → /api/v1/loans
└── exception/
    ├── ResourceNotFoundException.java      → Custom 404 Exception
    └── GlobalExceptionHandler.java         → Global Error Handler
```

---

## 🗃️ Entities & Fields

### 1. Book
| Field | Type | Description |
|---|---|---|
| bookId | Long (PK) | Auto-generated primary key |
| title | String | Book ka title |
| isbn | String (unique) | International Standard Book Number |
| publishYear | int | Publish hone ka year |
| copiesTotal | int | Total kitni copies hain |
| copiesAvailable | int | Kitni copies available hain abhi |
| status | String | ACTIVE / INACTIVE |

### 2. Author
| Field | Type | Description |
|---|---|---|
| authorId | Long (PK) | Auto-generated primary key |
| name | String | Author ka naam |
| biography | String | Author ke baare me (optional) |

### 3. Category
| Field | Type | Description |
|---|---|---|
| categoryId | Long (PK) | Auto-generated primary key |
| name | String | Category ka naam |
| description | String | Category ki description (optional) |

### 4. LibraryBranch
| Field | Type | Description |
|---|---|---|
| branchId | Long (PK) | Auto-generated primary key |
| name | String | Branch ka naam |
| location | String | Branch ki location |
| contactNumber | String | Contact number (optional) |

### 5. Member
| Field | Type | Description |
|---|---|---|
| memberId | Long (PK) | Auto-generated primary key |
| name | String | Member ka naam |
| email | String | Email address |
| phone | String | Phone number |
| memberSince | LocalDate | Kab se member hai |
| status | String | ACTIVE / BLOCKED |

### 6. Loan
| Field | Type | Description |
|---|---|---|
| loanId | Long (PK) | Auto-generated primary key |
| issueDate | LocalDate | Book issue hone ki date |
| dueDate | LocalDate | Return karne ki last date |
| returnDate | LocalDate | Actually kab return ki (null until returned) |
| loanStatus | String | ISSUED / RETURNED / LATE |

---

## 🔗 Entity Relationships (JPA Mappings)

```
Book  ←→  Author        : Many-to-Many  (Join Table: book_author)
Book   →  Category       : Many-to-One
Book   →  LibraryBranch  : Many-to-One
Book  ←→  Loan           : One-to-Many
Member ←→ Loan           : One-to-Many
Loan   →  Book           : Many-to-One
Loan   →  Member         : Many-to-One
```

---

## ⚙️ Configuration

**File:** `src/main/resources/application.properties`

| Property | Value |
|---|---|
| Server Port | `8091` |
| Database URL | `jdbc:postgresql://localhost:5432/library_db` |
| DB Username | `postgres` |
| DB Password | `root` |
| DDL Auto | `update` (tables automatically banti hain) |
| Swagger UI | `http://localhost:8091/swagger-ui.html` |

---

## 🚀 Project Kaise Run Karna Hai

### Step 1: PostgreSQL Database Banao

Database `library_db` pehle se bana hua hai. Agar nahi bana hai toh:

```sql
CREATE DATABASE library_db;
```

### Step 2: Maven Dependencies Download Karo

IntelliJ me:
- `pom.xml` pe **Right Click** → **Maven** → **Reload Project**

### Step 3: Application Run Karo

- `LibraryManagementApplication.java` file kholke **Run** button dabao
- Ya terminal me:
```bash
mvn spring-boot:run
```

### Step 4: Swagger UI Open Karo

Browser me jao:
```
http://localhost:8091/swagger-ui.html
```

Yahan se saare endpoints test kar sakte ho directly.

---

## 📡 API Endpoints

### Category Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/categories` | Nayi category banao |
| GET | `/api/v1/categories` | Saari categories dekho |
| GET | `/api/v1/categories/{id}` | Ek category dekho by ID |
| PUT | `/api/v1/categories/{id}` | Category update karo |
| DELETE | `/api/v1/categories/{id}` | Category delete karo |

### Author Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/authors` | Naya author banao |
| GET | `/api/v1/authors` | Saare authors dekho |
| GET | `/api/v1/authors/{id}` | Ek author dekho by ID |
| PUT | `/api/v1/authors/{id}` | Author update karo |
| DELETE | `/api/v1/authors/{id}` | Author delete karo |

### Branch Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/branches` | Nayi branch banao |
| GET | `/api/v1/branches` | Saari branches dekho |
| GET | `/api/v1/branches/{id}` | Ek branch dekho by ID |
| PUT | `/api/v1/branches/{id}` | Branch update karo |
| DELETE | `/api/v1/branches/{id}` | Branch delete karo |

### Book Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/books?categoryId=1&branchId=1&authorIds=1,2` | Nayi book banao (category, branch, authors attach karo) |
| GET | `/api/v1/books` | Saari books dekho |
| GET | `/api/v1/books/{id}` | Ek book dekho by ID |
| PUT | `/api/v1/books/{id}` | Book update karo |
| DELETE | `/api/v1/books/{id}` | Book disable karo (INACTIVE) |

### Member Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/members` | Naya member banao |
| GET | `/api/v1/members` | Saare members dekho |
| GET | `/api/v1/members/{id}` | Ek member dekho by ID |
| PUT | `/api/v1/members/{id}` | Member update karo |
| DELETE | `/api/v1/members/{id}` | Member block karo (BLOCKED) |
| GET | `/api/v1/members/{memberId}/loans` | Member ki loan history dekho |

### Loan Endpoints
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1/loans/issue?memberId=1&bookId=1&dueDate=2026-03-15` | Book issue karo (loan create + copiesAvailable -1) |
| PUT | `/api/v1/loans/{loanId}/return` | Book return karo (loan update + copiesAvailable +1) |
| GET | `/api/v1/loans/{loanId}` | Ek loan dekho by ID |
| GET | `/api/v1/loans` | Saare loans dekho |

---

## 📖 Business Rules

1. **Book Issue:** Book tabhi issue hogi jab `copiesAvailable > 0` ho. Issue hone pe `copiesAvailable` 1 se kam ho jayega aur ek `Loan` record banega status `ISSUED` ke saath.

2. **Book Return:** Return karne pe `copiesAvailable` 1 se badh jayega. Agar `returnDate` `dueDate` ke baad hai toh loan status `LATE` hoga, warna `RETURNED`.

3. **Loan History:** Loan records delete nahi hote — permanently stored rehte hain audit aur reporting ke liye.

4. **Soft Delete:** Books aur Members delete nahi hote, unka status `INACTIVE` / `BLOCKED` ho jaata hai.

---

## 🧪 Testing Kaise Karo (Swagger se)

### Step 1: Pehle Category Banao
```json
POST /api/v1/categories
{
    "name": "Science Fiction",
    "description": "Sci-fi books"
}
```

### Step 2: Author Banao
```json
POST /api/v1/authors
{
    "name": "Isaac Asimov",
    "biography": "Famous sci-fi writer"
}
```

### Step 3: Branch Banao
```json
POST /api/v1/branches
{
    "name": "Central Library",
    "location": "Delhi",
    "contactNumber": "9876543210"
}
```

### Step 4: Book Banao (Category, Branch, Author attach karo)
```
POST /api/v1/books?categoryId=1&branchId=1&authorIds=1
```
```json
{
    "title": "Foundation",
    "isbn": "978-0553293357",
    "publishYear": 1951,
    "copiesTotal": 5,
    "copiesAvailable": 5
}
```

### Step 5: Member Banao
```json
POST /api/v1/members
{
    "name": "Shashwat",
    "email": "shashwat@email.com",
    "phone": "9999999999",
    "memberSince": "2026-02-28"
}
```

### Step 6: Book Issue Karo
```
POST /api/v1/loans/issue?memberId=1&bookId=1&dueDate=2026-03-15
```

### Step 7: Book Return Karo
```
PUT /api/v1/loans/1/return
```

---

## 🗄️ Database Tables (Auto-Created by Hibernate)

| Table Name | Description |
|---|---|
| `books` | Books ki details |
| `authors` | Authors ki details |
| `categories` | Categories ki details |
| `library_branches` | Branch locations |
| `members` | Library members |
| `loans` | Borrow/return records |
| `book_author` | Book-Author many-to-many join table |

---

## ❗ Error Handling

| Exception | HTTP Status | When |
|---|---|---|
| `ResourceNotFoundException` | 404 Not Found | Jab entity ID se nahi milti |
| `RuntimeException` | 400 Bad Request | Jab business rule fail hoti hai (e.g., no copies available) |

---

## 👨‍💻 Author

**Shashwat** — Capgemini Spring Boot Project

