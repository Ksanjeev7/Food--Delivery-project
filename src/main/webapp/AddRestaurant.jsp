<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fooddelivery.module.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Restaurant</title>
<link rel="stylesheet" href="Addrestaurant.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">
    
</head>
<body>
    <%
        User admin = (User) session.getAttribute("admin");
        String adminName = admin != null ? admin.getName() : "Guest";
        Integer restaurantId = (Integer) request.getAttribute("restaurantId");
    %>
    <header>
        <div class="header-content">
            <a href="AdminDashBoard" class="head">
                <h1>DevFooday Admin Panel</h1>
            </a>
            <div class="admin-info">
                <p>Welcome, <strong><%= adminName %></strong></p>
                <a href="LogoutServlet" class="logout-btn">Logout</a>
            </div>
        </div>
    </header>

    <div class="form-container">
        <h2>Add New Restaurant</h2>

        <!-- Display success or error messages -->
        <%
            String addedMessage = (String) request.getAttribute("added");
            String failedMessage = (String) request.getAttribute("failed");
            if (addedMessage != null) {
        %>
            <div class="success-message"><%= addedMessage %></div>
            <a href="AddMenu.jsp?restaurantId=<%= restaurantId %>" class="add-menu-btn">Add Menus to Restaurant</a>
        <%
            } else if (failedMessage != null) {
        %>
            <div class="error-message"><%= failedMessage %></div>
        <%
            }
        %>

        <form action="AddRestaurantServlet" method="post">
            <div class="form-group">
                <label for="restaurantName">Restaurant Name:</label>
                <input type="text" id="restaurantName" name="restaurantName" required>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>

                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>

                <label for="rating">Rating:</label>
                <input type="number" id="rating" name="rating" step="0.1" max="5" min="0" required>

                <label for="cuisineType">Cuisine Type:</label>
                <input type="text" id="cuisineType" name="cuisineType" required>

                <label for="eta">ETA (Estimated Time of Arrival in minutes):</label>
                <input type="number" id="eta" name="eta" required>

                <label for="isActive">Is Active:</label>
                <select id="isActive" name="isActive" required>
                    <option value="Open">Open</option>
                    <option value="Close">Close</option>
                </select>

                <label for="imagePath">Image Path:</label>
                <input type="text" id="imagePath" name="imagePath">
            </div>

            <input type="submit" value="Add Restaurant">
        </form>
    </div>
</body>
</html>
