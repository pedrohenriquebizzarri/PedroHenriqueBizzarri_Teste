package br.com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.to.Passageiro;
import br.com.teste.utils.Utils;

public class PassageiroDAO {
	private Connection conn = null;

	public PassageiroDAO() {
		ConnectionManager.getInstance();
		conn = ConnectionManager.getConnection();
	}

	public void cadastraPassageiro(Passageiro passageiro) throws SQLException {
		String sql = "INSERT INTO TB_TESTE_PASSAGEIRO (nome, nascimento, cpf, id_sexo) VALUES (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, passageiro.getNome());
		ps.setString(2, new Utils().inverteData(passageiro.getNascimento()));
		ps.setString(3, passageiro.getCpf());
		ps.setInt(4, new Utils().formataSexoParaInt(passageiro.getSexo()));
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	public ArrayList<Passageiro> listaPassageiros() throws SQLException {
		String sql = "SELECT P.id, P.nome, P.cpf, P.nascimento, S.sexo FROM TB_TESTE_PASSAGEIRO P JOIN TB_TESTE_SEXO S ON P.id_sexo = S.id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Passageiro> lista = new ArrayList<Passageiro>();
		Passageiro passageiro = null;
		while (rs.next()) {
			passageiro = new Passageiro();
			passageiro.setId(rs.getInt(1));
			passageiro.setNome(rs.getString(2));
			passageiro.setCpf(rs.getString(3));
			passageiro.setNascimento(new Utils().formataData(rs.getString(4)));
			passageiro.setSexo(new Utils().formataStringParaSexo(rs.getString(5)));
			lista.add(passageiro);
		}
		rs.close();
		ps.close();
		conn.close();

		return lista;
	}
}
