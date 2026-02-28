<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List - Springmvcboot</title>
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

            <div class="section-header">
                <a href="<c:url value='/users/new' />" class="btn btn-primary">➕ Add New User</a>
            </div>

            <c:choose>
                <c:when test="${not empty users}">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Email</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Phone</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.phone}</td>
                                    <td class="action-buttons">
                                        <a href="<c:url value='/users/${user.id}' />" class="btn btn-small btn-info">View</a>
                                        <a href="<c:url value='/users/edit/${user.id}' />" class="btn btn-small btn-warning">Edit</a>
                                        <a href="<c:url value='/users/delete/${user.id}' />" class="btn btn-small btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div class="empty-state">
                        <p>No users found. <a href="<c:url value='/users/new' />">Create a new user</a></p>
                    </div>
                </c:otherwise>
            </c:choose>
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

