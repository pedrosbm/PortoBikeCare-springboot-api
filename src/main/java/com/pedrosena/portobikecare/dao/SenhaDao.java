package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pedrosena.portobikecare.vo.SenhaVo;


public class SenhaDao {
	private Connection conn = DatabaseConnection.getConnection();
	
	public String insert(SenhaVo s) {
		String sqlStatement = "insert into senha values(?, ?)";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			statement.setString(1, s.getSenha());
			statement.setInt(2, s.getClienteId());
			
			statement.execute();
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			e.printStackTrace();
			DatabaseConnection.closeConnection();
		}
		
		return "Insert finalizado";
	}
	
	public String delete(SenhaVo s) {
		String sqlStatement = "delete from senha where cliente_id = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			
			statement.setInt(1, s.getClienteId());
			statement.execute();
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			e.printStackTrace();
			DatabaseConnection.closeConnection();
		}
		
		return "Delete finalizado";
	}

	public SenhaVo selectById(int id) {
	    String sqlStatement = "SELECT * FROM senha WHERE cliente_id = ?";
	    SenhaVo senha = new SenhaVo();

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        ResultSet senhaData = statement.executeQuery();
	        
	        if(senhaData.next()) {
	        	senha.setClienteId(senhaData.getInt("cliente_id"));
	        	senha.setSenha(senhaData.getString("senha"));
	        }
	    } catch (SQLException e) {
	        System.err.println("Ocorreu um erro.");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }
	    return senha;
	}
}