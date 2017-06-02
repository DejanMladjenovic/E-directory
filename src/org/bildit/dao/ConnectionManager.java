package org.bildit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Name: ConnectionManager
 * 
 * @author Dejan
 */

public class ConnectionManager {
	
	//Instanciate class
	private static ConnectionManager instance = null;
	
	//Parameters for database
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String CONN_STRING = "jdbc:mysql://localhost:3306/imenik";
	
	//Connection instance
	private Connection connection = null;
	
	//Private constructor
	private ConnectionManager(){
	}

	//Return class instance
	public static ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	//Check if connection opened
	private boolean openConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Return connection
	public Connection getConnection(){
		if(connection == null){
			if(openConnection()){
				return connection;
			}else{
				return null;
			}
		}
		return connection;
	}
	
	//Close connection
	public void close(){
		try{
			connection.close();
			connection = null;
		}catch (Exception e){
			System.err.println(e);
		}
	}
}
