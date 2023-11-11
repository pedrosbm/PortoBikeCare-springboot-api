package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pedrosena.portobikecare.vo.PlanoVo;


public class PlanoDao {
    private Connection conn = DatabaseConnection.getConnection();

    public String insert(PlanoVo plano) {
        String sqlStatement = "INSERT INTO plano (ID, NOME, VALOR, COBERTURA, APOLICE_ID) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, plano.getId());
            statement.setString(2, plano.getNome());
            statement.setDouble(3, plano.getValor());
            statement.setString(4, plano.getCobertura());
            statement.setInt(5, plano.getApoliceId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Insert concluído";
    }

    public String delete(int id) {
        String sqlStatement = "DELETE FROM plano WHERE ID = ?";

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

    public ArrayList<PlanoVo> selectAll() {
        ArrayList<PlanoVo> planos = new ArrayList<>();

        String sqlStatement = "SELECT * FROM plano";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet planoData = statement.executeQuery();

            while (planoData.next()) {
                int id = planoData.getInt("ID");
                String nome = planoData.getString("NOME");
                double valor = planoData.getDouble("VALOR");
                String cobertura = planoData.getString("COBERTURA");
                int apoliceId = planoData.getInt("APOLICE_ID");

                planos.add(new PlanoVo(id, nome, valor, cobertura, apoliceId));
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return planos;
    }

    public PlanoVo selectById(int id) {
        String sqlStatement = "SELECT * FROM plano WHERE ID = ?";
        PlanoVo plano = new PlanoVo();

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet planoData = statement.executeQuery();
            planoData.next();

            int planoId = planoData.getInt("ID");
            String nome = planoData.getString("NOME");
            double valor = planoData.getDouble("VALOR");
            String cobertura = planoData.getString("COBERTURA");
            int apoliceId = planoData.getInt("APOLICE_ID");

            plano.setId(planoId);
            plano.setNome(nome);
            plano.setValor(valor);
            plano.setCobertura(cobertura);
            plano.setApoliceId(apoliceId);
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return plano;
    }
    
    public List<PlanoVo> selectByCliente(int id) {
        ArrayList<PlanoVo> planos = new ArrayList<>();

        String sqlStatement = "SELECT * FROM plano where cliente_id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet planoData = statement.executeQuery();

            while (planoData.next()) {
                int planoId = planoData.getInt("ID");
                String nome = planoData.getString("NOME");
                double valor = planoData.getDouble("VALOR");
                String cobertura = planoData.getString("COBERTURA");
                int apoliceId = planoData.getInt("APOLICE_ID");

                planos.add(new PlanoVo(planoId , nome, valor, cobertura, apoliceId));
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return planos;
    }
    
    public int selectLast() {
        String sqlStatement = "SELECT id FROM plano order by id desc";
        int id = 0;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet planoData = statement.executeQuery();
            
            planoData.next();

            id = planoData.getInt("ID");
        	
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return id;
    }
    public String update(PlanoVo plano) {
        String sqlStatement = "UPDATE plano SET NOME = ?, VALOR = ?, COBERTURA = ?, APOLICE_ID = ? WHERE ID = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setString(1, plano.getNome());
            statement.setDouble(2, plano.getValor());
            statement.setString(3, plano.getCobertura());
            statement.setInt(4, plano.getApoliceId());
            statement.setInt(5, plano.getId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Update concluído";
    }

}