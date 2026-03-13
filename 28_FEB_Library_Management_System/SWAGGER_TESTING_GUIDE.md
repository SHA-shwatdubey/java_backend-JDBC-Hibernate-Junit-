# 🧪 Swagger UI - Complete Testing Guide

## 📌 Swagger UI Kaise Open Karo

1. Pehle **application run karo** (IntelliJ me `LibraryManagementApplication.java` → Run)
2. Browser me jao:

```
http://localhost:8091/swagger-ui.html
```

3. Page khulega jisme saare controllers dikhenge:
   - `author-controller`
   - `book-controller`
   - `branch-controller`
   - `category-controller`
   - `loan-controller`
   - `member-controller`

4. Kisi bhi controller pe click karo → saare endpoints expand ho jayenge
5. Kisi bhi endpoint pe click karo → **"Try it out"** button dabao → data bharo → **"Execute"** dabao

---

## ⚠️ IMPORTANT: Data Insert Karne Ka Order

Ye order follow karna **ZAROORI** hai kyunki entities ek dusre se linked hain:

```
Step 1: Category banao        (Book ke liye chahiye)
Step 2: Author banao           (Book ke liye chahiye)
Step 3: Branch banao           (Book ke liye chahiye)
Step 4: Book banao             (Category + Branch + Author chahiye pehle)
Step 5: Member banao           (Loan ke liye chahiye)
Step 6: Book Issue karo (Loan) (Book + Member chahiye pehle)
Step 7: Book Return karo       (Loan chahiye pehle)
```

Agar order galat kiya toh **404 error** aayega kyunki related entity milegi nahi.

---

## 📝 Step-by-Step Swagger Testing (Screenshots jaise samjho)

---

### ✅ STEP 1: Category Banao

**Swagger me jao →** `category-controller` expand karo **→** `POST /api/v1/categories` pe click karo **→** `Try it out` dabao

**Request Body me ye paste karo:**

```json
{
    "name": "Science Fiction",
    "description": "Science fiction genre ki books"
}
```

**Execute dabao.** Response me `201 Created` aayega:

```json
{
    "categoryId": 1,
    "name": "Science Fiction",
    "description": "Science fiction genre ki books",
    "books": null
}
```

**Ek aur category banao:**

```json
{
    "name": "History",
    "description": "Historical books collection"
}
```

> 💡 **Note:** `categoryId` automatically generate hota hai, tum mat dena body me.

---

### ✅ STEP 2: Author Banao

**Swagger me →** `author-controller` **→** `POST /api/v1/authors` **→** `Try it out`

**Request Body:**

```json
{
    "name": "Isaac Asimov",
    "biography": "American writer and professor, famous for science fiction"
}
```

**Execute dabao.** Response `201 Created`:

```json
{
    "authorId": 1,
    "name": "Isaac Asimov",
    "biography": "American writer and professor, famous for science fiction",
    "books": null
}
```

**Ek aur author banao:**

```json
{
    "name": "Arthur C. Clarke",
    "biography": "British science fiction writer"
}
```

---

### ✅ STEP 3: Library Branch Banao

**Swagger me →** `branch-controller` **→** `POST /api/v1/branches` **→** `Try it out`

**Request Body:**

```json
{
    "name": "Central Library",
    "location": "Connaught Place, Delhi",
    "contactNumber": "011-23456789"
}
```

**Response `201 Created`:**

```json
{
    "branchId": 1,
    "name": "Central Library",
    "location": "Connaught Place, Delhi",
    "contactNumber": "011-23456789",
    "books": null
}
```

**Ek aur branch banao:**

```json
{
    "name": "South Branch Library",
    "location": "Saket, Delhi",
    "contactNumber": "011-98765432"
}
```

---

### ✅ STEP 4: Book Banao (⭐ Sabse Important Step)

**Swagger me →** `book-controller` **→** `POST /api/v1/books` **→** `Try it out`

