package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.module.Menu;

public interface MenuDao {
	boolean addMenu(Menu menu);
	Menu getMenuById(int menuId);
	boolean updateMenu(Menu menu);
	boolean deleteMenu(int menuId);
	List<Menu> getAllMenusByRestaurant(int restaurantId);


}
