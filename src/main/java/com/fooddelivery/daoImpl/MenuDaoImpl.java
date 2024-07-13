
package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.Menu;
import com.fooddivery.dao.MenuDao;

public class MenuDaoImpl implements MenuDao {
	private  Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	Statement statement = null;

	private final static String INSERT_QUERY = "insert into `menu`(`IdRestaurant`, `ItemName`, `Description`, `Price`, `Ratings`, `isAvailable`, `ImagePath`)values(?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `menu`  where `MenuID`=?";
	private final static String DELETE_QUERY ="delete from `menu` where `MenuID`=? ";
	private final static String UPDATE_QUERY ="update `menu` set `Idrestaurant`=?, `ItemName`=?, `Description`=?,`Price`=?, `Ratings`=?,`isAvailable`=? where `MenuID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `menu` where `Idrestaurant`= ?";

	public MenuDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "Sanju@71");
		} catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
            System.err.println("SqL Exception: " + e.getMessage());

			e.printStackTrace();
		}
	}
	@Override
	public void addMenu(Menu menu) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setInt(1,menu.getMenuId());
			 prepareStatement.setInt(2, menu.getRestuarantId());
			 prepareStatement.setString(3, menu.getItemName());
			 prepareStatement.setString(4,menu.getDescription());
			 prepareStatement.setDouble(5, menu.getPrice());
			 prepareStatement.setDouble(6, menu.getRating());
			 prepareStatement.setString(7, menu.isAvailable());
			 prepareStatement.setString(8, menu.getImagePath());
			 prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId) {
		try {
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, menuId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int menuId1=res.getInt("MenuID");
				  int resId= res.getInt("Idrestaurant");
				  String itemName=res.getString("ItemName");
				  String description =res.getString("Description");
				  Double price =res.getDouble("Price");
				  Double rating =res.getDouble("Ratings");
				  String isAvailable= res.getString("isAvailable");
				  String imagePath =res.getString("ImagePath");
				 Menu menu = new Menu(menuId1, resId, itemName, description, menuId1, resId, isAvailable, imagePath);
				    System.out.println("Retrieved Menu: " + menu);
				 return menu;
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMenu(Menu menu) {


			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setInt(1,menu.getRestuarantId());
				 prepareStatement.setString(2, menu.getItemName());
				 prepareStatement.setString(3, menu.getDescription());
				 prepareStatement.setDouble(4, menu.getPrice());
				 prepareStatement.setDouble(5, menu.getRating());
				 prepareStatement.setString(6, menu.isAvailable());
				 prepareStatement.setInt(7, menu.getMenuId());
				  prepareStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}



	}

	@Override
	public void deleteMenu(int menuId) {
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,menuId);
			    prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		ArrayList<Menu> menuList = new ArrayList<>();
		try {
			 prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			 prepareStatement.setInt(1, restaurantId);
			  res = prepareStatement.executeQuery();

			  while(res.next()) {
				  int menuId=res.getInt("MenuID");
				  int resId= res.getInt("Idrestaurant");
				  String itemName=res.getString("ItemName");
				  String description =res.getString("Description");
				  Double price =res.getDouble("Price");
				  Double rating =res.getDouble("Ratings");
				  String isAvailable= res.getString("isAvailable");
				  String imagePath =res.getString("ImagePath");
				  Menu menu = new Menu(menuId, resId, itemName, description,price,rating, isAvailable, imagePath);
				  menuList.add(menu);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

}
