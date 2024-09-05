package com.fooddelivery.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImpl.MenuDaoImpl;
import com.fooddelivery.module.Menu;

/**
 * Servlet implementation class UpdateMenuServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDaoImpl menuImp;

	@Override
	public void init() throws ServletException {
		menuImp = new MenuDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId")); 
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		double rating = Double.parseDouble(request.getParameter("rating"));
		String isAvailable = request.getParameter("isAvailable");
		String imagePath = request.getParameter("imagePath");

		Menu menu = new Menu(menuId, restaurantId, itemName, description, price, rating, isAvailable,imagePath);


		boolean isUpdated = menuImp.updateMenu(menu);
		if (isUpdated) {
			request.setAttribute("success", "Menu item updated successfully.");
		} else {
			request.setAttribute("error", "Failed to update menu item.");
		}
		request.getRequestDispatcher("/ViewMenus?restaurantId=" + restaurantId).forward(request, response);
//		System.out.println("viewMenus Servelet called...");
	}

}
