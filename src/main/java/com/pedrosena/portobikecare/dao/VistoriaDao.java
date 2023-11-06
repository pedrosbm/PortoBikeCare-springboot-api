package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.VistoriaVo;


public class VistoriaDao {
    private Connection conn = DatabaseConnection.getConnection();

    public String insert(VistoriaVo vistoria) {
        String sqlStatement = "INSERT INTO vistoria (ID, DATAVISTORIA, ETAPA, BIKE_ID) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, vistoria.getId());
            statement.setDate(2, vistoria.getDataVistoria());
            statement.setString(3, vistoria.getEtapa());
            statement.setInt(4, vistoria.getBikeid());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Insert concluído";
    }

    public String delete(int id) {
        String sqlStatement = "DELETE FROM vistoria WHERE ID = ?";

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

    public ArrayList<VistoriaVo> selectAll() {
        ArrayList<VistoriaVo> vistorias = new ArrayList<>();

        String sqlStatement = "SELECT * FROM vistoria";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet vistoriaData = statement.executeQuery();

            while (vistoriaData.next()) {
                int id = vistoriaData.getInt("ID");
                Date dataVistoria = vistoriaData.getDate("DATAVISTORIA");
                String etapa = vistoriaData.getString("ETAPA");
                int bikeId = vistoriaData.getInt("BIKE_ID");

                vistorias.add(new VistoriaVo(id, dataVistoria, etapa, bikeId));
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return vistorias;
    }

    public VistoriaVo selectById(int id) {
        String sqlStatement = "SELECT * FROM vistoria WHERE ID = ?";
        VistoriaVo vistoria = new VistoriaVo();

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet vistoriaData = statement.executeQuery();
            vistoriaData.next();

            int vistoriaId = vistoriaData.getInt("ID");
            Date dataVistoria = vistoriaData.getDate("DATAVISTORIA");
            String etapa = vistoriaData.getString("ETAPA");
            int bikeId = vistoriaData.getInt("BIKE_ID");

            vistoria.setId(vistoriaId);
            vistoria.setDataVistoria(dataVistoria);
            vistoria.setEtapa(etapa);
            vistoria.setBikeid(bikeId);
            
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return vistoria;
    }
}
