package com.fooddelivery.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImpl.MenuDaoImpl;
import com.fooddelivery.module.Menu;

@WebServlet("/ViewMenus")
public class ViewMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private   MenuDaoImpl menuImp;
       
	public void init(ServletConfig config) throws ServletException {
		menuImp = new MenuDaoImpl();
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 doGet(req, resp);
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
		int resId = Integer.parseInt(request.getParameter("restaurantId"));
//		System.out.println("resId: "+ resId);
		  List<Menu> allMenusByRestaurant = menuImp.getAllMenusByRestaurant(resId);
		
		 if(allMenusByRestaurant != null && !allMenusByRestaurant.isEmpty()) {
			 request.setAttribute("menusByResId", allMenusByRestaurant);
			 request.getRequestDispatcher("menusById.jsp").forward(request, response);
			 
		 } else {
			 request.setAttribute("noMenus", "No menus found for this restaurant.");
             request.getRequestDispatcher("AdminDashBoard").forward(request, response);
         }
        }catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
	            request.getRequestDispatcher("AdminDashBoard.jsp").forward(request, response);
	        }
	}

}
