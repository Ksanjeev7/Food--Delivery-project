package com.food.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.util.PasswordUtils;
import com.fooddelivery.daoImpl.UserDaoImpl;
import com.fooddilivery.module.User;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
    private  UserDaoImpl userDao ;
	 @Override
	public void init() throws ServletException {
		super.init();
		userDao= new UserDaoImpl();
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUser(userName);

        if (user != null) {
            // Debugging information
            System.out.println("Entered Password (Plain): " + password);
            System.out.println("Stored Password (Encrypted): " + user.getPassword());

            // Check if the entered password matches the stored encrypted password
            if (PasswordUtils.verifyPassword(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user);

                response.sendRedirect("home");
                return;
            }
        }

        request.setAttribute("errorMessage", "Invalid username or password");
        request.getRequestDispatcher("login1.jsp").forward(request, response);
    }
}
