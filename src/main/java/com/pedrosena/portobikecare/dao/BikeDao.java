package com.pedrosena.portobikecare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pedrosena.portobikecare.vo.BikeVo;


public class BikeDao {
	private Connection conn = DatabaseConnection.getConnection();

	public String insert(BikeVo bike) {
        String sqlStatement = "INSERT INTO bike (ID, NICK, TIPOQUADRO, QUANTMARCHA, TIPOSUSPENSAO, TIPOFREIO, MODALIDADE, MARCA, MODELO, VALOR, NUMSERIE, TIPOPNEU, OBSERVACOES, NF, CLIENTE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sqlStatement);
            statement.setInt(1, bike.getId());
            statement.setString(2, bike.getNick());
            statement.setString(3, bike.getTipoQuadro());
            statement.setInt(4, bike.getQuantMarcha());
            statement.setString(5, bike.getTipoSuspensao());
            statement.setString(6, bike.getTipoFreio());
            statement.setString(7, bike.getModalidade());
            statement.setString(8, bike.getMarca());
            statement.setString(9, bike.getModelo());
            statement.setDouble(10, bike.getValor());
            statement.setString(11, bike.getNumSerie());
            statement.setString(12, bike.getTipoPneu());
            statement.setString(13, bike.getObservacoes());
            statement.setLong(14, bike.getNf());
            statement.setInt(15, bike.getCliente_id());

            statement.execute();
        } catch (SQLException e) {
            System.err.println("Algo deu errado");
            DatabaseConnection.closeConnection();
            e.printStackTrace();
            return "Erro na inserção";
        }

