package br.com.teste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsavel por abrir a conexão com o BANCO DE DADOS
 * 
 * @author PEDRO HENRIQUE
 *
 */
class ConnectionManager {
	private static ConnectionManager instance;

	private ConnectionManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao importar DRIVER JDBC " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ConnectionManager getInstance() {
		try {
			if (instance == null) {
				instance = new ConnectionManager();
			}
		} catch (Exception e) {
			System.out.println("Erro ao criar INSTANCIA" + e.getMessage());
			e.printStackTrace();
		}

		return instance;
	}

	public static Connection getConnection() {
		String usuario = "smartroot";
		String senha = "narcodigos@2018";
		String jdbcUrl = "jdbc:mysql://smartfactory.mysql.uhserver.com/smartfactory";

		try {
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o BANCO DE DADOS " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
