package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.module.Restaurant;

public interface RestaurantDao {
	boolean addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurant();
}
