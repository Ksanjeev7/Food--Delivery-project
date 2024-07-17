package com.food.servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.util.PasswordUtils;
import com.fooddelivery.daoImpl.UserDaoImpl;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/updatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

 UserDaoImpl userImpl;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		userImpl = new UserDaoImpl();
		super.init();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String token =  (String) request.getSession().getAttribute("resettoken");
		String newPassword = request.getParameter("newPassword");
		
		System.out.println("new Pssd: "+newPassword);
		String confirmPassword = request.getParameter("confirmPassword");
		System.out.println("conf Passd: "+ confirmPassword);

        if (token == null || token.isEmpty()) {
            request.setAttribute("error", "Invalid or expired reset link.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }
		
		if(!newPassword.equals(confirmPassword)) {
			request.setAttribute("errorPassword", "Password do not match");
			request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
			return;
		}
	        String hashedPassword = PasswordUtils.hashPassword(newPassword);

			  boolean success = userImpl.updatePassword(hashedPassword, token);
			    if(success) {
			    	 // Clear the token from the session
		            request.getSession().removeAttribute("resetToken");
			    	request.setAttribute("message", "Password Update Successfully");
			    }else {
			    	request.setAttribute("error","Failed to Update Password.. Try again");
			    }
			    
		        request.getRequestDispatcher("resetResult.jsp").forward(request, response);
	}

}
