package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.ClientePfVo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 * Essa classe é responsável pela contato com o banco de dados.
 * Aqui se encontra métodos de persistência e coleta de dados relacionados as cliente pessoa física usando JDBC 11.
 * @author Pedro Sena
 * @version 1.1
 * @since 1.0 - 11/09/2023
 */
public class ClientePfDao {
	private Connection conn = DatabaseConnection.getConnection();
	
	public String insert(ClientePfVo c) {
	    String sqlStatement = "INSERT INTO cliente (ID, NOME, CEP, EMAIL) VALUES (?, ?, ?, ?)";
	    String sqlStatement2 = "INSERT INTO clientepf (CPF, DATANASC, CLIENTE_ID) VALUES (?, ?, ?)";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, c.getId());
	        statement.setString(2, c.getNome());
	        statement.setString(3, c.getCep());
	        statement.setString(4, c.getEmail());
	        statement.execute();

	        PreparedStatement statement2 = conn.prepareStatement(sqlStatement2);
	        statement2.setString(1, c.getCpf());
	        statement2.setDate(2, c.getDataNasc());
	        statement2.setInt(3, c.getId());
	        statement2.execute();

	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return "Insert concluído";
	}

	public String delete(int id) {
	    String sqlStatement2 = "DELETE FROM clientepf WHERE CLIENTE_ID = ?";
	    String sqlStatement = "DELETE FROM cliente WHERE ID = ?";

	    try {
	        PreparedStatement statement2 = conn.prepareStatement(sqlStatement2);
	        statement2.setInt(1, id);
	        statement2.execute();

	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        statement.execute();

	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return "Delete concluído";
	}

	public ArrayList<ClientePfVo> selectAll() {
	    ArrayList<ClientePfVo> clientes = new ArrayList<>();

	    String sqlStatement = "SELECT * FROM cliente c INNER JOIN clientepf pf ON c.ID = pf.CLIENTE_ID ORDER BY c.ID";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        ResultSet clienteData = statement.executeQuery();

	        while (clienteData.next()) {
	            int id = clienteData.getInt("ID");
	            String nome = clienteData.getString("NOME");
	            String cep = clienteData.getString("CEP");
	            String email = clienteData.getString("EMAIL");
	            String cpf = clienteData.getString("CPF");
	            Date dataNasc = clienteData.getDate("DATANASC");

	            clientes.add(new ClientePfVo(id, nome, cep, email, cpf, dataNasc));
	        }

	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return clientes;
	}

	public ClientePfVo selectById(int id) {
	    String sqlStatement = "SELECT * FROM cliente c INNER JOIN clientepf pf ON c.ID = pf.CLIENTE_ID WHERE c.ID = ?";

	    ClientePfVo cliente = new ClientePfVo();

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        ResultSet clienteData = statement.executeQuery();

	        if(clienteData.next()) {
	        	int clienteId = clienteData.getInt("ID");
		        String nome = clienteData.getString("NOME");
		        String cep = clienteData.getString("CEP");
		        String email = clienteData.getString("EMAIL");
		        String cpf = clienteData.getString("CPF");
		        Date dataNasc = clienteData.getDate("DATANASC");

		        cliente.setId(clienteId);
		        cliente.setNome(nome);
		        cliente.setCep(cep);
		        cliente.setEmail(email);
		        cliente.setCpf(cpf);
		        cliente.setDataNasc(dataNasc);
	        }
	    } catch (SQLException e) {
	        System.err.println("Ocorreu um erro.");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return cliente;
	}

	public String update(ClientePfVo c) {
	    String sqlStatement = "UPDATE cliente SET NOME = ?, CEP = ?, EMAIL = ? WHERE ID = ?";
	    String sqlStatement2 = "UPDATE clientepf SET CPF = ?, DATANASC = ? WHERE CLIENTE_ID = ?";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        PreparedStatement statement2 = conn.prepareStatement(sqlStatement2);

	        statement.setString(1, c.getNome());
	        statement.setString(2, c.getCep());
	        statement.setString(3, c.getEmail());
	        statement.setInt(4, c.getId());
	        statement.execute();

	        statement2.setString(1, c.getCpf());
	        statement2.setDate(2, c.getDataNasc());
	        statement2.setInt(3, c.getId());
	        statement2.execute();

	    } catch (SQLException e) {
	        System.err.println("Ocorreu um erro");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return "Update concluído";
	}
}