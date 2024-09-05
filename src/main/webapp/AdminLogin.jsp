<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - DevFoodday</title>
        <link rel="stylesheet" href="adminLogin.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
    <link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">
    
</head>
<body>
    <header>
        <h1>Admin Login</h1>
    </header>

    <div class="login-container">
    
            <% if (request.getAttribute("error") != null) { %>
                <p class="error-message"><%= request.getAttribute("error") %></p>
            <% } %>
    
        <form action="AdminLoginServlet" method="post">
            <div class="input-box">
                <label for="email">Email:</label>
                <input type="email" id="email" name="Email" required placeholder="user@gmail.com">
                <i class='bx bx-user-circle'></i>
            </div>

            <div class="input-box">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required placeholder="Password">
                <i class='bx bx-hide password-toggle' id="togglePassword"></i>
            </div>

            <input type="submit" value="Login" class="btn">

            <div class="forget-password">
                <a href="forgetPassword.jsp">Forgot Password?</a>
            </div>

            <div class="signup-link">
                <p>Don't have an account? <a href="signUp1.jsp">Sign Up</a></p>
            </div>
        </form>
    </div>

    <footer>
        <p>&copy; 2024 DevFoodday. All rights reserved.</p>
    </footer>

    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#password');
        togglePassword.addEventListener('click', function (e) {
            // toggle the type attribute
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            // toggle the icon
            this.classList.toggle('bx-show');
        });
    </script>
</body>
</html>