package br.com.teste.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.dao.CorridaDAO;
import br.com.teste.to.Corrida;

public class CorridaBO {
	public void cadastraCorrida(Corrida corrida) throws SQLException {
		new CorridaDAO().cadastraCorrida(corrida);
	}

	public ArrayList<Corrida> listaCorridas() throws SQLException {
		return new CorridaDAO().listaCorridas();
	}
}
