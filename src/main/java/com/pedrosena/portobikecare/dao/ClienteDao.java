package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
	private Connection conn = DatabaseConnection.getConnection();
	
	public int selectLast() {
		String sqlStatement = "select id from cliente order by id desc";
		int id;
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			ResultSet idData = statement.executeQuery();
			
			idData.next();
			
			id = idData.getInt("id");
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			DatabaseConnection.closeConnection();
			e.printStackTrace();
			id = 0;
		}
		
		return id;
	}
}
