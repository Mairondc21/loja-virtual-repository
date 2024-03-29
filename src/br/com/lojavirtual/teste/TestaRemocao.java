package br.com.lojavirtual.teste;

import br.com.lojavirtual.factory.ConnectionFactory;

import java.sql.*;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao();
        ) {
            try (PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
            ) {
                stm.setInt(1, 3);
                stm.execute();

                Integer linhasModificadas = stm.getUpdateCount();

                System.out.println(linhasModificadas);
            }
        }
    }
}