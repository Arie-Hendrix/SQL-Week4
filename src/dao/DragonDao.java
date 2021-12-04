package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Dragon;

public class DragonDao {
	
	private Connection connection;
	private final static String SELECT_ALL = "SELECT * FROM dragons";
	private String SELECT_ONE = "SELECT * FROM dragons WHERE name = ?";
	private String ADD_ONE = "INSERT INTO dragons (name, dragon_color, dragon_size, dragon_age) VALUES (?, ?, ?, ?)";
	private String DELETE_ONE = "DELETE FROM dragons WHERE name = ?";
	private String UPDATE_NAME = "UPDATE dragons SET name = ? WHERE name= ?";
	private String UPDATE_COLOR = "UPDATE dragons SET dragon_color = ? WHERE name= ?";
	private String UPDATE_SIZE = "UPDATE dragons SET dragon_size = ? WHERE name= ?";
	private String UPDATE_AGE = "UPDATE dragons SET dragon_age = ? WHERE name= ?";
	
	//For single dragon name search
	//PreparedStatement one = conn.prepareStatement(SELECT_ONE);
	//one.setString(1, dragonName);
	//ResultSet dn = one.executeQuery();
	
	public DragonDao() {
		connection = DBConnect.getConnection();
	}
	
	public List<Dragon> displayAll() throws SQLException{
		ResultSet sa = connection.prepareStatement(SELECT_ALL).executeQuery();
		List<Dragon> allDragons = new ArrayList<Dragon>();
		
		while (sa.next()) {
			allDragons.add(new Dragon(sa.getInt(1), sa.getString(2), sa.getString(3), sa.getString(4), sa.getInt(5)));
		}
		return allDragons;
	}
	
	public Dragon displayDragon(String name) throws SQLException {
		PreparedStatement one = connection.prepareStatement(SELECT_ONE);
		one.setString(1, name);
		ResultSet showOne = one.executeQuery();
		if (showOne.next()) {
		Dragon newOne = new Dragon(showOne.getInt(1), showOne.getString(2), showOne.getString(3), showOne.getString(4), showOne.getInt(5));
		return newOne;		
		}else {
			return null;
		}
		
	}

	public void addDragon(String name, String color, String size, int age) throws SQLException {
		PreparedStatement add = connection.prepareStatement(ADD_ONE);
		add.setString(1, name);
		add.setString(2, color);
		add.setString(3, size);
		add.setInt(4, age);
		add.executeUpdate();
	}
	
	public void removeDragon(String name) throws SQLException {
		PreparedStatement remove = connection.prepareStatement(DELETE_ONE);
		remove.setString(1, name);
		remove.executeUpdate();
	}
	
	//Method called when updating a dragon's name in menu
	public void updateDragonName(String inputName, String updateName) throws SQLException {
		PreparedStatement upName = connection.prepareStatement(UPDATE_NAME);
		upName.setString(1, updateName);
		upName.setString(2, inputName);
		upName.executeUpdate();
	}
	
	//Method called when updating a dragon's color in menu
	public void updateDragonColor(String inputName, String updateColor) throws SQLException {
		PreparedStatement upColor = connection.prepareStatement(UPDATE_COLOR);
		upColor.setString(1, updateColor);
		upColor.setString(2, inputName);
		upColor.executeUpdate();
	}
	
	//Method called when updating a dragon's size in menu
	public void updateDragonSize(String inputName, String updateSize) throws SQLException {
		PreparedStatement upSize = connection.prepareStatement(UPDATE_SIZE);
		upSize.setString(1, updateSize);
		upSize.setString(2, inputName);
		upSize.executeUpdate();
	}
	
	//Method called when updating a dragon's age in menu
	public void updateDragonAge(String inputName, int updateAge) throws SQLException {
		PreparedStatement upAge = connection.prepareStatement(UPDATE_AGE);
		upAge.setInt(1, updateAge);
		upAge.setString(2, inputName);
		upAge.executeUpdate();
	}
}