package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pedrosena.portobikecare.vo.CartaoVo;

public class CartaoDao {
    private Connection conn = DatabaseConnection.getConnection();

    public String insert(CartaoVo cartao) {
        String sqlStatement = "INSERT INTO cartao VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, cartao.getId());
            statement.setDouble(1, cartao.getNumCartao());
            statement.setString(2, cartao.getTitular());
            statement.setDate(3, cartao.getDataVal());
            statement.setInt(4, cartao.getCvv());
            statement.setString(5, cartao.getModalidade());
            statement.setLong(6, cartao.getPagamentoId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Insert concluído";
    }

    public String delete(int pagamentoId) {
        String sqlStatement = "DELETE FROM cartao WHERE PAGAMENTO_ID = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, pagamentoId);
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Delete concluído";
    }
    public ArrayList<CartaoVo> selectAll() {
        ArrayList<CartaoVo> cartoes = new ArrayList<>();

        String sqlStatement = "SELECT * FROM cartao";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet cartaoData = statement.executeQuery();

            while (cartaoData.next()) {
            	int id = cartaoData.getInt("ID");
                long numCartao = cartaoData.getLong("NUM_CARTAO");
                String titular = cartaoData.getString("TITULAR");
                Date dataVal = cartaoData.getDate("DATA_VAL");
                int cvv = cartaoData.getInt("CVV");
                String modalidade = cartaoData.getString("MODALIDADE");
                int pagamentoId = cartaoData.getInt("PAGAMENTO_ID");
                int clienteId = cartaoData.getInt("cliente_id");
                
                cartoes.add(new CartaoVo(id, pagamentoId, numCartao, titular, dataVal, cvv, modalidade, clienteId));      
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return cartoes;
    }
    
    public CartaoVo selectById(int pagamentoId) {
        String sqlStatement = "SELECT * FROM cartao WHERE PAGAMENTO_ID = ?";
        CartaoVo cartao = new CartaoVo();

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, pagamentoId);
            ResultSet cartaoData = statement.executeQuery();
            cartaoData.next();

            int cId = cartaoData.getInt("ID");
            long numCartao = cartaoData.getLong("NUM_CARTAO");
            String titular = cartaoData.getString("TITULAR");
            Date dataVal = cartaoData.getDate("DATA_VAL");
            int cvv = cartaoData.getInt("CVV");
            String modalidade = cartaoData.getString("MODALIDADE");
            int cartaoPagamentoId = cartaoData.getInt("PAGAMENTO_ID");

            cartao.setId(cId);
            cartao.setNumCartao(numCartao);
            cartao.setTitular(titular);
            cartao.setDataVal(dataVal);
            cartao.setCvv(cvv);
            cartao.setModalidade(modalidade);
            cartao.setPagamentoId(cartaoPagamentoId);
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return cartao;
    }
    
    public ArrayList<CartaoVo> selectByCliente(int id) {
        ArrayList<CartaoVo> cartoes = new ArrayList<>();

        String sqlStatement = "SELECT * FROM cartao where cliente_id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet cartaoData = statement.executeQuery();

            while (cartaoData.next()) {
            	int cartaoId = cartaoData.getInt("ID");
                long numCartao = cartaoData.getLong("NUM_CARTAO");
                String titular = cartaoData.getString("TITULAR");
                Date dataVal = cartaoData.getDate("DATA_VAL");
                int cvv = cartaoData.getInt("CVV");
                String modalidade = cartaoData.getString("MODALIDADE");
                int pagamentoId = cartaoData.getInt("PAGAMENTO_ID");
                int clienteId = cartaoData.getInt("cliente_id");
                
                cartoes.add(new CartaoVo(cartaoId, pagamentoId, numCartao, titular, dataVal, cvv, modalidade, clienteId));      
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return cartoes;
    }
    
    public int selectLast() {
		String sqlStatement = "select id from cartao order by id desc";
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
    
    public String update(CartaoVo cartao) {
        String sqlStatement = "UPDATE cartao SET TITULAR = ?, DATA_VAL = ?, CVV = ?, MODALIDADE = ? WHERE id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            
            statement.setString(1, cartao.getTitular());
            statement.setDate(2, cartao.getDataVal());
            statement.setInt(3, cartao.getCvv());
            statement.setString(4, cartao.getModalidade());
            statement.setLong(5, cartao.getId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Update concluído";
    }

    
}