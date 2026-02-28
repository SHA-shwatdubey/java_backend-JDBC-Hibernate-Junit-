<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Springmvcboot - Home</title>
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
            <h2>${title}</h2>
            <p>${message}</p>

            <section class="hero-section">
                <h3>Welcome to Spring Boot MVC Application</h3>
                <p>This is a traditional Spring MVC application with JSP views and WEB-INF folder structure.</p>

                <div class="features">
                    <div class="feature-box">
                        <h4>🏗️ Layered Architecture</h4>
                        <p>Clean separation between Controller, Service, and Repository layers</p>
                    </div>
                    <div class="feature-box">
                        <h4>📋 JSP Views</h4>
                        <p>Server-side rendering with JSP and JSTL tags</p>
                    </div>
                    <div class="feature-box">
                        <h4>🔄 MVC Pattern</h4>
                        <p>Traditional Model-View-Controller architecture</p>
                    </div>
                    <div class="feature-box">
                        <h4>💾 Database</h4>
                        <p>Integration with JPA/Hibernate and MySQL</p>
                    </div>
                </div>

                <div class="action-buttons">
                    <a href="<c:url value='/users' />" class="btn btn-primary">View Users</a>
                    <a href="<c:url value='/products' />" class="btn btn-secondary">View Products</a>
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

