package com.usjt.TO;

public class ProdutoTO {
	private int qtd, id;
	   private double valor; 
	   private String nome, marca, fornecedor; 

	   public ProdutoTO (int id, int qtd, double valor, String nome, String marca, String fornecedor){
	      this.id = id;
	      this.qtd = qtd;
	      this.valor = valor;
	      this.nome = nome;
	      this.marca = marca;
	      this.fornecedor = fornecedor;
	   }
	   
	   public ProdutoTO(){
	   
	   }
	   
	   public ProdutoTO(int id){
	      this.id = id;
	   }
	      
	   public int getId() {
			return id;
		}

	   public void setId(int id) {
			this.id = id;
		}
	   
	   public int getQtd(){
	      return qtd;
	   }
	   
	   public double getValor(){
	      return valor;
	   }
	   
	   public String getNome(){
	      return nome;
	   }
	   
	   public String getMarca(){
	      return marca;
	   }
	   
	   public String getFornecedor(){
	      return fornecedor;
	   }
	   
	   public void setQtd(int qtd){
	      this.qtd = qtd;
	   }
	   
	   public void setValor(double valor){
	      this.valor = valor;
	   }
	   
	   public void setNome(String nome){
	      this.nome = nome;
	   }
	   
	   public void setMarca(String marca){
	      this.marca = marca;
	   }
	   
	   public void setFornecedor(String fornecedor){
	      this.fornecedor = fornecedor;
	   }
	 


}
