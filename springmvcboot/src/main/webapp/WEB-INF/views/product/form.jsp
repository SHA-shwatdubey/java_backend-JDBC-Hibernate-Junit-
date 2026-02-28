<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle} - Springmvcboot</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <!-- Header & Navigation -->
    <header>
        <nav class="navbar">
            <div class="container">
                <div class="navbar-header">
                    <h1 class="navbar-brand">Springmvcboot</h1>
                </div>
                <ul class="navbar-menu">
                    <li><a href="<c:url value='/' />">Home</a></li>
                    <li><a href="<c:url value='/users' />">Users</a></li>
                    <li><a href="<c:url value='/products' />">Products</a></li>
                    <li><a href="<c:url value='/about' />">About</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- Main Content -->
    <main>
        <div class="container">
            <h2>${pageTitle}</h2>

            <form method="POST" action="<c:url value='/products' />" class="form-container">
                <c:if test="${productId != null}">
                    <input type="hidden" name="id" value="${productId}">
                </c:if>

                <div class="form-group">
                    <label for="productName">Product Name *</label>
                    <input type="text" id="productName" name="productName" required>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="price">Price *</label>
                    <input type="number" id="price" name="price" step="0.01" required>
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="number" id="quantity" name="quantity">
                </div>

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Save Product</button>
                    <a href="<c:url value='/products' />" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <div class="container">
            <p>&copy; 2026 Capgemini. All rights reserved.</p>
        </div>
    </footer>

    <script src="<c:url value='/resources/js/main.js' />"></script>
</body>
</html>