> ⚠️ **Dhyan do:** Book create karte waqt **3 query parameters** bhi dene hain — `categoryId`, `branchId`, `authorIds`

**Parameters fill karo (Swagger me alag alag fields honge):**

| Parameter | Value | Meaning |
|---|---|---|
| categoryId | `1` | Science Fiction category (Step 1 me banaya tha) |
| branchId | `1` | Central Library branch (Step 3 me banaya tha) |
| authorIds | `1` | Isaac Asimov author (Step 2 me banaya tha) |

> 💡 Multiple authors attach karne hain toh: `authorIds` = `1,2` (comma separated)

**Request Body:**

```json
{
    "title": "Foundation",
    "isbn": "978-0553293357",
    "publishYear": 1951,
    "copiesTotal": 5,
    "copiesAvailable": 5
}
```

**Execute dabao.** Response `201 Created`:

```json
{
    "bookId": 1,
    "title": "Foundation",
    "isbn": "978-0553293357",
    "publishYear": 1951,
    "copiesTotal": 5,
    "copiesAvailable": 5,
    "status": "ACTIVE",
    "authors": [
        {
            "authorId": 1,
            "name": "Isaac Asimov",
            "biography": "American writer and professor, famous for science fiction"
        }
    ],
    "category": {
        "categoryId": 1,
        "name": "Science Fiction",
        "description": "Science fiction genre ki books"
    },
    "branch": {
        "branchId": 1,
        "name": "Central Library",
        "location": "Connaught Place, Delhi",
        "contactNumber": "011-23456789"
    },
    "loans": null
}
```

**Ek aur book banao (2 authors ke saath):**

Parameters: `categoryId=1`, `branchId=1`, `authorIds=1,2`

```json
{
    "title": "2001: A Space Odyssey",
    "isbn": "978-0451457998",
    "publishYear": 1968,
    "copiesTotal": 3,
    "copiesAvailable": 3
}
```

---

### ✅ STEP 5: Member Banao

**Swagger me →** `member-controller` **→** `POST /api/v1/members` **→** `Try it out`

**Request Body:**

```json
{
    "name": "Shashwat Kumar",
    "email": "shashwat@gmail.com",
    "phone": "9876543210",
    "memberSince": "2026-02-28"
}
```

**Response `201 Created`:**

```json
{
    "memberId": 1,
    "name": "Shashwat Kumar",
    "email": "shashwat@gmail.com",
    "phone": "9876543210",
    "memberSince": "2026-02-28",
    "status": "ACTIVE",
    "loans": null
}
```

> 💡 **Note:** `status` automatically `ACTIVE` set hota hai.

**Ek aur member banao:**

```json
{
    "name": "Rahul Sharma",
    "email": "rahul@gmail.com",
    "phone": "9123456789",
    "memberSince": "2026-01-15"
}
```

---

### ✅ STEP 6: Book Issue Karo (Loan Create) ⭐

**Swagger me →** `loan-controller` **→** `POST /api/v1/loans/issue` **→** `Try it out`

**Parameters fill karo:**

| Parameter | Value | Meaning |
|---|---|---|
| memberId | `1` | Shashwat Kumar (Step 5 me banaya) |
| bookId | `1` | Foundation book (Step 4 me banaya) |
| dueDate | `2026-03-15` | 15 March tak return karna hai |

> ⚠️ **Body me kuch mat dena, sirf parameters fill karo!**

**Execute dabao.** Response `201 Created`:

```json
{
    "loanId": 1,
    "issueDate": "2026-02-28",
    "dueDate": "2026-03-15",
    "returnDate": null,
    "loanStatus": "ISSUED",
    "member": {
        "memberId": 1,
        "name": "Shashwat Kumar",
        "email": "shashwat@gmail.com",
        "phone": "9876543210",
        "memberSince": "2026-02-28",
        "status": "ACTIVE"
    },
    "book": {
        "bookId": 1,
        "title": "Foundation",
        "isbn": "978-0553293357",
        "publishYear": 1951,
        "copiesTotal": 5,
        "copiesAvailable": 4,
        "status": "ACTIVE"
    }
}
```

