package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pedrosena.portobikecare.vo.BoletoVo;

public class BoletoDao {
    private Connection conn = DatabaseConnection.getConnection();

    public String insert(BoletoVo boleto) {
        String sqlStatement = "INSERT INTO boleto (ID, TITULAR, REMETENTE, VENC_BOLETO, COD_BOL, AGENCIA, PAGAMENTO_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, boleto.getBoleto_id());
            statement.setString(2, boleto.getTitular());
            statement.setString(3, boleto.getRemetente());
            statement.setDate(4, boleto.getVencBoleto());
            statement.setString(5, boleto.getNumCod());
            statement.setString(6, boleto.getAgencia());
            statement.setInt(7, boleto.getPagamento_id());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Insert concluído";
    }


    public String delete(int id) {
        String sqlStatement = "DELETE FROM boleto WHERE ID = ?";

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

    public ArrayList<BoletoVo> selectAll() {
        ArrayList<BoletoVo> boletos = new ArrayList<>();

        String sqlStatement = "SELECT * FROM boleto";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            ResultSet boletoData = statement.executeQuery();

            while (boletoData.next()) {
                int id = boletoData.getInt("ID");
                String titular = boletoData.getString("TITULAR");
                String remetente = boletoData.getString("REMETENTE");
                Date vencBoleto = boletoData.getDate("VENC_BOLETO");
                String codBol = boletoData.getString("COD_BOL");
                String agencia = boletoData.getString("AGENCIA");
                int pagamentoId = boletoData.getInt("PAGAMENTO_ID");

                boletos.add(new BoletoVo(id, titular, remetente, vencBoleto, codBol, agencia, pagamentoId));
            }
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return boletos;
    }

    public BoletoVo selectById(int id) {
        String sqlStatement = "SELECT * FROM boleto WHERE ID = ?";
        BoletoVo boleto = new BoletoVo();

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet boletoData = statement.executeQuery();
            
            if(boletoData.next()) {
            	int boletoId = boletoData.getInt("ID");
                String titular = boletoData.getString("TITULAR");
                String remetente = boletoData.getString("REMETENTE");
                Date vencBoleto = boletoData.getDate("VENC_BOLETO");
                String codBol = boletoData.getString("COD_BOL");
                String agencia = boletoData.getString("AGENCIA");
                int pagamentoId = boletoData.getInt("PAGAMENTO_ID");

                boleto.setBoleto_id(boletoId);
                boleto.setTitular(titular);
                boleto.setRemetente(remetente);
                boleto.setVencBoleto(vencBoleto);
                boleto.setNumCod(codBol);
                boleto.setAgencia(agencia);
                boleto.setPagamento_id(pagamentoId);
            }
            
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro.");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return boleto;
    }

    public String update(BoletoVo boleto) {
        String sqlStatement = "UPDATE boleto SET TITULAR = ?, REMETENTE = ?, VENC_BOLETO = ?, COD_BOL = ?, AGENCIA = ?, PAGAMENTO_ID = ? WHERE ID = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setString(1, boleto.getTitular());
            statement.setString(2, boleto.getRemetente());
            statement.setDate(3, boleto.getVencBoleto());
            statement.setString(4, boleto.getNumCod());
            statement.setString(5, boleto.getAgencia());
            statement.setInt(6, boleto.getPagamento_id());
            statement.setInt(7, boleto.getBoleto_id());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
        }
        return "Update concluído";
    }
}