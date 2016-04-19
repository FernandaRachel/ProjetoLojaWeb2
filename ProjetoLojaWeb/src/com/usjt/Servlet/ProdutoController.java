package com.usjt.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usjt.ProjetoSJ.Produto;
import com.usjt.TO.ProdutoTO;

@WebServlet("/ManterProduto.do")
public class ProdutoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		String pQtd = request.getParameter("qtd");
		String pValor = request.getParameter("valor");
		String pNome = request.getParameter("nome");
		String pMarca = request.getParameter("marca");
		String pForn = request.getParameter("fornecedor");
		String event = request.getParameter("event");
		
		double valor = 0.0;
		int qtd = 0;
		
		int id = -1;

		try {
			id = Integer.parseInt(pId);
			valor = Double.parseDouble(pValor);
			qtd = Integer.parseInt(pQtd);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Produto p = new Produto(id, qtd, valor, pNome, pMarca, pForn);
		RequestDispatcher view = null;
		
		ProdutoTO to = new ProdutoTO();
		to.setId(p.getId());
		to.setQtd(p.getQtd());
		to.setValor(p.getValor());
		to.setNome(p.getNome());
		to.setMarca(p.getMarca());
		to.setFornecedor(p.getFornecedor());

		if (event.equals("Cadastrar")) {
			p.criar();
			ArrayList<ProdutoTO> lista = new ArrayList<>();
			lista.add(p.getTO());
			request.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarProdutos.jsp");
		} else if (event.equals("Excluir")) {
			p.delete();
			view = request.getRequestDispatcher("ListarProdutos.jsp");			
		} else if (event.equals("Atualizar")) {
			p.atualizar();
			request.setAttribute("cliente", p.getTO());
			view = request.getRequestDispatcher("VisualizarProduto.jsp");
		} else {
			//p.setId(id);
			p.carregar();
			request.setAttribute("cliente", p.getTO());
			
		}

		//request.setAttribute("produto", to);
		//RequestDispatcher view = request.getRequestDispatcher("Produtos.jsp");
		view.forward(request, response);

	}

}
