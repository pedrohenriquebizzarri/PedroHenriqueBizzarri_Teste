package br.com.teste.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.teste.bo.CorridaBO;
import br.com.teste.bo.MotoristaBO;
import br.com.teste.bo.PassageiroBO;

/**
 * Servlet implementation class ControllerLista
 */
@WebServlet("/ControleLista")
public class ControllerLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLista() {
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
			listaPassageiros(request, response);
			break;
		case "2":
			listaMotoristas(request, response);
			break;
		case "3":
			listaCorridas(request, response);
			break;

		}
	}

	protected void listaPassageiros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);

		try {
			sessao.setAttribute("ListaPassageiros", new PassageiroBO().listaPassageiros());
			response.sendRedirect("passageiro.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response,
					"OCORREU UM ERRO AO TRAZER OS DADOS DO PASSAGEIRO DO BANCO DE DADOS",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}

	protected void listaMotoristas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);

		try {
			sessao.setAttribute("ListaMotoristas", new MotoristaBO().listaMotoristas());
			response.sendRedirect("motorista.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response,
					"OCORREU UM ERRO AO TRAZER DADOS DO MOTORISTA DO BANCO DE DADOS",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}

	}

	protected void listaCorridas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);

		try {
			sessao.setAttribute("ListaPassageiros", new PassageiroBO().listaPassageiros());
			sessao.setAttribute("ListaMotoristas", new MotoristaBO().listaMotoristas());
			sessao.setAttribute("ListaCorridas", new CorridaBO().listaCorridas());
			response.sendRedirect("corrida.jsp");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response,
					"OCORREU UM ERRO AO TRAZER OS DADOS DA CORRIDA DO BANCO DE DADOS",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}
}
