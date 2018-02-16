package br.com.teste.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.dao.MotoristaDAO;
import br.com.teste.exceptions.FormatoDataIncorretoException;
import br.com.teste.to.Motorista;

public class MotoristaBO {
	public void cadastrarMotorista(Motorista motorista) throws SQLException, FormatoDataIncorretoException {
		if (motorista.getNascimento().charAt(2) != '/' || motorista.getNascimento().charAt(5) != '/') {
			throw new FormatoDataIncorretoException();
		} else {
			new MotoristaDAO().cadastrarMotorista(motorista);
		}
	}

	public ArrayList<Motorista> listaMotoristas() throws SQLException {
		return new MotoristaDAO().listaMotoristas();
	}

	public void alteraStatusMotorista(int status, int id) throws SQLException {
		new MotoristaDAO().alteraStatusMotorista(status, id);
	}

	public ArrayList<Motorista> pesquisaMotorista(int id) throws SQLException {
		return new MotoristaDAO().pesquisaMotorista(id);
	}
}
