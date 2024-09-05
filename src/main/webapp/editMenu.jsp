<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fooddelivery.module.Menu, com.fooddelivery.module.User"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Edit Menu</title>
    <link rel="stylesheet" href="editMenu.css">
    <link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">
    
</head>
<body>

  <header>
        <div class="header-content">
            <h1 class="site-title">DevFooday</h1>
            <nav>
                <a href="AdminDashBoard">Home</a>
                <% 
                    User admin = (User)session.getAttribute("admin");
                    if (admin != null) { 
                %>
                    <div class="dropdown">
                        <button class="dropbtn">
                            <i class="fas fa-user-circle"></i> <%= admin.getName() %> <i class="fas fa-caret-down"></i>
                        </button>
                        <div class="dropdown-content">
                            <a href="profile.jsp"><i class="fas fa-user-edit"></i> Profile</a>
                            <a href="LogoutServlet"><i class="fas fa-sign-out-alt"></i> Logout</a>
                        </div>
                    </div>
                <% } %>
            </nav>
        </div>
    </header>
<div class="container">

    <h1>Edit Menu Item</h1>
    
    <%
        Menu menu = (Menu) request.getAttribute("menu");
        if (menu != null) {
    %>
    <form action="UpdateServlet" method="post">
        <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
        <input type="hidden" name="restaurantId" value="<%= menu.getRestuarantId()%>">
        
        <label for="itemName">Item Name:</label>
        <input type="text" id="itemName" name="itemName" value="<%= menu.getItemName() %>" required><br><br>
        
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%= menu.getDescription() %>" required><br><br>
        
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" value="<%= menu.getPrice() %>" required><br><br>
        
        <label for="rating">Rating:</label>
        <input type="number" id="rating" name="rating" step="0.1" max="5" min="0" value="<%= menu.getRating() %>" required><br><br>
        
        <label for="isAvailable">Is Available:</label>
          <select id="isAvailable" name="isAvailable" required>
            <option value="Open" <%= "Open".equals(menu.isAvailable()) ? "selected" : "" %>>Open</option>
            <option value="Close" <%= "Close".equals(menu.isAvailable()) ? "selected" : "" %>>Close</option>
        </select><br><br>
          	<label for="imagePath">Image:</label> <input type="text"
			id="imagePath" name="imagePath" required><br>
        <button type="submit" class="btn">Update Menu</button>
    </form>
    <% } else { %>
    <p>Menu item not found.</p>
    <% } %>
    </div>
</body>
</html>
