package com.fooddelivery.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivery.daoImpl.RestaurantDaoImpl;
import com.fooddelivery.module.Restaurant;
import com.fooddelivery.module.User;

@WebServlet("/AdminDashBoard")
public class AdminDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantDaoImpl restaurantDao;

	public void init(ServletConfig config) throws ServletException {
		restaurantDao = new RestaurantDaoImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		if (admin != null) {
			List<Restaurant> restaurantList = restaurantDao.getRestaurantsByAdmin(admin.getUserID());
			request.setAttribute("restaurantList", restaurantList);
		}
		request.getRequestDispatcher("AdminDashBoard.jsp").forward(request, response);
	}
}