> 🔍 **Dekho:** `copiesAvailable` **5 se 4** ho gaya! Aur `loanStatus` = `ISSUED`

**Ek aur book issue karo — dusre member ko:**

| Parameter | Value |
|---|---|
| memberId | `2` |
| bookId | `1` |
| dueDate | `2026-03-10` |

> Ab `copiesAvailable` **4 se 3** ho jayega.

---

### ✅ STEP 7: Book Return Karo ⭐

**Swagger me →** `loan-controller` **→** `PUT /api/v1/loans/{loanId}/return` **→** `Try it out`

**Parameter:**

| Parameter | Value | Meaning |
|---|---|---|
| loanId | `1` | Pehla loan (Step 6 me banaya) |

> ⚠️ **Body me kuch mat dena, sirf loanId path me dalo!**

**Execute dabao.** Response `200 OK`:

```json
{
    "loanId": 1,
    "issueDate": "2026-02-28",
    "dueDate": "2026-03-15",
    "returnDate": "2026-02-28",
    "loanStatus": "RETURNED",
    "member": {
        "memberId": 1,
        "name": "Shashwat Kumar"
    },
    "book": {
        "bookId": 1,
        "title": "Foundation",
        "copiesAvailable": 4
    }
}
```

> 🔍 **Dekho:**
> - `returnDate` set ho gaya → `2026-02-28`
> - `loanStatus` = `RETURNED` (kyunki time pe return kiya)
> - `copiesAvailable` **3 se wapas 4** ho gaya!

> 💡 Agar `returnDate` `dueDate` ke baad hoti toh `loanStatus` = `LATE` hota.

---

## 📖 GET Endpoints — Data Kaise Dekho

### Saari Books Dekho
**→** `book-controller` **→** `GET /api/v1/books` **→** `Try it out` **→** `Execute`

### Ek Book Dekho by ID
**→** `GET /api/v1/books/{id}` **→** id = `1` **→** `Execute`

### Saare Members Dekho
**→** `member-controller` **→** `GET /api/v1/members` **→** `Execute`

### Saare Loans Dekho
**→** `loan-controller` **→** `GET /api/v1/loans` **→** `Execute`

### Kisi Member Ki Loan History Dekho
**→** `member-controller` **→** `GET /api/v1/members/{memberId}/loans` **→** memberId = `1` **→** `Execute`

Ye us member ke saare past loans return karega.

---

## ✏️ UPDATE Endpoints — Data Kaise Update Karo

### Category Update Karo
**→** `category-controller` **→** `PUT /api/v1/categories/{id}` **→** id = `1`

```json
{
    "name": "Sci-Fi",
    "description": "Updated science fiction description"
}
```

### Book Update Karo
**→** `book-controller` **→** `PUT /api/v1/books/{id}` **→** id = `1`

```json
{
    "title": "Foundation (Updated Edition)",
    "isbn": "978-0553293357",
    "publishYear": 1951,
    "copiesTotal": 10,
    "copiesAvailable": 8,
    "status": "ACTIVE"
}
```

### Member Update Karo
**→** `member-controller` **→** `PUT /api/v1/members/{id}` **→** id = `1`

```json
{
    "name": "Shashwat Kumar",
    "email": "shashwat.new@gmail.com",
    "phone": "8888888888",
    "memberSince": "2026-02-28",
    "status": "ACTIVE"
}
```

---

## 🗑️ DELETE Endpoints — Data Kaise Delete/Disable Karo

### Category Delete Karo (Hard Delete)
**→** `DELETE /api/v1/categories/{id}` **→** id = `2` **→** `Execute`

Response: `204 No Content` (delete ho gaya)

### Author Delete Karo (Hard Delete)
**→** `DELETE /api/v1/authors/{id}` **→** id = `2` **→** `Execute`

