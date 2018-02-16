package br.com.teste.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.teste.bo.MotoristaBO;

/**
 * Servlet implementation class ControllerEdicao
 */
@WebServlet("/ControleEdicao")
public class ControllerEdicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sessao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerEdicao() {
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
			pesquisaMotorista(request, response);
			break;
		case "2":
			alteraStatusMotorista(request, response);
			break;
		}
	}

	protected void pesquisaMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);
		try {
			sessao.setAttribute("ListaMotoristaPesquisados",
					new MotoristaBO().pesquisaMotorista(Integer.parseInt(request.getParameter("id"))));
			response.sendRedirect("altera.jsp");
		} catch (NumberFormatException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO PESQUISAR MOTORISTA",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO PESQUISAR MOTORISTA",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}

	protected void alteraStatusMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sessao = request.getSession(true);
		try {
			new MotoristaBO().alteraStatusMotorista(Integer.parseInt(request.getParameter("radio_status")),
					Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("motorista.jsp");

		} catch (NumberFormatException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO AO ALTERAR STATUS DO MOTORISTA",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			new ControllerErro().erro(request, response, "OCORREU UM ERRO INTERNO DESCONHECIDO",
					"O erro pode ter occorrido devido a uma falha interna no sistema ou no BANCO DE DADOS. TENTE NOVAMENTE");
		}
	}
}
