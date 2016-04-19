package com.usjt.ProjetoSJ;

import java.util.ArrayList;

import com.usjt.DAO.FuncionarioDAO;
import com.usjt.TO.FuncionarioTO;
import com.usjt.TO.ProdutoTO;
import com.usjt.TO.*;
import com.usjt.DAO.*;

public class Funcionario {

	private int idFuncionario;
	private String usuario;
	private String senha;
	private String rg;
	private boolean logado = false;

	public Funcionario(int idFuncionario, String usuario, String senha, String rg) {
		this.idFuncionario = idFuncionario;
		this.usuario = usuario;
		this.senha = senha;
		this.rg = rg;
		//this.logado = logado;
	}
	public Funcionario(String usuario, String senha, String rg) {
		this.usuario = usuario;
		this.senha = senha;
		this.rg = rg;
	}

	public Funcionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Funcionario() {
		
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public void criar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		//to.setIdFuncionario(idFuncionario);
		to.setUsuario(this.getUsuario());
		to.setSenha(this.getSenha());
		to.setRg(this.getRg());
		dao.incluir(to);
	}

	public void atualizar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(this.getIdFuncionario());
		to.setUsuario(this.getUsuario());
		to.setSenha(this.getSenha());
		to.setRg(this.getRg());
		dao.atualizar(to);
	}

	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = new FuncionarioTO();
		to.setIdFuncionario(idFuncionario);
		dao.excluir(to);
	}

	public void carregar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		FuncionarioTO to = dao.carregar(idFuncionario);
		// idFuncionario = to.getIdFuncionario();
		
		to.setIdFuncionario(this.getIdFuncionario());
		to.setUsuario(this.getUsuario());
		to.setSenha(this.getSenha());
		to.setRg(this.getRg());
		

	}
	
	public ListadeProdutos listarProdutos(){
		ListadeProdutos lista;
		FuncionarioDAO dao = new FuncionarioDAO();
		lista = dao.listarProdutos();
		return lista;
	}
	public ListadeProdutos listarProdutos(String chave){
		ListadeProdutos lista;
		FuncionarioDAO dao = new FuncionarioDAO();
		lista = dao.listarProdutos(chave);
		return lista;
	}
		

	/*@Override
	public String toString() {
		return "Cliente [id:" + idFuncionario + ", Usuario:" + usuario + ", Senha:" + senha + "RG:" + rg + "]";
	}*/

}
