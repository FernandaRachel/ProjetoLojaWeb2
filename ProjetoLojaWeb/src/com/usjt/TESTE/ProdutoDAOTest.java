package com.usjt.TESTE;

import org.junit.Test;

import com.usjt.DAO.ProdutoDAO;
import com.usjt.TO.ProdutoTO;

public class ProdutoDAOTest {

	ProdutoDAO dao = new ProdutoDAO();
	
	@Test
	public void testIncluir() {
		ProdutoTO to = null;
		dao.incluir(to);
	}

	@Test
	public void testExcluir() {
		ProdutoTO to = null;
		dao.excluir(to);	}

	@Test
	public void testCarregar() {
		int id= (Integer) null;
		dao.carregar(id);	
		}

	@Test
	public void testAtualizar() {
		ProdutoTO to = null;
		dao.excluir(to);
	}

}
