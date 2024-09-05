package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.module.OrderItem;

public interface OrderItemDao {
	void addOrderItem(List<OrderItem> orderItem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getOrderItemsByOrder(String orderId);






}
