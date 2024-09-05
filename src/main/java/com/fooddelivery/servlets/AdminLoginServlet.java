package com.fooddelivery.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivery.dao.UserDao;
import com.fooddelivery.daoImpl.UserDaoImpl;
import com.fooddelivery.module.User;
import com.fooddelivery.util.PasswordUtils;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDaoImpl;
	@Override
		public void init() throws ServletException {
		 userDaoImpl = new UserDaoImpl();
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String userEmail = request.getParameter("Email");
	        String password = request.getParameter("password");

	        // Assume validateAdmin is a method that checks admin credentials
	        User admin = validateAdmin(userEmail, password);

	        if (admin != null) {
	            // Set the admin session attribute and redirect to Admin Dashboard
	            HttpSession session = request.getSession();
	            session.setAttribute("admin", admin);
	            response.sendRedirect("AdminDashBoard");
	        } else{
	            request.setAttribute("error", "Invalid Email or password.");
	            request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
	        }
	    }
	 private User validateAdmin(String email, String password) {  
		 try {
		 User userByEmail = userDaoImpl.getUserByEmail(email);

	        // Check if the user exists before attempting to verify the password
	        if (userByEmail != null && PasswordUtils.verifyPassword(password, userByEmail.getPassword()) && "Restaurant_admin".equals(userByEmail.getRole())) {
	            return userByEmail;
	        }
	    } catch (Exception e) {
	        System.err.println("Error during admin validation: " + e.getMessage());
	    }

	    return null;
}
	}

