package br.com.lojavirtual.teste;

import br.com.lojavirtual.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory criaConexao = new ConnectionFactory();
        Connection con = criaConexao.recuperarConexao();


        con.close();
    }
}
