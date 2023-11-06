package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.ApoliceVo;


public class ApoliceDao {
		private Connection conn = DatabaseConnection.getConnection();
		
		public String insert(ApoliceVo apolice) {
		    String sqlStatement = "INSERT INTO apolice (ID, TITULAR, INFOBIKE, VALORASSEGURADO, DATAINICIO, DATAFIM, CLIENTE_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";

		    try {
		        PreparedStatement statement = conn.prepareStatement(sqlStatement);
		        statement.setInt(1, apolice.getId());
		        statement.setString(2, apolice.getTitular());
		        statement.setString(3, apolice.getInfoBike());
		        statement.setDouble(4, apolice.getValorAssegurado());
		        statement.setDate(5, apolice.getDataInicio());
		        statement.setDate(6, apolice.getDataFim());
		        statement.setInt(7, apolice.getCliente_id());
		        statement.execute();
		    } catch (SQLException e) {
		        System.err.println("Algo deu errado");
		        DatabaseConnection.closeConnection();
		        e.printStackTrace();
		    }
		    return "Insert concluído";
		}

		public String delete(int id) {
		    String sqlStatement = "DELETE FROM apolice WHERE ID = ?";

		    try {
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

		public ArrayList<ApoliceVo> selectAll() {
		    ArrayList<ApoliceVo> apolices = new ArrayList<>();

		    String sqlStatement = "SELECT * FROM apolice";
		    try {
		        PreparedStatement statement = conn.prepareStatement(sqlStatement);
		        ResultSet apoliceData = statement.executeQuery();

		        while (apoliceData.next()) {
		            int id = apoliceData.getInt("ID");
		            String titular = apoliceData.getString("TITULAR");
		            String infoBike = apoliceData.getString("INFOBIKE");
		            double valorAssegurado = apoliceData.getDouble("VALORASSEGURADO");
		            Date dataInicio = apoliceData.getDate("DATAINICIO");
		            Date dataFim = apoliceData.getDate("DATAFIM");
		            int clienteId = apoliceData.getInt("CLIENTE_ID");

		            apolices.add(new ApoliceVo(id, titular, infoBike, valorAssegurado, dataInicio, dataFim, clienteId));
		        }
		    } catch (SQLException e) {
		        System.err.println("Algo deu errado");
		        DatabaseConnection.closeConnection();
		        e.printStackTrace();
		    }
		    return apolices;
		}

		public ApoliceVo selectById(int id) {
		    String sqlStatement = "SELECT * FROM apolice WHERE ID = ?";
		    ApoliceVo apolice = new ApoliceVo();

		    try {
		        PreparedStatement statement = conn.prepareStatement(sqlStatement);
		        statement.setInt(1, id);
		        ResultSet apoliceData = statement.executeQuery();
		        
		        if(apoliceData.next()) {
		        	int apoliceId = apoliceData.getInt("ID");
			        String titular = apoliceData.getString("TITULAR");
			        String infoBike = apoliceData.getString("INFOBIKE");
			        double valorAssegurado = apoliceData.getDouble("VALORASSEGURADO");
			        Date dataInicio = apoliceData.getDate("DATAINICIO");
			        Date dataFim = apoliceData.getDate("DATAFIM");
			        int clienteId = apoliceData.getInt("CLIENTE_ID");

			        apolice.setId(apoliceId);
			        apolice.setTitular(titular);
			        apolice.setInfoBike(infoBike);
			        apolice.setValorAssegurado(valorAssegurado);
			        apolice.setDataInicio(dataInicio);
			        apolice.setDataFim(dataFim);
			        apolice.setCliente_id(clienteId);
		        }
		        
		    } catch (SQLException e) {
		        System.err.println("Ocorreu um erro.");
		        DatabaseConnection.closeConnection();
		        e.printStackTrace();
		    }
		    return apolice;
		}

		public String update(ApoliceVo apolice) {
		    String sqlStatement = "UPDATE apolice SET TITULAR = ?, INFOBIKE = ?, VALORASSEGURADO = ?, DATAINICIO = ?, DATAFIM = ?, CLIENTE_ID = ? WHERE ID = ?";

		    try {
		        PreparedStatement statement = conn.prepareStatement(sqlStatement);
		        statement.setString(1, apolice.getTitular());
		        statement.setString(2, apolice.getInfoBike());
		        statement.setDouble(3, apolice.getValorAssegurado());
		        statement.setDate(4, apolice.getDataInicio());
		        statement.setDate(5, apolice.getDataFim());
		        statement.setInt(6, apolice.getCliente_id());
		        statement.setInt(7, apolice.getId());
		        statement.execute();
		    } catch (SQLException e) {
		        System.err.println("Ocorreu um erro");
		        DatabaseConnection.closeConnection();
		        e.printStackTrace();
		    }
		    return "Update concluído";
		}
}