package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.ClientePjVo;


/**
 * Essa classe é responsável pela contato com o banco de dados.
 * Aqui se encontra métodos de persistência e coleta de dados relacionados as cliente pessoa jurídica usando JDBC 11.
 * @author Pedro Sena
 * @version 1.1
 * @since 1.0 - 11/09/2023
 */
public class ClientePjDao {
	private Connection conn = DatabaseConnection.getConnection();
	
	public String insert(ClientePjVo c) {
	    String sqlStatement = "INSERT INTO cliente (ID, NOME, CEP, EMAIL) VALUES (?, ?, ?, ?)";
	    String sqlStatement2 = "INSERT INTO clientepj (CNPJ, DATAFUND, CLIENTE_ID) VALUES (?, ?, ?)";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, c.getId());
	        statement.setString(2, c.getNome());
	        statement.setString(3, c.getCep());
	        statement.setString(4, c.getEmail());
	        statement.execute();

	        PreparedStatement statement2 = conn.prepareStatement(sqlStatement2);
	        statement2.setString(1, c.getCnpj());
	        statement2.setDate(2, c.getDataFund());
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
	    String sqlStatement2 = "DELETE FROM clientepj WHERE CLIENTE_ID = ?";
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

	public ArrayList<ClientePjVo> selectAll() {
	    ArrayList<ClientePjVo> clientes = new ArrayList<>();

	    String sqlStatement = "SELECT * FROM cliente c INNER JOIN clientepj pj ON c.ID = pj.CLIENTE_ID ORDER BY c.ID";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        ResultSet clienteData = statement.executeQuery();

	        while (clienteData.next()) {
	            int id = clienteData.getInt("ID");
	            String nome = clienteData.getString("NOME");
	            String cep = clienteData.getString("CEP");
	            String email = clienteData.getString("EMAIL");
	            String cnpj = clienteData.getString("CNPJ");
	            Date dataFund = clienteData.getDate("DATAFUND");

	            clientes.add(new ClientePjVo(id, nome, cep, email, cnpj, dataFund));
	        }

	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return clientes;
	}

	public ClientePjVo selectById(int id) {
	    String sqlStatement = "SELECT * FROM cliente c INNER JOIN clientepj pj ON c.ID = pj.CLIENTE_ID WHERE c.ID = ?";

	    ClientePjVo cliente = new ClientePjVo();

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        ResultSet clienteData = statement.executeQuery();

	        if(clienteData.next()) {
		        int clienteId = clienteData.getInt("ID");
		        String nome = clienteData.getString("NOME");
		        String cep = clienteData.getString("CEP");
		        String email = clienteData.getString("EMAIL");
		        String cnpj = clienteData.getString("CNPJ");
		        Date dataFund = clienteData.getDate("DATAFUND");

		        cliente.setId(clienteId);
		        cliente.setNome(nome);
		        cliente.setCep(cep);
		        cliente.setEmail(email);
		        cliente.setCnpj(cnpj);
		        cliente.setDataFund(dataFund);
	        }
	    } catch (SQLException e) {
	        System.err.println("Ocorreu um erro.");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }

	    return cliente;
	}

	public String update(ClientePjVo c) {
	    String sqlStatement = "UPDATE cliente SET NOME = ?, CEP = ?, EMAIL = ? WHERE ID = ?";
	    String sqlStatement2 = "UPDATE clientepj SET CNPJ = ?, DATAFUND = ? WHERE CLIENTE_ID = ?";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        PreparedStatement statement2 = conn.prepareStatement(sqlStatement2);

	        statement.setString(1, c.getNome());
	        statement.setString(2, c.getCep());
	        statement.setString(3, c.getEmail());
	        statement.setInt(4, c.getId());
	        statement.execute();

	        statement2.setString(1, c.getCnpj());
	        statement2.setDate(2, c.getDataFund());
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

