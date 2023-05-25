package br.com.lojavirtual.teste;

import br.com.lojavirtual.dao.CategoriaDAO;
import br.com.lojavirtual.dao.ProdutoDAO;
import br.com.lojavirtual.modelo.Categoria;
import br.com.lojavirtual.factory.ConnectionFactory;
import br.com.lojavirtual.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategoria {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaCategoria = categoriaDAO.listar();
            listaCategoria.forEach(lc -> {
                System.out.println(lc.getNome());
                try {
                    for(Produto produto : new ProdutoDAO(connection).buscar(lc)){
                        System.out.println(lc.getNome() + " - " + produto.getNome());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }
}