package br.com.teste.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.dao.PassageiroDAO;
import br.com.teste.exceptions.FormatoDataIncorretoException;
import br.com.teste.to.Passageiro;

public class PassageiroBO {
	public void cadastraPassageiro(Passageiro passageiro) throws SQLException, FormatoDataIncorretoException {
		if (passageiro.getNascimento().charAt(2) != '/' || passageiro.getNascimento().charAt(5) != '/') {
			throw new FormatoDataIncorretoException();
		} else {
			new PassageiroDAO().cadastraPassageiro(passageiro);
		}
	}

	public ArrayList<Passageiro> listaPassageiros() throws SQLException {
		return new PassageiroDAO().listaPassageiros();
	}
}
