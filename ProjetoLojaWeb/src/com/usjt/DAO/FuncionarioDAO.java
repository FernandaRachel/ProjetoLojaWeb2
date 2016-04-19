package com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.usjt.ProjetoSJ.ConnectionFactory;
import com.usjt.TO.FuncionarioTO;
import com.usjt.TO.ListadeProdutos;
import com.usjt.TO.ProdutoTO;

public class FuncionarioDAO {

	public void incluir(FuncionarioTO to) {

		String sqlInsert = "INSERT INTO FUNCIONARIO (USUARIO, SENHA, RG) VALUES (?,?,?)";

		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getUsuario());
			stm.setString(2, to.getSenha());
			stm.setString(3, to.getRg());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(sqlSelect); 
					ResultSet rs = stm1.executeQuery();) {
				if (rs.next()) {
					to.setIdFuncionario(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim inserir

	public void atualizar(FuncionarioTO to) {
		String sqlUpdate = "UPDATE FUNCIONARIO SET USUARIO = ?, SENHA = ?, rg = ? WHERE idFuncionario = ?";
		

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			

			stm.setString(1, to.getUsuario());
			stm.setString(2, to.getSenha());
			stm.setString(3, to.getRg());
			stm.setInt(4, to.getIdFuncionario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public FuncionarioTO carregar(int id) {

		FuncionarioTO to = new FuncionarioTO();
		//to.setIdFuncionario(id);

		String sqlSelect = "SELECT  usuario, senha, rg  FROM Funcionario WHERE IdFuncionario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					//to.setIdFuncionario(rs.getInt("IdFuncionario"));
					to.setUsuario(rs.getString("usuario"));
					to.setSenha(rs.getString("senha"));
					to.setRg(rs.getString("rg"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public void excluir(FuncionarioTO to) {
		String sqlDelete = "DELETE FROM FUNCIONARIO WHERE idFuncionario = ?";
		// PreparedStatement stm = null; --> DUVIDA (?) Por q o
		// PreparedStatement n começa como NULL???

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, to.getIdFuncionario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim excluir

	
	public ListadeProdutos listarProdutos() {
		ProdutoTO to;
		ArrayList<ProdutoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR FROM Produto WHERE idProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new ProdutoTO();
					stm.setInt(1, 1);
					to.setId(rs.getInt("idProduto"));
					to.setQtd(rs.getInt("qtd"));
					to.setValor(rs.getDouble("valor"));
					to.setNome(rs.getString("nome"));
					to.setMarca(rs.getString("marca"));
					to.setFornecedor(rs.getString("fornecedor"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListadeProdutos ldc = new ListadeProdutos();
		ldc.setProdutos(lista);
		return ldc;
		//return lista;
	}
	
	public ListadeProdutos listarProdutos(String chave) {
		ProdutoTO to;
		ArrayList<ProdutoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR FROM Produto WHERE idProduto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new ProdutoTO();
					to.setId(rs.getInt("idProduto"));
					to.setQtd(rs.getInt("qtd"));
					to.setValor(rs.getDouble("valor"));
					to.setNome(rs.getString("nome"));
					to.setMarca(rs.getString("marca"));
					to.setFornecedor(rs.getString("fornecedor"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListadeProdutos ldc = new ListadeProdutos();
		ldc.setProdutos(lista);
		return ldc;
		//return lista;
	}
}
