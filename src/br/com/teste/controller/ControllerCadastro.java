package br.com.teste.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.bo.CorridaBO;
import br.com.teste.bo.MotoristaBO;
import br.com.teste.bo.PassageiroBO;
import br.com.teste.exceptions.FormatoDataIncorretoException;
import br.com.teste.to.Corrida;
import br.com.teste.to.Motorista;
import br.com.teste.to.Passageiro;
import br.com.teste.utils.Utils;

/**
 * Servlet implementation class ControllerCadastro
 */
@WebServlet("/ControleCadastro")
public class ControllerCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerCadastro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcao = request.getParameter("opt");

		switch (opcao) {
		case "1":
			cadastraPassageiro(request, response);
			break;
		case "2":
			cadastraMotorista(request, response);
			break;
		case "3":
			cadastraCorrida(request, response);
			break;
		}
	}

	protected void cadastraPassageiro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Passageiro passageiro = new Passageiro();
			passageiro.setNome(request.getParameter("nome"));
			passageiro.setCpf(request.getParameter("cpf"));
			passageiro.setNascimento(request.getParameter("nascimento"));
			passageiro.setSexo(new Utils().formataStringParaSexo(request.getParameter("radio_sexo")));

			new PassageiroBO().cadastraPassageiro(passageiro);
			response.sendRedirect("passageiro.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO CADASTRAR PASSAGEIRO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (FormatoDataIncorretoException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "A DATA FOI DIGITADA INCORRETAMENTE",
					"Digite a data exatamente nesse formato: DD/MM/YYYY, exemplo: 19/12/1998, incluindo as barras. VOLTE E TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}

	protected void cadastraMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Motorista motorista = new Motorista();
			motorista.setNome(request.getParameter("nome"));
			motorista.setCpf(request.getParameter("cpf"));
			motorista.setNascimento(request.getParameter("nascimento"));
			motorista.setModelo(request.getParameter("modelo"));
			motorista.setStatus(true);
			motorista.setSexo(new Utils().formataStringParaSexo(request.getParameter("radio_sexo")));

			new MotoristaBO().cadastrarMotorista(motorista);
			response.sendRedirect("motorista.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO CADASTRAR MOTORISTA",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (FormatoDataIncorretoException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "A DATA FOI DIGITADA INCORRETAMENTE",
					"Digite a data exatamente nesse formato: DD/MM/YYYY, exemplo: 19/12/1998, incluindo as barras. VOLTE E TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}

	protected void cadastraCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Passageiro passageiro = new Passageiro();
			Motorista motorista = new Motorista();
			Corrida corrida = new Corrida();
			passageiro.setId(Integer.parseInt(request.getParameter("passageiro")));
			motorista.setId(Integer.parseInt(request.getParameter("motorista")));
			corrida.setValor(Double.parseDouble(request.getParameter("valor")));
			corrida.setPassageiro(passageiro);
			corrida.setMotorista(motorista);

			new CorridaBO().cadastraCorrida(corrida);
			response.sendRedirect("corrida.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO CADASTRAR CORRIDA",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}
}
