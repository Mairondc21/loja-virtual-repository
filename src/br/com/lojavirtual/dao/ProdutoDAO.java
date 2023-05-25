package br.com.lojavirtual.dao;

import br.com.lojavirtual.modelo.Categoria;
import br.com.lojavirtual.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }
    public List<Produto> listar() throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Produto produto =
                            new Produto(rst.getInt(1),rst.getNString(2),rst.getNString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria lc) throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT ID,NOME,DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            pstm.setInt(1,lc.getId());

            try (ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Produto produto =
                            new Produto(rst.getInt(1),rst.getNString(2),rst.getNString(3));
                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}
