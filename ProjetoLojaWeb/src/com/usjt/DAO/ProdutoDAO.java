package com.usjt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usjt.ProjetoSJ.ConnectionFactory;
import com.usjt.TO.ProdutoTO;

public class ProdutoDAO {

	public void incluir(ProdutoTO to) {
		
		String sqlInsert = "INSERT INTO PRODUTO (QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR) VALUES (?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getQtd());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getMarca());
			stm.setString(5, to.getFornecedor());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(sqlSelect); ResultSet rs = stm1.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // Fim inserir
	
	public void atualizar(ProdutoTO to) {
		String sqlUpdate = "UPDATE PRODUTO SET QNT_ESTOQUE = ?, VALOR = ?, NOME = ?, MARCA = ?, FORNECEDOR = ? WHERE idProduto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {

			stm.setInt(1, to.getQtd());
			stm.setDouble(2, to.getValor());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getMarca());
			stm.setString(5, to.getFornecedor());
			stm.setInt(6, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(ProdutoTO to) {
		String sqlDelete = "DELETE FROM PRODUTO WHERE idProduto = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	} // Fim excluir

	public ProdutoTO carregar(int id) {

		ProdutoTO to = new ProdutoTO();
		//to.setId(id);
		String sqlSelect = "SELECT QNT_ESTOQUE, VALOR, NOME, MARCA, FORNECEDOR FROM Produto WHERE idProduto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setInt(1, id);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setQtd(rs.getInt("QNT_ESTOQUE"));
					to.setValor(rs.getDouble("VALOR"));
					to.setNome(rs.getString("NOME"));
					to.setMarca(rs.getString("MARCA"));
					to.setFornecedor(rs.getString("FORNECEDOR"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return to;
	} // Fim Carregar
}
