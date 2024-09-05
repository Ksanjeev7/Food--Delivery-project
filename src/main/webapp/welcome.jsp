<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fooddelivery.module.User" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DevFoodday - Your Favorite Food Delivery</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="icon"
	href="https://dynamic.brandcrowd.com/preview/logodraft/844e35ef-0b11-40fa-849a-b02d8eef1832/image/large.png">
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            line-height: 1.6;
            background-color: #f4f4f4;
            color: #333;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 1rem 2rem;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }

        .user-welcome {
            color: white;
            margin-right: 1rem;
        }

        .user-welcome i {
            margin-right: 0.5rem;
        }

        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 1.8rem;
            font-weight: bold;
        }

        .nav-links {
            display: inline-flex;
            gap: 5px;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            padding: 0.5rem 2.5rem;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .nav-links a:hover {
            background-color: #45a049;
        }

        main {
            padding: 2rem;
            max-width: 1200px;
            margin: 80px auto 0 auto;
        }

        .hero {
            text-align: center;
            margin-bottom: 2rem;
        }

        .hero h1 {
            font-size: 2.5rem;
            color: #4CAF50;
        }

        .about,
        .contact {
            margin-top: 3rem;
        }

        .features {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            margin-top: 2rem;
        }

        .feature {
            flex-basis: 30%;
            text-align: center;
            margin-bottom: 1rem;
            background-color: #fff;
            padding: 1rem;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .feature:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        .contact {
            background-color: #fff;
            padding: 2rem;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .contact h2 {
            color: #4CAF50;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1rem;
            position: relative;
            bottom: 0;
            width: 100%;
            margin-top: 3rem;
        }

        @media (max-width: 768px) {
            .features {
                flex-direction: column;
            }

            .feature {
                flex-basis: 100%;
                margin-bottom: 2rem;
            }
        }

        @media (max-width: 480px) {
            header {
                padding: 1rem;
            }

            .hero h1 {
                font-size: 2rem;
            }

            .nav-links {
                flex-direction:column;
                align-items: flex-start;
            }

            .nav-links a {
                margin-bottom: 10px;
            }

            main {
                padding: 1rem;
            }
        }
    </style>
</head>

<body>
    <%
        User user = (User) session.getAttribute("loggedInUser");
    %>
    <header>
        <nav>
            <div class="logo">DevFoodday</div>
            <div class="nav-links">
                <%
                    if (user == null) {
                %>
                <a href="login1.jsp">User Login</a>
                <a href="AdminLogin.jsp">Add Restaurant</a>
                <a href="#about">About</a>
                <a href="#contact">Contact</a>
                <a href="signUp1.jsp">Register</a>
                <%
                    } else {
                %>
                <span class="user-welcome">
                    <i class="fas fa-user-circle"></i> Welcome <%=user.getName()%>
                </span>
                <a href="LogoutServlet">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
                <%
                    }
                %>
            </div>
        </nav>
    </header>

    <main>
        <section class="hero">
            <h1>Welcome to DevFoodday</h1>
            <p>Your favorite meals, delivered fast and fresh.</p>
        </section>

        <section id="about" class="about">
            <h2>About DevFoodday</h2>
            <p>DevFoodday is your go-to platform for ordering delicious meals from local restaurants. We connect food lovers with their favorite eateries, ensuring quick and reliable delivery right to your doorstep.</p>
        </section>

        <section class="features">
            <div class="feature">
                <h3>Wide Selection</h3>
                <p>Choose from hundreds of local restaurants.</p>
            </div>
            <div class="feature">
                <h3>Fast Delivery</h3>
                <p>Get your food delivered in 30 minutes or less.</p>
            </div>
            <div class="feature">
                <h3>Easy Ordering</h3>
                <p>User-friendly interface for seamless ordering.</p>
            </div>
        </section>

        <section id="contact" class="contact">
            <h2>Contact Us</h2>
            <p>We're here to help! Reach out to us with any questions or concerns.</p>
            <ul>
                <li>Email: support@devfoodday.com</li>
                <li>Phone: 8522897569</li>
                <li>Address: 777 Food Street, Cuisine City, Bangalore 560076</li>
            </ul>
            <p>Business Hours: Monday to Friday, 9 AM - 6 PM</p>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 DevFoodday. All rights reserved.</p>
    </footer>
</body>

</html>
