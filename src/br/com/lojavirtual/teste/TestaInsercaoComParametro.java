package br.com.lojavirtual.teste;

import br.com.lojavirtual.factory.ConnectionFactory;

import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao()
        ) {
            con.setAutoCommit(false);

            try (
                    PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS)
            ) {

                adicionarVariavel("SmartTv", "45 polegadas", stm);
                adicionarVariavel("Radio", "Radio de bateria", stm);

                con.commit();


            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                con.rollback();
            }


        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()

        ) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("o id criado foi " + id);
            }
        }
    }
}
