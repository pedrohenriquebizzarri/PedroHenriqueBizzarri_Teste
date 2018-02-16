package br.com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.to.Corrida;
import br.com.teste.to.Motorista;
import br.com.teste.to.Passageiro;
import br.com.teste.utils.Utils;

public class CorridaDAO {
	private Connection conn = null;

	public CorridaDAO() {
		ConnectionManager.getInstance();
		conn = ConnectionManager.getConnection();
	}

	public void cadastraCorrida(Corrida corrida) throws SQLException {
		String sql = "INSERT INTO TB_TESTE_CORRIDA (id_motorista, id_passageiro, valor) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, corrida.getMotorista().getId());
		ps.setInt(2, corrida.getPassageiro().getId());
		ps.setDouble(3, corrida.getValor());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	public ArrayList<Corrida> listaCorridas() throws SQLException {
		String sql = "SELECT C.id, C.valor, P.id, P.nome, P.cpf, P.nascimento, SP.sexo, M.id, M.nome, M.cpf, M.nascimento, M.modelo, M.status, SM.sexo FROM TB_TESTE_CORRIDA C JOIN TB_TESTE_MOTORISTA M ON C.id_motorista = M.id JOIN TB_TESTE_PASSAGEIRO P ON C.id_passageiro = P.id JOIN TB_TESTE_SEXO SP ON P.id_sexo = SP.id JOIN TB_TESTE_SEXO SM ON M.id_sexo = SM.id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Corrida> lista = new ArrayList<Corrida>();
		Passageiro passageiro = null;
		Motorista motorista = null;
		Corrida corrida = null;
		while (rs.next()) {
			passageiro = new Passageiro();
			passageiro.setId(rs.getInt(3));
			passageiro.setNome(rs.getString(4));
			passageiro.setCpf(rs.getString(5));
			passageiro.setNascimento(new Utils().formataData(rs.getString(6)));
			passageiro.setSexo(new Utils().formataStringParaSexo(rs.getString(7)));
			motorista = new Motorista();
			motorista.setId(rs.getInt(8));
			motorista.setNome(rs.getString(9));
			motorista.setCpf(rs.getString(10));
			motorista.setNascimento(new Utils().formataData(rs.getString(11)));
			motorista.setModelo(rs.getString(12));
			motorista.setStatus(new Utils().formataIntParaBoolean(rs.getInt(13)));
			motorista.setSexo(new Utils().formataStringParaSexo(rs.getString(14)));
			corrida = new Corrida();
			corrida.setId(rs.getInt(1));
			corrida.setPassageiro(passageiro);
			corrida.setMotorista(motorista);
			corrida.setValor(rs.getDouble(2));
			lista.add(corrida);
		}
		rs.close();
		ps.close();
		conn.close();

		return lista;
	}
}
