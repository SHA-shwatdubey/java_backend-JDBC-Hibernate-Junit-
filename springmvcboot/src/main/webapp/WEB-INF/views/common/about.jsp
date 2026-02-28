<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About - Springmvcboot</title>
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

            <section class="about-section">
                <h3>About Springmvcboot</h3>

                <div class="info-box">
                    <h4>📌 Project Information</h4>
                    <table class="info-table">
                        <tr>
                            <td><strong>Project Name:</strong></td>
                            <td>springmvcboot</td>
                        </tr>
                        <tr>
                            <td><strong>Group ID:</strong></td>
                            <td>com.capgemini</td>
                        </tr>
                        <tr>
                            <td><strong>Company:</strong></td>
                            <td>${company}</td>
                        </tr>
                        <tr>
                            <td><strong>Version:</strong></td>
                            <td>${version}</td>
                        </tr>
                        <tr>
                            <td><strong>Java Version:</strong></td>
                            <td>21</td>
                        </tr>
                        <tr>
                            <td><strong>Spring Boot Version:</strong></td>
                            <td>3.5.11</td>
                        </tr>
                    </table>
                </div>

                <div class="info-box">
                    <h4>🎯 Purpose</h4>
                    <p>This is a demo Spring Boot MVC application demonstrating:</p>
                    <ul>
                        <li>Traditional Spring MVC architecture with JSP views</li>
                        <li>WEB-INF folder structure for organizing views</li>
                        <li>Clean separation of concerns using layered architecture</li>
                        <li>Database integration with JPA/Hibernate</li>
                        <li>Service layer for business logic</li>
                        <li>Controller layer for request handling</li>
                        <li>Global exception handling</li>
                    </ul>
                </div>

                <div class="info-box">
                    <h4>🛠 Technology Stack</h4>
                    <ul>
                        <li><strong>Backend:</strong> Java 21, Spring Boot 3.5.11</li>
                        <li><strong>Frontend:</strong> JSP, JSTL, HTML5, CSS3, JavaScript</li>
                        <li><strong>Database:</strong> MySQL 8.0+ (with JPA/Hibernate)</li>
                        <li><strong>Build Tool:</strong> Maven 3.8+</li>
                        <li><strong>Testing:</strong> JUnit 5, Mockito</li>
                    </ul>
                </div>

                <div class="info-box">
                    <h4>📂 Folder Structure</h4>
                    <p><strong>src/WebApp/WEB-INF/views/</strong></p>
                    <ul>
                        <li>common/ - Common pages (home, about, index)</li>
                        <li>user/ - User management pages (list, form, view)</li>
                        <li>product/ - Product management pages (list, form, view)</li>
                    </ul>
                </div>

                <div class="action-buttons">
                    <a href="<c:url value='/users' />" class="btn btn-primary">Go to Users</a>
                    <a href="<c:url value='/' />" class="btn btn-secondary">Back to Home</a>
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

