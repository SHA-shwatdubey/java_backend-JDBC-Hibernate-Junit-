<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details - Springmvcboot</title>
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

            <div class="details-container">
                <div class="details-card">
                    <div class="detail-group">
                        <label>Product ID:</label>
                        <span>${productId}</span>
                    </div>
                    <div class="detail-group">
                        <label>Product Name:</label>
                        <span>Sample Product</span>
                    </div>
                    <div class="detail-group">
                        <label>Price:</label>
                        <span>$0.00</span>
                    </div>
                    <div class="detail-group">
                        <label>Quantity:</label>
                        <span>0</span>
                    </div>
                </div>

                <div class="action-buttons">
                    <a href="<c:url value='/products/edit/${productId}' />" class="btn btn-warning">Edit</a>
                    <a href="<c:url value='/products/delete/${productId}' />" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                    <a href="<c:url value='/products' />" class="btn btn-secondary">Back to List</a>
                </div>
            </div>
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

