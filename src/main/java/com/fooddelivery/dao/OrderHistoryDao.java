package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.module.Order;
import com.fooddelivery.module.OrderHistory;

public interface OrderHistoryDao {

	void addOrderHistory(Order order);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getOrderHistoriesByUserId(int userId);

}
