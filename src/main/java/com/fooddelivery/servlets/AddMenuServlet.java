package com.fooddelivery.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.dao.MenuDao;
import com.fooddelivery.daoImpl.MenuDaoImpl;
import com.fooddelivery.module.Menu;

@WebServlet("/AddMenu")
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     MenuDao menudao;
	@Override
		public void init() throws ServletException {
		  menudao = new MenuDaoImpl();
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String Id = request.getParameter("restaurantId");
//			System.out.println("Received restaurantId in servlet: " +Id);
		int restaurantId = Integer.parseInt(Id);
		String itemName = request.getParameter("itemName");
		String desc = request.getParameter("description");
		String price = request.getParameter("price");
		int itemPrice = Integer.parseInt(price);
		String rating = request.getParameter("rating");
		 double itemRating = Double.parseDouble(rating);
		String isAvailable = request.getParameter("isAvailable");
		String imagePath = request.getParameter("imagePath");
		
		Menu menu =  new Menu(restaurantId, itemName, desc, itemPrice, itemRating, isAvailable, imagePath);
		boolean isAdded = menudao.addMenu(menu);
		
		if(isAdded) {
			request.setAttribute("success", "Menu Item Added.");
			request.getRequestDispatcher("AddMenu.jsp").forward(request, response);
		}else {
            request.setAttribute("error", "Failed to add menu item.");
            request.getRequestDispatcher("AddMenu.jsp").forward(request, response);
        }
		} catch (NumberFormatException e) {
			 request.setAttribute("error", "An error occurred while adding the menu item: " + e.getMessage());
			 request.getRequestDispatcher("AddMenu.jsp").forward(request, response);
		}
	}

}
