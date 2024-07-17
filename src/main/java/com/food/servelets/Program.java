package com.food.servelets;

import java.util.List;

import com.fooddelivery.daoImpl.OrderHistoryDaoImpl;
import com.fooddilivery.module.OrderHistory;

public class Program {

	public static void main(String[] args) {

		/*
		 * RestaurantDaoImpl restaurants = new RestaurantDaoImpl(); List<Restaurant>
		 * restaurant = restaurants.getAllRestaurant(); for(Restaurant res : restaurant)
		 * { System.out.println(res.getAdress()); }
		 */
		                  OrderHistoryDaoImpl impl = new OrderHistoryDaoImpl();

		                  List<OrderHistory> list = impl.getOrderHistoriesByUser(27);








//		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
//		Menu menu = menuDaoImpl.getMenu(2);
//		System.out.println(menu.getItemName());
//
	}

}
