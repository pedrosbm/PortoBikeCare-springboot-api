package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.PagamentoVo;


public class PagamentoDao {
    private Connection conn = DatabaseConnection.getConnection();

    public String insert(PagamentoVo pagamento) {
        String sqlStatement = "INSERT INTO pagamento (ID, VALOR, PARCELAS, CLIENTE_ID) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, pagamento.getId());
            statement.setDouble(2, pagamento.getValor());
            statement.setInt(3, pagamento.getParcelas());
            statement.setInt(4, pagamento.getClienteId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Insert concluído";
    }

    public String delete(int id) {
        String sqlStatement = "DELETE FROM pagamento WHERE ID = ?";

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

    public ArrayList<PagamentoVo> selectAll() {
        ArrayList<PagamentoVo> pagamentos = new ArrayList<>();

        String sqlStatement = "SELECT * FROM pagamento";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet pagamentoData = statement.executeQuery();

            while (pagamentoData.next()) {
                int id = pagamentoData.getInt("ID");
                double valor = pagamentoData.getDouble("VALOR");
                int parcelas = pagamentoData.getInt("PARCELAS");
                int clienteId = pagamentoData.getInt("CLIENTE_ID");

                pagamentos.add(new PagamentoVo(id, valor, parcelas, clienteId));
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return pagamentos;
    }

    public PagamentoVo selectById(int id) {
        String sqlStatement = "SELECT * FROM pagamento WHERE ID = ?";
        PagamentoVo pagamento = new PagamentoVo();

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet pagamentoData = statement.executeQuery();
            pagamentoData.next();

            int pagamentoId = pagamentoData.getInt("ID");
            double valor = pagamentoData.getDouble("VALOR");
            int parcelas = pagamentoData.getInt("PARCELAS");
            int clienteId = pagamentoData.getInt("CLIENTE_ID");

            pagamento.setId(pagamentoId);
            pagamento.setValor(valor);
            pagamento.setParcelas(parcelas);
            pagamento.setClienteId(clienteId);
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return pagamento;
    }
    
    public int selectLast() {
        String sqlStatement = "select id from pagamento order by id desc";
        int id = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet pagamentoData = statement.executeQuery();
            
            if(pagamentoData.next()) {
            	id = pagamentoData.getInt("ID");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return id;
    }
    
    public int selectLast(int clienteId) {
        String sqlStatement = "select id from pagamento where cliente_id = ? order by id desc";
        int id = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, clienteId);
            ResultSet pagamentoData = statement.executeQuery();
            
            if(pagamentoData.next()) {
            	id = pagamentoData.getInt("ID");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return id;
    }
    
    public String update(PagamentoVo pagamento) {
        String sqlStatement = "UPDATE pagamento SET VALOR = ?, PARCELAS = ? WHERE ID = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setDouble(1, pagamento.getValor());
            statement.setInt(2, pagamento.getParcelas());
            statement.setInt(3, pagamento.getId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Update concluído";
    }

}