package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.Restaurant;
import com.fooddivery.dao.RestaurantDao;

public class RestaurantDaoImpl implements RestaurantDao  {

	private Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	Statement statement = null;
    RestaurantDaoImpl impl;
	private final static String INSERT_QUERY = "insert into `restaurant`(`RestaurantName`, `Address`, `Phone`, `Rating`, "
			+ "`CuisineType`, `isActive`, `ETA`, `AdminUserID`, `ImagePath`)values(?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `restaurant`  where `IdRestaurant`=?";
	private final static String DELETE_QUERY ="delete from `restaurant` where `IdRestaurant`=? ";
	private final static String UPDATE_QUERY ="update `restaurant` set `Name`=?, `Address`=?, `Phone`=?,`Rating`=?, `Email`=?,`CuisineType`=?,`isActive`=?,`ETA`=?, `AdminUserID`=?,`ImagePath`=? where `RestuarantID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `restaurant`";

	public RestaurantDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "Sanju@71");
			 System.out.println("Connection established: " + connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {

			try {
				 prepareStatement = connection.prepareStatement(INSERT_QUERY);
				 prepareStatement.setString(1,restaurant.getName());
				 prepareStatement.setString(2, restaurant.getAdress());
				 prepareStatement.setLong(3, restaurant.getPhoneNum());
				 prepareStatement.setDouble(4, restaurant.getRating());
				 prepareStatement.setString(5, restaurant.getCousineType());
				 prepareStatement.setString(6, restaurant.getIsActive());
				 prepareStatement.setString(7, restaurant.getETA());
				 prepareStatement.setInt(8, restaurant.getAdmineId());
				 prepareStatement.setString(9, restaurant.getImagePath());
				 prepareStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		try {

//			 System.out.println("connection established: "+connection);
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, restaurantId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int resId= res.getInt("IdRestaurant");
				  String name=res.getString("name");
				  String address=res.getString("Address");
				  long phoneNum=res.getLong("PhoneNumber");
				  double rating=res.getDouble("Rating");
				  String cusineType= res.getString("CuisineType");
				  String eta=res.getString("ETA");
				  int adminUserId =res.getInt("AdminUserID");
				  String imagePath=res.getString("ImagePath");
				  return new Restaurant(resId, name, address, phoneNum, rating, cusineType, cusineType, eta, adminUserId, imagePath);


			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}




		return null;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {

			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setString(1,restaurant.getName());
				 prepareStatement.setString(2, restaurant.getAdress());
				 prepareStatement.setLong(3, restaurant.getPhoneNum());
				 prepareStatement.setDouble(4, restaurant.getRating());
				 prepareStatement.setString(5, restaurant.getCousineType());
				 prepareStatement.setString(6, restaurant.getIsActive());
				 prepareStatement.setString(7, restaurant.getETA());
				 prepareStatement.setInt(8, restaurant.getAdmineId());
				 prepareStatement.setString(9, restaurant.getImagePath());
				 prepareStatement.setInt(10, restaurant.getResturantId());
				 prepareStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,restaurantId);
			   prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		ArrayList<Restaurant> restaurantList = new ArrayList<>();
//		System.out.println("connection established: "+connection);
		try {
			   if (connection != null) {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  int resId= res.getInt("IdRestaurant");
				  String name=res.getString("name");
				  String address=res.getString("Address");
				  long phoneNum=res.getLong("Phone");
				  double rating=res.getDouble("Rating");
				  String cusineType= res.getString("CuisineType");
				  String isActive = res.getString("isActive");
				  String eta=res.getString("ETA");
				  int adminUserId =res.getInt("AdminUserID");
				  String imagePath=res.getString("ImagePath");
				  Restaurant restaurant = new Restaurant(resId, name, address, phoneNum, rating, cusineType, isActive, eta, adminUserId, imagePath);
				  restaurantList.add(restaurant);
			  }
	}else {
		 System.err.println("Failed to establish connection!");
	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantList;
	}
	 private void closeResources() {
	        try {
	            if (res != null) {
					res.close();
				}
	            if (statement != null) {
					statement.close();
				}
	            if (connection != null) {
					connection.close();
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


}


