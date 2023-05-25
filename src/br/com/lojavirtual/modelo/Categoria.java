package br.com.lojavirtual.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

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

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
