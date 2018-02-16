package br.com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.to.Motorista;
import br.com.teste.utils.Utils;

public class MotoristaDAO {
	private Connection conn = null;

	public MotoristaDAO() {
		ConnectionManager.getInstance();
		conn = ConnectionManager.getConnection();
	}

	public void cadastrarMotorista(Motorista motorista) throws SQLException {
		String sql = "INSERT INTO TB_TESTE_MOTORISTA (nome, nascimento, cpf, modelo, status, id_sexo) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, motorista.getNome());
		ps.setString(2, new Utils().inverteData(new Utils().inverteData(motorista.getNascimento())));
		ps.setString(3, motorista.getCpf());
		ps.setString(4, motorista.getModelo());
		ps.setInt(5, new Utils().formataBooleanParaInt(motorista.isStatus()));
		ps.setInt(6, new Utils().formataSexoParaInt(motorista.getSexo()));
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	public ArrayList<Motorista> listaMotoristas() throws SQLException {
		String sql = "SELECT M.id, M.nome, M.cpf, M.nascimento, M.modelo, M.status, S.sexo FROM TB_TESTE_MOTORISTA M JOIN TB_TESTE_SEXO S ON M.id_sexo = S.id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Motorista> lista = new ArrayList<Motorista>();
		Motorista motorista = null;
		while (rs.next()) {
			motorista = new Motorista();
			motorista.setId(rs.getInt(1));
			motorista.setNome(rs.getString(2));
			motorista.setCpf(rs.getString(3));
			motorista.setNascimento(new Utils().formataData(rs.getString(4)));
			motorista.setModelo(rs.getString(5));
			motorista.setStatus(new Utils().formataIntParaBoolean(rs.getInt(6)));
			motorista.setSexo(new Utils().formataStringParaSexo(rs.getString(7)));
			lista.add(motorista);
		}
		rs.close();
		ps.close();
		conn.close();

		return lista;
	}

	public void alteraStatusMotorista(int status, int id) throws SQLException {
		String sql = "UPDATE TB_TESTE_MOTORISTA SET status = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, status);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	public ArrayList<Motorista> pesquisaMotorista(int id) throws SQLException {
		String sql = "SELECT M.id, M.nome, M.cpf, M.nascimento, M.modelo, M.status, S.sexo FROM TB_TESTE_MOTORISTA M JOIN TB_TESTE_SEXO S ON M.id_sexo = S.id WHERE M.id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		ArrayList<Motorista> lista = new ArrayList<Motorista>();
		Motorista motorista = new Motorista();
		while (rs.next()) {
			motorista.setId(rs.getInt(1));
			motorista.setNome(rs.getString(2));
			motorista.setCpf(rs.getString(3));
			motorista.setNascimento(new Utils().formataData(rs.getString(4)));
			motorista.setModelo(rs.getString(5));
			motorista.setStatus(new Utils().formataIntParaBoolean(rs.getInt(6)));
			motorista.setSexo(new Utils().formataStringParaSexo(rs.getString(7)));

			lista.add(motorista);
		}

		return lista;
	}
};