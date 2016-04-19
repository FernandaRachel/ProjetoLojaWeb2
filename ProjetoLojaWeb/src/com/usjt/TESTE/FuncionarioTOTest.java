package com.usjt.TESTE;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.usjt.TO.FuncionarioTO;

public class FuncionarioTOTest {

	FuncionarioTO to = new FuncionarioTO();

	@Before
	public void ValoresdeInserção() {
		to.setIdFuncionario(100);
		to.setUsuario("Joaozinho");
		to.setSenha("123456");
		to.setRg("246");
		to.setLogado(true);

	}

	@Test
	public void TesteGets() {
		assertEquals("OGetDeIdÉ100", to.getIdFuncionario(), 100);
		assertEquals("OGetedUsuario", to.getUsuario(), "Joaozinho");
		assertEquals("OGetSenha", to.getSenha(), "123456");
		assertEquals("OGetRG", to.getRg(), "246");
		assertEquals("OGetLogado", to.getLogado(), true);
	}

}
