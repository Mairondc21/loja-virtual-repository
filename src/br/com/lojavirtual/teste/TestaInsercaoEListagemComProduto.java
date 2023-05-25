package br.com.lojavirtual.teste;

import br.com.lojavirtual.factory.ConnectionFactory;
import br.com.lojavirtual.dao.ProdutoDAO;
import br.com.lojavirtual.modelo.Produto;
import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Comoda", "Comoda Vertical");

        try (Connection con = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con);
            produtoDAO.salvar(comoda);
            List<Produto> listaProdutos = produtoDAO.listar();
            listaProdutos.forEach(lp -> System.out.println(lp));
        }

        }
    }



