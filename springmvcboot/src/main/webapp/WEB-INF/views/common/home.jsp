<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Springmvcboot</title>
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

            <section class="welcome-section">
                <h3>Welcome to Home Page</h3>
                <p>This is the home page of our Spring Boot MVC application built with traditional architecture.</p>

                <div class="content-section">
                    <h4>Quick Links</h4>
                    <ul>
                        <li><a href="<c:url value='/users' />">Manage Users</a> - View, Add, Edit, Delete Users</li>
                        <li><a href="<c:url value='/products' />">Manage Products</a> - View, Add, Edit, Delete Products</li>
                        <li><a href="<c:url value='/about' />">About Application</a> - Learn more about this app</li>
                    </ul>
                </div>

                <div class="info-box">
                    <h4>📌 Features</h4>
                    <ul>
                        <li>Traditional Spring MVC with JSP views</li>
                        <li>WEB-INF folder structure for views</li>
                        <li>Service layer for business logic</li>
                        <li>Repository layer for database access</li>
                        <li>DTO for data transfer</li>
                        <li>Global exception handling</li>
                        <li>Responsive design with CSS</li>
                    </ul>
                </div>
            </section>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <div class="container">
            <p>&copy; 2026 Capgemini. All rights reserved.</p>
            <p>Spring Boot Version: 3.5.11 | Java Version: 21</p>
        </div>
    </footer>

    <script src="<c:url value='/resources/js/main.js' />"></script>
</body>
</html>

