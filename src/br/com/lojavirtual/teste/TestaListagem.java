package br.com.lojavirtual.teste;

import java.sql.*;


public class TestaListagem {
    public static void main(String[] args) throws SQLException {
       ConnectionFactory criaConexao = new ConnectionFactory();
       Connection con = criaConexao.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("SELECT *FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            System.out.println(id);

            String nome = rst.getNString("NOME");
            System.out.println(nome);

            String descricao = rst.getNString("DESCRICAO");
            System.out.println(descricao);
        }

        con.close();

    }
}