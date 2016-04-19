package com.usjt.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Funcionario;
import com.usjt.TO.FuncionarioTO;

@WebServlet("/FuncionarioController.do")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pID = request.getParameter("func");
		String pUser = request.getParameter("user");
		String pSenha = request.getParameter("senha");
		String pRG = request.getParameter("rg");
		String event = request.getParameter("event");
		

		int id = -1;
		
		try {
			
			id= Integer.parseInt(pID);

		} catch (Exception e) {
			id = -1;
		}
		
		Funcionario f = new Funcionario(id, pUser, pSenha, pRG);
		

		if (event.equals("Cadastrar")) {
			f.criar();
		} else if (event.equals("Excluir")) {
			f.excluir();
		} else if (event.equals("Atualizar")) {
			f.atualizar();
		} else {
			f.carregar();
		}

		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(f.getIdFuncionario());
		to.setUsuario(f.getUsuario());
		to.setSenha(f.getSenha());
		to.setRg(f.getRg());

		request.setAttribute("funcionario", to);

		RequestDispatcher view = request.getRequestDispatcher("Funcionario.jsp");
		view.forward(request, response);

	}
}
