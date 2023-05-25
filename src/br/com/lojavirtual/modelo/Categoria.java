package br.com.lojavirtual.modelo;

public class Categoria {
    private Integer id;
    private String nome;

    public Categoria(Integer ID, String nome) {
        this.id = ID;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }
}