        return "Inserção concluída";
    }


	public String delete(int id) {
	    String sqlStatement = "DELETE FROM bike WHERE ID = ?";

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

	public List<BikeVo> selectAll() {
	    List<BikeVo> bikes = new ArrayList<>();

	    String sqlStatement = "SELECT * FROM bike";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        ResultSet bikeData = statement.executeQuery();

	        while (bikeData.next()) {
	            int id = bikeData.getInt("ID");
	            String nick = bikeData.getString("NICK");
	            String tipoQuadro = bikeData.getString("TIPOQUADRO");
	            int quantMarcha = bikeData.getInt("QUANTMARCHA");
	            String tipoSuspensao = bikeData.getString("TIPOSUSPENSAO");
	            String tipoFreio = bikeData.getString("TIPOFREIO");
	            String modalidade = bikeData.getString("MODALIDADE");
	            String marca = bikeData.getString("MARCA");
	            String modelo = bikeData.getString("MODELO");
	            double valor = bikeData.getDouble("VALOR");
	            String numSerie = bikeData.getString("NUMSERIE");
	            String tipoPneu = bikeData.getString("TIPOPNEU");
	            String observacoes = bikeData.getString("OBSERVACOES");
	            long nf = bikeData.getLong("NF");
	            int clienteId = bikeData.getInt("CLIENTE_ID");

	            bikes.add(new BikeVo(id, nick, tipoQuadro, quantMarcha, tipoSuspensao, tipoFreio, modalidade, marca, modelo, valor, numSerie, tipoPneu, observacoes, nf, clienteId));
	        }
	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }
	    return bikes;
	}
	
	public List<BikeVo> selectByUser(int id) {
	    List<BikeVo> bikes = new ArrayList<>();

	    String sqlStatement = "SELECT * FROM bike where cliente_id = ?";

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        ResultSet bikeData = statement.executeQuery();

	        while (bikeData.next()) {
	            int bikeId = bikeData.getInt("ID");
	            String nick = bikeData.getString("NICK");
	            String tipoQuadro = bikeData.getString("TIPOQUADRO");
	            int quantMarcha = bikeData.getInt("QUANTMARCHA");
	            String tipoSuspensao = bikeData.getString("TIPOSUSPENSAO");
	            String tipoFreio = bikeData.getString("TIPOFREIO");
	            String modalidade = bikeData.getString("MODALIDADE");
	            String marca = bikeData.getString("MARCA");
	            String modelo = bikeData.getString("MODELO");
	            double valor = bikeData.getDouble("VALOR");
	            String numSerie = bikeData.getString("NUMSERIE");
	            String tipoPneu = bikeData.getString("TIPOPNEU");
	            String observacoes = bikeData.getString("OBSERVACOES");
	            long nf = bikeData.getLong("NF");
	            int clienteId = bikeData.getInt("CLIENTE_ID");

	            bikes.add(new BikeVo(bikeId, nick, tipoQuadro, quantMarcha, tipoSuspensao, tipoFreio, modalidade, marca, modelo, valor, numSerie, tipoPneu, observacoes, nf, clienteId));
	        }
	    } catch (SQLException e) {
	        System.err.println("Algo deu errado");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }
	    return bikes;
	}

	public BikeVo selectById(int id) {
	    String sqlStatement = "SELECT * FROM bike WHERE ID = ?";
	    BikeVo bike = new BikeVo();

	    try {
	        PreparedStatement statement = conn.prepareStatement(sqlStatement);
	        statement.setInt(1, id);
	        ResultSet bikeData = statement.executeQuery();
	        
	        if(bikeData.next()) {
	        	int bikeId = bikeData.getInt("ID");
		        String nick = bikeData.getString("NICK");
		        String tipoQuadro = bikeData.getString("TIPOQUADRO");
		        int quantMarcha = bikeData.getInt("QUANTMARCHA");
		        String tipoSuspensao = bikeData.getString("TIPOSUSPENSAO");
		        String tipoFreio = bikeData.getString("TIPOFREIO");
		        String modalidade = bikeData.getString("MODALIDADE");
		        String marca = bikeData.getString("MARCA");
		        String modelo = bikeData.getString("MODELO");
		        double valor = bikeData.getDouble("VALOR");
		        String numSerie = bikeData.getString("NUMSERIE");
		        String tipoPneu = bikeData.getString("TIPOPNEU");
		        String observacoes = bikeData.getString("OBSERVACOES");
		        long nf = bikeData.getLong("NF");
		        int clienteId = bikeData.getInt("CLIENTE_ID");

		        bike.setId(bikeId);
		        bike.setNick(nick);
		        bike.setTipoQuadro(tipoQuadro);
		        bike.setQuantMarcha(quantMarcha);
		        bike.setTipoSuspensao(tipoSuspensao);
		        bike.setTipoFreio(tipoFreio);
		        bike.setModalidade(modalidade);
		        bike.setMarca(marca);
		        bike.setModelo(modelo);
		        bike.setValor(valor);
		        bike.setNumSerie(numSerie);
		        bike.setTipoPneu(tipoPneu);
		        bike.setObservacoes(observacoes);
		        bike.setNf(nf);
		        bike.setCliente_id(clienteId);
	        }
	    } catch (SQLException e) {
	        System.err.println("Ocorreu um erro.");
	        DatabaseConnection.closeConnection();
	        e.printStackTrace();
	    }
	    return bike;
	}
	
	public int selectLast() {
		String sqlStatement = "select id from bike order by id desc";
		int id;
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			ResultSet idData = statement.executeQuery();
			
			idData.next();
			
			id = idData.getInt("id");
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			DatabaseConnection.closeConnection();
			e.printStackTrace();
			id = 0;
		}
		
		return id;
	}
	
	public String update(BikeVo b) {
		String sqlStatement = "update bike set nick = ?, tipoquadro = ?, quantmarcha = ?, tiposuspensao = ?, tipofreio = ?, modalidade = ?, marca = ?, modelo = ?, valor = ?, numserie = ?, acessorio = ?, tipopneu = ?, obervacoes = ?, nf = ?, cliente_id = ? where bike_id = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sqlStatement);
			
			statement.setString(1, b.getNick());
			statement.setString(2, b.getTipoQuadro());
			statement.setInt(3, b.getQuantMarcha());
			statement.setString(4, b.getTipoSuspensao());
			statement.setString(5, b.getTipoFreio());
			statement.setString(6, b.getModalidade());
			statement.setString(7, b.getMarca());
			statement.setString(8, b.getModelo());
			statement.setDouble(9, b.getValor());
			statement.setString(10, b.getNumSerie());
			statement.setString(12, b.getTipoPneu());
			statement.setString(13, b.getObservacoes());
			statement.setLong(14, b.getNf());
			statement.setInt(15, b.getCliente_id());
			statement.setInt(16, b.getId());
			statement.execute();
			
		} catch (SQLException e) {
			System.err.println("Algo deu errado");
			DatabaseConnection.closeConnection();
			e.printStackTrace();
		}
		
		return "Update finalizado";
	}
}