package com.usjt.ProjetoSJ;

import com.usjt.DAO.ProdutoDAO;
import com.usjt.TO.ProdutoTO;




public class Produto {

	private int qtd, id;
	private double valor;
	private String nome, marca, fornecedor;

	public Produto(int id, int qtd, double valor, String nome, String marca, String fornecedor) {
		this.id = id;
		this.qtd = qtd;
		this.valor = valor;
		this.nome = nome;
		this.marca = marca;
		this.fornecedor = fornecedor;
	}

	public Produto() {

	}

	public Produto(int id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public ProdutoTO getTO() {
		ProdutoTO to = new ProdutoTO();
		to.setId(id);
		to.setQtd(qtd);
		to.setValor(valor);
		to.setNome(nome);
		to.setMarca(marca);
		to.setFornecedor(fornecedor);
		return to;
	}

	public void criar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		//to.setId(this.getId());
		to.setQtd(this.getQtd());
		to.setValor(this.getValor());
		to.setNome(this.getNome());
		to.setMarca(this.getMarca());
		to.setFornecedor(this.getFornecedor());
		dao.incluir(to);
	}

	public void atualizar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = getTO();
		dao.atualizar(to);
		
	}

	public void delete() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setId(getId());
		dao.excluir(to);
	}

	public void carregar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.carregar(id);
		//to.setId(this.getId());
		to.setQtd(this.getQtd());
		to.setValor(this.getValor());
		to.setNome(this.getNome());
		to.setMarca(this.getMarca());
		to.setFornecedor(this.getFornecedor());
		
	}

	

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoTO other = (ProdutoTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!marca.equals(other.getMarca()))
			return false;
		if (fone == null) {
			if (other.qtd != null)
				return false;
		} else if (!fornecedor.equals(other.getFornecedor()))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}*/

	


}
