package com.usjt.TESTE;

import org.junit.Test;

import com.usjt.DAO.FuncionarioDAO;
import com.usjt.TO.FuncionarioTO;

public class FuncionarioDAOTest {

	FuncionarioDAO dao = new FuncionarioDAO();
	

	
	@Test(expected = Exception.class)
	public void testIncluir() {
		FuncionarioTO to = null;
		dao.incluir(to);
	}

	@Test(expected = Exception.class)
	public void testAtualizar() {
		FuncionarioTO to = null;
		dao.excluir(to);
	}

	@Test(expected = Exception.class)
	public void testExcluir() {
		FuncionarioTO to = null;
		dao.excluir(to);
	}

}