### Branch Delete Karo (Hard Delete)
**→** `DELETE /api/v1/branches/{id}` **→** id = `2` **→** `Execute`

### Book Delete Karo (Soft Delete → INACTIVE)
**→** `DELETE /api/v1/books/{id}` **→** id = `1` **→** `Execute`

> 💡 Book actually delete nahi hogi, sirf `status` = `INACTIVE` ho jayega.

### Member Delete Karo (Soft Delete → BLOCKED)
**→** `DELETE /api/v1/members/{id}` **→** id = `1` **→** `Execute`

> 💡 Member actually delete nahi hoga, sirf `status` = `BLOCKED` ho jayega.

---

## ❌ Error Cases — Ye Galtiyan Try Karo Samajhne Ke Liye

### 1. Book Issue Karo Bina Member Banaye
```
POST /api/v1/loans/issue?memberId=999&bookId=1&dueDate=2026-03-15
```
**Response: `404 Not Found`**
```json
{
    "status": 404,
    "error": "Not Found",
    "message": "Member not found with id: 999"
}
```

### 2. Book Issue Karo Jab Copies 0 Ho
Pehle ek book banao jisme `copiesAvailable = 0`:
```json
{
    "title": "Rare Book",
    "isbn": "000-0000000000",
    "publishYear": 2000,
    "copiesTotal": 0,
    "copiesAvailable": 0
}
```
Fir issue karo:
```
POST /api/v1/loans/issue?memberId=1&bookId=3&dueDate=2026-03-15
```
**Response: `400 Bad Request`**
```json
{
    "status": 400,
    "error": "Bad Request",
    "message": "No available copies for book: Rare Book"
}
```

### 3. Already Return Ki Hui Book Dobara Return Karo
```
PUT /api/v1/loans/1/return
```
(Jo pehle se return ho chuki hai)

**Response: `400 Bad Request`**
```json
{
    "status": 400,
    "error": "Bad Request",
    "message": "Book already returned for loan id: 1"
}
```

### 4. Galat ID Se Kuch Bhi Fetch Karo
```
GET /api/v1/books/999
```
**Response: `404 Not Found`**
```json
{
    "status": 404,
    "error": "Not Found",
    "message": "Book not found with id: 999"
}
```

---

## 🔄 Complete Flow — Ek Poora Cycle

```
1. POST /api/v1/categories          → Category banao (id=1)
2. POST /api/v1/authors             → Author banao (id=1)
3. POST /api/v1/branches            → Branch banao (id=1)
4. POST /api/v1/books?categoryId=1&branchId=1&authorIds=1  → Book banao (id=1, copies=5)
5. POST /api/v1/members             → Member banao (id=1)
6. POST /api/v1/loans/issue?memberId=1&bookId=1&dueDate=2026-03-15  → Book issue (copies 5→4)
7. GET  /api/v1/books/1             → Check: copiesAvailable = 4
8. GET  /api/v1/loans/1             → Check: loanStatus = ISSUED
9. PUT  /api/v1/loans/1/return      → Book return (copies 4→5)
10. GET /api/v1/books/1             → Check: copiesAvailable = 5
11. GET /api/v1/loans/1             → Check: loanStatus = RETURNED, returnDate set
12. GET /api/v1/members/1/loans     → Member ki poori loan history
```

---

## 💡 Swagger Tips

1. **Try it out** button dabane ke baad hi fields editable hoti hain
2. **Execute** dabane ke baad neeche scroll karo response dekhne ke liye
3. **Response Code** dekho:
   - `200` = Success (GET/PUT)
   - `201` = Created (POST)
   - `204` = Deleted (DELETE)
   - `400` = Bad Request (business rule fail)
   - `404` = Not Found (wrong ID)
4. **Curl command** bhi dikhta hai har execute ke baad — Postman me paste kar sakte ho
5. Agar koi field optional hai toh usko body se hata do, error nahi aayega

