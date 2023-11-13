package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pedrosena.portobikecare.vo.ClienteVo;

public class ClienteDao {
	private Connection conn = DatabaseConnection.getConnection();
	
	public int selectLast() {
		String sqlStatement = "select id from cliente order by id desc";
		int id = 0;
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			ResultSet idData = statement.executeQuery();
			
			if(idData.next()) {
				id = idData.getInt("id");	
			}
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			DatabaseConnection.closeConnection();
			e.printStackTrace();
			id = 0;
		}
		
		return id;
	}
	
	public ClienteVo selectByEmail(String email) {
		String sqlStatement = "select * from cliente where email = ?";
		ClienteVo c = new ClienteVo();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			statement.setString(1, email);
			ResultSet clienteData = statement.executeQuery();
			
			if(clienteData.next()) {
				int id = clienteData.getInt("ID");
	            String nome = clienteData.getString("NOME");
	            String cep = clienteData.getString("CEP");
	            String cEmail = clienteData.getString("EMAIL");
				
	            c.setId(id);
		        c.setNome(nome);
		        c.setCep(cep);
		        c.setEmail(cEmail);	
			}
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			e.printStackTrace();
			DatabaseConnection.closeConnection();
		}
		
		return c;
	}
}
