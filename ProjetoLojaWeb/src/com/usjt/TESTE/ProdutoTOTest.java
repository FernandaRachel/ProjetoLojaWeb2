package com.usjt.TESTE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.usjt.TO.ProdutoTO;




public class ProdutoTOTest {
	ProdutoTO to = new ProdutoTO();
	
	@Before
	public void ValoresdeInserção(){
		to.setId(5);
		to.setQtd(150);
		to.setValor(45.0);
		to.setNome("Ana");
		to.setMarca("Nike");
		to.setFornecedor("Pedro");
		
	}
	
	@Test
	public void TesteGets() {
		assertEquals("OGetDeIdÉ5", to.getId(), 5);
		assertEquals("OGetQtd150", to.getQtd(), 150);
		assertEquals("OGetgetValor", to.getValor(), 45.0 , 45.0);
		assertEquals("OGetgetNome", to.getNome(), "Ana");
		assertEquals("OgetMarca", to.getMarca(), "Nike");
		assertEquals("OgetFornecedor", to.getFornecedor(), "Pedro");
	}

}
