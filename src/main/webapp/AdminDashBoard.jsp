<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.fooddelivery.module.Restaurant, com.fooddelivery.module.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin Dashboard</title>
    <link rel="stylesheet" href="adminDashBoard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">
    
</head>
<body>

<% 
            User admin = (User) session.getAttribute("admin");
            String adminName = admin != null ? admin.getName() : null;
        %>

    <header>
        <div class="header-content">
            <h1>DevFooday Admin Panel</h1>
            <nav>
                <div class="dropdown">
                    <button class="dropbtn">
                     <% if (adminName != null) { %>
                        <i class="fas fa-user-circle"></i> <%= adminName %> <i class="fas fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="profile.jsp"><i class="fas fa-user-edit"></i> My Profile</a>
                        <a href="LogoutServlet"><i class="fas fa-sign-out-alt"></i> Logout</a>
                    </div>
                </div>
                <% } else { %>
                    <p class="error-message">Your session has expired. Please <a href="AdminLogin.jsp">login again.</a></p>
                <% } %>
            </nav>
        </div>
    </header>

    <div class="container">
        <h2>Your Restaurants</h2>
         <!-- Display success, error, or info messages -->
        <%
            String errorMessage = (String) request.getAttribute("error");
            String successMessage = (String) request.getAttribute("success");
            String noMenusMessage = (String) request.getAttribute("noMenus");


            if (errorMessage != null) {
        %>
            <div class="message error"><%= errorMessage %></div>
        <% 
            } else if (successMessage != null) {
        %>
            <div class="message success"><%= successMessage %></div>
        <% 
            } else if (noMenusMessage != null) {
                %>
                <div class="message info"><%= noMenusMessage %></div>
            <% 
                } 
            List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantList");
            if (restaurants != null && !restaurants.isEmpty()) {
        %>
        <div class="restaurant-list">
            <ul>
                <%
                    for (Restaurant restaurant : restaurants) {
                %>
                <li>
                    <img alt="<%= restaurant.getName() %>" src="<%= restaurant.getImagePath() %>">
                   <div class="restaurant-details">
                        <h3><%= restaurant.getName() %></h3>
                        <p><strong>Address:</strong> <%= restaurant.getAdress() %></p>
                        <p><strong>Phone:</strong> <%= restaurant.getPhoneNum() %></p>
                        <p><strong>Rating:</strong> <%= restaurant.getRating() %></p>
                        <p><strong>Cuisine Type:</strong> <%= restaurant.getCousineType() %></p>
                        <p><strong>ETA:</strong> <%= restaurant.getETA() %> minutes</p>
                        </div>
                        <div class="restaurant-actions">
                        <a href="ViewMenus?restaurantId=<%=restaurant.getResturantId()%>" class="btn">View Menus</a>
                        <a href="AddMenu.jsp?restaurantId=<%=restaurant.getResturantId()%>" class="btn">Add Menu</a>
                    </div>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
        <%
            } else {
        %>
        <p>You don't have any restaurants yet.</p>
        <%
            }
        %>

        <div class="actions">
            <a href="AddRestaurant.jsp" class="btn">Add New Restaurant</a>
        </div>
    </div>
</body>
</html>
